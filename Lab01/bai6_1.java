package week1;
import javax.swing.JOptionPane;
public class CoosingOption {
	public static void main(String[] args) {
		/*int option=JOptionPane.showConfirmDialog(null,"Do you want to change the first class ticket?");
		JOptionPane.showMessageDialog(null,"You've choosen: "+(option==JOptionPane.YES_OPTION?"Co":"Khong"));*/
		// Cấu trúc: showConfirmDialog(Component, Message, Title, OptionType)
		int option=JOptionPane.showConfirmDialog(null,"Ban co chac ko","Confirm",JOptionPane.YES_NO_OPTION);
		if (option==JOptionPane.YES_OPTION) {
			System.out.println("Nguoi dung dong y");
		}
		else {
			System.out.println("Nguoi dung ko dong y");
		}
	}
}
