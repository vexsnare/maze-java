import java.util.Scanner;

public class EduCF1A {
	public static void main(String[] args) {
		long t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			
			n = sc.nextInt();
			long sigN = ((long) n) * (n + 1) / 2;
			long neg = 0;
			int p = 1;
			while (p <= n) {
				neg += p;
				p = p << 1;
			}
			System.out.println(sigN - 2 * neg);
		}
	}

}
