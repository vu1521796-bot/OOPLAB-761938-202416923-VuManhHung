import java.util.Scanner;
public class bai2_2_6 {
    static void giaiPTbac1(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh co vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            double x = -b / a;
            System.out.println("Phuong trinh co nghiem x = " + x);
        }
    }
    static void giaiPTbac2(double a, double b, double c) {
        if (a == 0) {
            giaiPTbac1(b, c);
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Phuong trinh vo nghiem");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Phuong trinh co nghiem kep x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phuong trinh co hai nghiem phan biet:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        }
    }
    static void giaihePTbac1(double a1, double b1, double a2, double b2,double c1, double c2) {
        double D = a1 * b2 - a2 * b1;
        double D1 = c1 * b2 - c2 * b1;
        double D2 = a1 * c2 - a2 * c1;
        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("He phuong trinh co vo so nghiem");
            } else {
                System.out.println("He phuong trinh vo nghiem");
            }
        } else {
            double x = D1 / D;
            double y = D2 / D;
            System.out.println("He phuong trinh co nghiem duy nhat:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }
    public static void main(String[] args) {
        Scanner choose =new Scanner(System.in);
        System.out.println("Chon loai phuong trinh can giai:");
        System.out.println("1. Phuong trinh bac nhat");
        System.out.println("2. Phuong trinh bac hai");
        System.out.println("3. He phuong trinh bac nhat");
        int option = choose.nextInt();
        switch (option) {
            case 1:
                 System.out.println("Nhap he so a: ");
                 double a = choose.nextDouble();
                System.out.println("Nhap he so b: ");
                 double b = choose.nextDouble();
                giaiPTbac1(a, b);
                break;
            case 2:
                System.out.println("Nhap he so a: ");
                double a2 = choose.nextDouble();   
                System.out.println("Nhap he so b: ");
                double b2 = choose.nextDouble();
                System.out.println("Nhap he so c: ");
                double c2 = choose.nextDouble();
                giaiPTbac2(a2, b2, c2);
                break;
            case 3:
                System.out.println("Nhap he so a1: ");
                double a3 = choose.nextDouble();
                System.out.println("Nhap he so b1: ");
                double b3 = choose.nextDouble();
                System.out.println("Nhap he so c1: ");
                double c3 = choose.nextDouble();
                System.out.println("Nhap he so a2: ");
                double a4 = choose.nextDouble();
                System.out.println("Nhap he so b2: ");
                double b4 = choose.nextDouble();
                System.out.println("Nhap he so c2: ");
                double c4 = choose.nextDouble();
                giaihePTbac1(a3, b3, a4, b4, c3, c4);
                break;
            default:
                System.out.println("Lua chon khong hop le");
        }

    }
}
