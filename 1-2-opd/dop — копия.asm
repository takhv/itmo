ORG	0x2 ; начало
res:	WORD 0x80 ; результат
amogus:	WORD 0x81
sum:	WORD 0x8A
temp:	WORD ? ; временное
finish:	WORD 0xF0 ; равно
plus:	WORD 0xB0 ; плюс
ed: WORD 0x000f
tens: Word 0x00f0
hun: Word 0x0f00
thun: WORD 0xf000
higher_number:	Word ?;
lower_number:	Word 0x9A;

;каждое 32 разрядное число записывается в 2 ячейки, нужно сделать сложение младший частей при помощи add и старших частей при помощи adc, затем прикрутить перевод в 10сс и готово

START:	CLA
s1:	IN 7 ; получение SR
	AND #0x40 ; проверка на готовность
	BEQ s1 ; спин-луп
	IN 6 ; записываем в аккум
	ST (res)
	ST temp
	CMP finish
	BEQ exit
	LD (res)
	CLA
s2:	IN 7 ; ввод второго символа из пары
	AND #0x40 ; проверка на 1 в статусном регистре
	BEQ s2 ; спин луп если 0 в ст. регистре
	IN 6 ; байт в аккум
	SWAB ; скидываем второй символ в старший байт
	OR temp ; соединяем с первым символом
	SWAB
	ST (res) ; сохраняем в результат
	CMP finish ; проверка на символ окончания
	BEQ summ ; 
	LD (res)+
	CLA ; очистка аккум
	JUMP s1 ; прыгаем в начало

summ:
	CLA
	LD (amogus)
	ST temp
	CLA
	LD (res) ; 
	ADC (amogus)
	ST (sum)
	ST temp
	LD (sum)
	CLA
	BEQ exit
	
return:
	RET

exit:	LD (res)+ ; ссылка на результат+1
	HLT ; остановка

	LD lower_number;
	call To10;
	LD deref;
	HLT
To10:    
	ST deref
	and ed; Используем маску чтобы получить единицы
	push
	call check_ed
	and tens
	push
	call check_ten
	RET

check_ed:
	LD &1
	PUSHF
	cmp 0xA;
	BLT ret_ed
	LD deref
	POPF
	ADC #0x06
	ST deref
	
ret_ed:
	SWAP
	ST &1
	SWAP
	SWAP
	pop
	RET

check_ten:
	LD &1
	PUSHF
	cmp 0xA0;
	BLT ret_ed
	LD deref
	POPF
	ADC #0x060
	ST deref
	
ret_ten:  
	SWAP
	ST &1
	SWAP
	SWAP
	pop
	RET
  
deref: Word ?