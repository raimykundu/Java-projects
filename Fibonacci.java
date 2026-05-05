
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		System.out.println(fibonacci(10));
	}
	public static int fibonacci(int n) {
		if (n==0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

}
