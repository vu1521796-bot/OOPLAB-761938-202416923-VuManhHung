package Aimsproject;

public class Carts {
	public static final int  MAX_NUMBERS_ORDERED=20;
	private  DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	int qtyOrdered;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered<MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered]=disc;
			qtyOrdered++;
			System.out.println("Da them disc vao carts!");
		}
		else {
			System.out.println("So luong dia da den gioi han!");
			return;
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int idx=-1;
		for (int i=0;i<qtyOrdered;i++) {
			if (itemsOrdered[i]==disc) {
				idx=i;
			}
		}
		if (idx!=-1) {
			for (int i=idx;i<qtyOrdered-1;i++) {
				itemsOrdered[i]=itemsOrdered[i+1];
			}
			itemsOrdered[qtyOrdered-1]=null;
			qtyOrdered--;
			System.out.println("Da xoa disc!");
			
		}
		else {
			System.out.println("Khong tim thay disc yeu cau!");
		}
	}
	public void totalCost() {
		double tong=0;
		for (int i=0;i<qtyOrdered;i++) {
			tong+=itemsOrdered[i].getCost();
		}
		System.out.println("Tong chi phi carts la: "+tong);
	}
	
}
