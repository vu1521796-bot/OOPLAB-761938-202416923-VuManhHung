
import java.util.Scanner;
public class bai6_3 {
	public static void main(String[] args) {
		Scanner data=new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n=data.nextInt();
		for (int i=1;i<=n;i++) {
			for (int k=1;k<=n-i;k++) {
				System.out.print(" ");
			}
			for (int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
