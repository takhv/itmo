	ORG 0x40
RES1:	WORD 0x80 ; результат
RES2:	WORD 0x80 ; доп ссылка на результат

STOPPER:	WORD 0x00 ; стоп-символ
i:	WORD 0x0 ; счетчик
N:	WORD 0x0 ; кол-во чисел (должно быть 2)
POINTER: 	WORD ? 

TEMP:	WORD ?
TEMP2:	WORD ?
NUM1:	WORD ?
NUM2:	WORD ?
RESULT1:	WORD ?
RESULT2:	WORD ?

ed: WORD 0x000f
tens: Word 0x00f0
hun: Word 0x0f00
thun: WORD 0xf000

NEWTEMP:	WORD ?
NEWTEMP2:	WORD ?

HELP:	WORD ?

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
	LD N
	INC ; увеличиваем кол-во ячеек
	ST N
	JUMP s1
	
CON:
	LD RES2
	ST POINTER
NEXT:	
	LD (POINTER)+ ; суммируем все части чисел и записываем в темпы
	ST NUM1
	LD (POINTER)+
	ST NUM2
	CALL SUMMATOR
	LD i
	CMP N
	BZS CHECK ; когда все - переводим в 10сс
	INC
	ST i
	JUMP NEXT
	
SUMMATOR:
	LD RESULT2
	ADD NUM2
	ST RESULT2
	LD RESULT1
	ADC NUM1
	ST RESULT1
	RET

CHECK:
	LD TEMP
	CALL CHECKER1
	LD TEMP2
	CALL CHECKER2

CHECKER1:
EDCHECK:
	AND ed
	CMP 0xA
	BLT TENCHECK
plus6:	ADC #0x06
	OR NEWTEMP
	ST NEWTEMP
TENCHECK:
	AND tens
	CMP 0xA0
	BLT HUNCHECK
plus6:	ADC #0x060
	OR NEWTEMP
	ST NEWTEMP
HUNCHECK:
	AND hun
	CMP 0xA00
	BLT THUNCHECK
plus6:	ADC #0x0600
	OR NEWTEMP
	ST NEWTEMP
THUNCHECK:
	AND thun
	CMP 0xA000
	BLT RET
plus6:	ADC #0x06
	OR NEWTEMP
	ST NEWTEMP
	RET

CHECKER2:
EDCHECK:
	AND ed
	CMP 0xA
	BLT TENCHECK
plus6:	ADC #0x06
	OR NEWTEMP2
	ST NEWTEMP2
TENCHECK:
	AND tens
	CMP 0xA0
	BLT HUNCHECK
plus6:	ADC #0x060
	OR NEWTEMP2
	ST NEWTEMP2
HUNCHECK:
	AND hun
	CMP 0xA00
	BLT THUNCHECK
plus6:	ADC #0x0600
	OR NEWTEMP2
	ST NEWTEMP2
THUNCHECK:
	AND thun
	CMP 0xA000
	BLT RET
plus6:	ADC #0x06
	OR NEWTEMP2
	ST NEWTEMP2
	RET

EXIT:
LMI1:
	LD NEWTEMP
	IN 0x15
	AND #0x40
	BEQ LMI
	OUT 0x14
LMI2:
	LD NEWTEMP2
	IN 0x15
	AND #0x40
	BEQ LMI
	OUT 0x14
	HLT