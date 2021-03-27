package coconutsBreaker;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			String javaLookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(javaLookAndFeel);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "error in virtual machine");
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoconutsBreaker frame = new CoconutsBreaker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
