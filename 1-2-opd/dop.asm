ORG	0x2 ; начало
NUMS:	WORD 0x80 ; результат
TEMP:	WORD ? ; временное
FINISH:	WORD 0x1100 ; равно

ed: WORD 0x000f
tens: Word 0x00f0
hun: Word 0x0f00
thun: WORD 0xf000

higher_number:	Word ?;
lower_number:	Word 0x00;

POINTER:	WORD ?
i:	WORD 0x1
dim:	WORD 0x4

RES1: WORD 0x100
RES2: WORD 0x101

;каждое 32 разрядное число записывается в 2 ячейки, нужно сделать сложение младший частей при помощи add и старших частей при помощи adc, затем прикрутить перевод в 10сс и готово

START:	CLA
s1:	IN 7 ; получение SR
	AND #0x40 ; проверка на готовность
	BEQ s1 ; спин-луп
	IN 6 ; записываем в аккум
	SWAB
	ST (NUMS)
	CMP FINISH
	BEQ SUM ; суммируем если все ввели
	CLA
s2:	IN 7 ; ввод второго символа из пары
	AND #0x40 ; проверка на 1 в статусном регистре
	BEQ s2 ; спин луп если 0 в ст. регистре
	IN 6 ; байт в аккум
	ST TEMP
	LD (NUMS)
	OR TEMP ; соединяем с первым символом
	ST (NUMS) ; сохраняем в результат
	CMP FINISH ; проверка на символ окончания
	BEQ SUM ; 
	LD (NUMS)+
	CLA ; очистка аккум
	JUMP s1 ; прыгаем в начало


SUM:
	LD FNUMS
	ADD SNUMS
	ST RES2
	LD FNUMB
	ADC SNUMB
	ST RES1
	CALL TRANSLATE


	
TRANSLATE:
	LD TEMP 
	CLA
	LD RES2
	CALL CHECKER
	LD TEMP
	ST RES2
	
	LD TEMP 
	CLA
	LD RES1
	CALL CHECKER
	LD TEMP
	ST RES1
	RET

	
CHECKER:
EDCHECK:
	AND ed
	CMP 0xA
	BLT TENCHECK
plus6:	ADC #0x06
	OR TEMP
	ST TEMP
TENCHECK:
	AND tens
	CMP 0xA0
	BLT HUNCHECK
plus6:	ADC #0x060
	OR TEMP
	ST TEMP
HUNCHECK:
	AND hun
	CMP 0xA00
	BLT THUNCHECK
plus6:	ADC #0x0600
	OR TEMP
	ST TEMP
THUNCHECK:
	AND thun
	CMP 0xA000
	BLT RET
plus6:	ADC #0x06
	OR TEMP
	ST TEMP
	RET
	



	ORG 0x80
FNUMB:	WORD ?
FNUMS:	WORD ?
SNUMB:	WORD ?
SNUMS:	WORD ?