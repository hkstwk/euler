package nl.hkolvoort.euler;

public class P031_CoinSums {

	public static void main(String[] args) {
		Integer value = 200;
		Integer count = 0;
		
		for (int a = value; a>=0; a -=200) {
			System.out.println("a = " + a + " " );
			for (int b = a; b >=0; b -=100) {
				System.out.println("b = " + b + " " );
				for (int c=b; c>=0; c -=50) {
					System.out.println("c = " + c + " " );
					for (int d=c; d>=0; d -=20){
						System.out.println("d = " + d + " " );
						for (int e=d; e>=0; e -= 10){
							System.out.println("e = " + e + " " );
							for (int f=e; f >=0; f -=5){
								System.out.println("f = " + f + " " );
								for (int g=f; g>=0; g -=2){
									System.out.println("g = " + g + " \n" );
										System.out.println("Counter is now: " + ++count +"\n");										
								}
							}	
						}
					}
				}
			}
		}

		System.out.println("Number of coin combinations = " + count);
	}

}
