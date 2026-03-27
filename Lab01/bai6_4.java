package displayyear;
import java.util.Scanner;
public class bai6_4 {
	public static void main(String[] args) {
		Scanner data=new Scanner(System.in);
		int year;
		System.out.print("Nhap nam: ");
		year=data.nextInt();
		data.nextLine();
		String month;
		System.out.print("Nhap thang: ");
		month=data.nextLine();
		String[][] allMonths = {
			    {"January", "Jan.", "Jan", "1"},
			    {"February", "Feb.", "Feb", "2"},
			    {"March", "Mar.", "Mar", "3"},
			    {"April", "Apr.", "Apr", "4"},
			    {"May", "May", "5"},
			    {"June", "Jun.", "Jun", "6"},
			    {"July", "Jul.", "Jul", "7"},
			    {"August", "Aug.", "Aug", "8"},
			    {"September", "Sept.", "Sep", "9"},
			    {"October", "Oct.", "Oct", "10"},
			    {"November", "Nov.", "Nov", "11"},
			    {"December", "Dec.", "Dec", "12"}
			};
		int flag=-1;
		for (int i=0;i<allMonths.length;i++) {
			for (int j=0;j<allMonths[i].length;j++) {
				if (month.equals(allMonths[i][j])) {
					flag=i;
					break;
				}
			}
		}
		int countDay=0;
		if (flag==-1) {
			System.out.println("Month ko thoa man");
		}
		else {
			int realMonth=flag+1;
			switch(realMonth) {
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				countDay=31;
				break;
			case 4:case 9:case 11:case 6:
				countDay=30;
			case 2:
				if((year%4==0 && year%100!=0) || year%400==0) {
					countDay=29;
					break;
				}
				else {
					countDay=28;
					break;
				}
			}
		}
		System.out.println("Co "+countDay+" Ngay");
	}
}
