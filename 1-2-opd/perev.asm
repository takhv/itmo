	ORG 0x40
RES1:	WORD 0x80 ; результат
RES2:	WORD 0x80 ; доп ссылка на результат

STOPPER:	WORD 0x00 ; стоп-символ
i:	WORD 0x0 ; счетчик
N:	WORD 0x1 ; кол-во чисел 
POINTER: 	WORD ? 

TEMP:	WORD ?
TEMP2:	WORD ?
NUM1:	WORD ?
NUM2:	WORD ?
RESULT2:	WORD 0x0 ; 4A
RESULT1:	WORD 0x0 ; 4B

HELP:	WORD 0x0

NEWTEMP1:	WORD 0x0
NEWTEMP2:	WORD 0x0

ed: WORD 0x000f
tens: Word 0x00f0
hun: Word 0x0f00
thun: WORD 0xf000
AMOGUS:	WORD 0xA000

START:	CLA

s1:	IN 7 ; получаем первую часть числа
	AND #0x40
	BEQ s1
	IN 6
	ST (RES1)
	ST TEMP ; нужно для соединения частей
	CMP STOPPER ; проверка на стоп-символ
	BEQ CON
	LD (RES1)
	CLA
s2:	IN 7 ; получаем вторую часть числа
	AND #0x40
	BEQ s2
	IN 6
	SWAB
	OR TEMP ; соединяем
	SWAB
	ST (RES1)
	CMP STOPPER
	BEQ CON
	LD (RES1)+ ; след ячейка
	CLA
	JUMP s1

CON:
	LD RES2
	ST POINTER
NEXT:	
	LD (POINTER)+
	ST NUM2
	LD (POINTER)+
	ST NUM1
	CALL SUMMATOR
	LD i
	CMP N
	BZS EXIT 
	INC
	ST i
	JUMP NEXT

EXIT:
	HLT

SUMMATOR:
	LD RESULT1
	ADD NUM1
	ST RESULT1
	LD RESULT2
	ADC NUM2
	ST RESULT2
	RET
