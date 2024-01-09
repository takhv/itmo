	org 0x40
ADDR_STRT:	WORD 0x687 ; адрес начала массива
dimM:	WORD 0x5 ; кол-во вложенных массивов
i:	WORD 0x1 ; начало отсчета 
POINTER:WORD ? ; 
RESULT1:	WORD ? ; результат
RESULT2:	WORD ?
TEMP:	WORD ? ; вспомогательная переменная
TEMP2:	WORD ?
MAX1:	WORD 0xFFFF
MAX2:	WORD 0xFFFF
MIN1:	WORD 0x7FFF
MIN2:	WORD 0xFFFF
START:
	LD ADDR_STRT ; 
	ST POINTER ; 
	NEXT:
		LD (POINTER)+
		ST TEMP
		LD (POINTER)+
		ST TEMP2
		CALL CHECKER
		LD i
		CMP dimM
		BZS SUM
		INC
		ST i
		JUMP NEXT
	SUM:
		LD MAX2
		ADD MIN2
		ST RESULT2
		LD MAX1
		ADC MIN1
		ST RESULT1
		HLT
CHECKER:
	MAX1_CHECKER: ; ПРОВЕРКА НА МАКСИМАЛЬНУЮ СТАРШУЮ ЧАСТЬ
		LD TEMP
		CMP MAX1 ; СРАВНЕНИЕ С НЫНЕШНЕЙ МАКС ЧАСТЬЮ
		BZS MAX2_CHECKER ; ЕСЛИ РАВНЫ, ТО СРАВНИВАЕМ МЛАДШИЕ ЧАСТИ
		BGE MAX1_SETTER ; ЕСЛИ БОЛЬШЕ ТО MAX1_SETTER
		JUMP MIN1_CHECKER
		MAX1_SETTER:
			ST MAX1 ; СОХРАНЯЕМ МАКСИМАЛЬНУЮ СТАРШУЮ ЧАСТЬ
			LD TEMP2
			ST MAX2
			RET
	MIN1_CHECKER: ; ПРОВЕРКА НА МИНИМАЛЬНУЮ СТАРШУЮ ЧАСТЬ
		LD TEMP
		CMP MIN1 ; СРАВНЕНИЕ С НЫНЕШНЕЙ МИН ЧАСТЬЮ
		BZS MIN2_CHECKER ; ЕСЛИ РАВНЫ, ТО СРАВНИВАЕМ МЛАДШИЕ ЧАСТИ
		BLT MIN1_SETTER ; ЕСЛИ МЕНЬШЕ, ТО MIN1_SETTER
		RET
		MIN1_SETTER:
			ST MIN1 ; СОХРАНЯЕМ МИНИМАЛЬНУЮ СТАРШУЮ ЧАСТЬ
			LD TEMP2
			ST MIN2
			RET
	MAX2_CHECKER: ; ПРОВЕРКА НА МАКСИМАЛЬНУЮ МЛАДШУЮ ЧАСТЬ
		LD TEMP2
		CMP MAX2
		BGE MAX2_SETTER
		RET
		MAX2_SETTER:
			ST MAX2 ; 
			RET
	MIN2_CHECKER: ; 
		LD TEMP2
		CMP MIN2
		BLT MIN2_SETTER
		RET
		MIN2_SETTER:
			ST MIN2 ; 
			RET
	ORG 0x687
WORD 0xAFFF, 0xAAAA
WORD 0x0000, 0xBCDE
WORD 0x0010, 0x5378
WORD 0x0713, 0x1234
WORD 0x0713, 0x4321