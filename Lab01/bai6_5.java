package sortarray;
import java.util.Scanner;
public class bai6_5 {
	public static void main(String[] args) {
		Scanner data=new Scanner(System.in);
		System.out.print("Nhap so phan tu: ");
		int n=data.nextInt();
		double[] arr=new double[n];
		for (int i=0;i<n;i++) {
			arr[i]=data.nextDouble();
		}
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (arr[i]<arr[j]) {
				double tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
				}
			}
		}
		System.out.print("Mang sau khi sap xep la :");
		for (int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
