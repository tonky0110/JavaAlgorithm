import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x;
		int y;
		
		int h = s.nextInt();
		int m = s.nextInt();
		
		h = m >= 45 ? h : (h-1);
		System.out.println(h + " " + m);
		h = h > 0 ? h : (h+24);
		System.out.println(h + " " + m);
		m = m >= 45 ? m-45 : (m+15);
		
		System.out.println(h + " " + m);
		
	}
}


