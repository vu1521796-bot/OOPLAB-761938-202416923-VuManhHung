import java.util.Scanner;
public class bai2_2_5 {
    public static void main(String[] args) {
         Scanner data=new Scanner(System.in);
        System.out.println("Nhap so thu nhat: ");
        double num1=data.nextDouble();
        System.out.println("Nhap so thu hai: "); 
        double num2=data.nextDouble();
        System.out.println("Tong hai so la: "+(num1+num2));
        System.out.println("Hieu hai so la: "+(num1-num2));
        System.out.println("Tich hai so la: "+(num1*num2));
        if(num2!=0){
            System.out.println("Thuong hai so la: "+(num1/num2));
        }
        else{
            System.out.println("Khong the chia cho 0");
        }
    }
}
