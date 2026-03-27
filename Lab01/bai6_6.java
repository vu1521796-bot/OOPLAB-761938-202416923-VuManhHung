import java.util.Scanner;
public class bai6_6 {
    public static void main(String[] args) {
        Scanner data=new Scanner(System.in);
        System.out.print("Nhap so cot cua ma tran: ");
        int c = data.nextInt();
        System.out.print("Nhap so hang cua ma tran: ");
        int r = data.nextInt();
        double[][] a = new double[r][c];
        System.out.println("Nhap ma tran A: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = data.nextDouble();
            }
        }
        System.out.println("Nhap ma tran B: ");
        double[][] b = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j] = data.nextDouble();
            }
        }
        double[][] sum = new double[r][c];
        System.out.println("Tong 2 ma tran A va B la: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum[i][j] = a[i][j] + b[i][j];
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
