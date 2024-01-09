public class Lab0 {
	public static void main (String[] args) {
		long[] c; //
		c = new long[11]; // 11 значений
		for (int i = 0; i<11; i++) {
			c[i] = (6 + 2*i); // от 6 до 16 четные 
		}

		double[] x; //
		x = new double[20]; // 20 значений 
		for (int i = 0; i<20; i++) {
			x[i] = Math.random()*19-7; // генератор значений (19 потому что нужны значени от -7 до 12, а рандом генерит только 0 и 1)
		}
		//System.out.print(Arrays.toString(x));
		
		double[][] C; // оздание двумерного маива
		C = new double[6][20]; // матрица 6*20
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 20; j++){
				if (c[i] == 14) {
					C[i][j] = Math.exp(Math.exp(Math.exp(x[j]))); // 
				} else if (c[i] == 10 || c[i] == 12 || c[i] == 16) {
					C[i][j] = Math.cos(Math.pow((Math.pow(x[j],(x[j]/3))),(Math.asin((x[j] + 2.5)/19)))); // [i] = {10,12,16}
				} else {
					C[i][j] = Math.log(Math.pow(Math.tan(Math.asin(Math.pow(((x[j] + 2.5)/19),2))),2)); // прочие лучаи
				}
			}
		}
		String s;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 20; j++){
				s = String.format("%.5f", C[i][j]); // вывод значений  5 знаками поле ,
				System.out.printf("%10s", s); 
			}
			System.out.println(); // переход на новую трочку
		}
	}
}

