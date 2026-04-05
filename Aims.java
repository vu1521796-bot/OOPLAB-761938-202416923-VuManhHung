package Aimsproject;
import java.util.Scanner;
public class Aims {
	public static void main(String[] args) {
		Scanner data=new Scanner(System.in);
		System.out.print("Nhap so luong dia muon them vao: ");
		int n=data.nextInt();
		DigitalVideoDisc[] numberDisc=new DigitalVideoDisc[n]; 
		 Carts newCarts=new Carts();
		for (int i=0;i<n;i++) {
			String title;
			String category;
			String director;
			int length;
			float cost;
			System.out.println("Nhap ten phim: ");
			title=data.nextLine();
			data.nextLine();
			System.out.println("The loai phim: ");
			category=data.nextLine();
			System.out.println("Nhap dao dien phim: ");
			director=data.nextLine();
			System.out.println("Nhap do dai phim: ");
			length=data.nextInt();
			System.out.println("Nhap gia dia phim: ");
			cost=data.nextFloat();
			numberDisc[i]=new DigitalVideoDisc(title,category,director,length,cost);
			newCarts.addDigitalVideoDisc(numberDisc[i]);
		}
		for (int i=0;i<n;i++) {
			System.out.println("Thong tin dia thu "+(i+1)+": ");
			System.out.println("Ten phim: "+numberDisc[i].getTitle());
			System.out.println("Gia dia phim: "+numberDisc[i].getCost());
		}
		newCarts.totalCost();
		newCarts.removeDigitalVideoDisc(numberDisc[0]);
		newCarts.totalCost();
	}
}
