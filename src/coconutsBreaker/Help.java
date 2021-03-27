package coconutsBreaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import MyComponents.Titles;

public class Help extends JFrame {
	private JLabel image;
	private ImageIcon adapImage;
	private JButton back;
	private Listener listener;
	private JFrame game;

	public Help(JFrame game) {
		this.game = game;

		initGUI();

		setUndecorated(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(false);
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		listener = new Listener();

		Titles title = new Titles("Original Image", 30, Color.BLACK);
		add(title, BorderLayout.NORTH);

		adapImage = new ImageIcon(CoconutsBreaker.imagePath);
		image = new JLabel(adapImage);
		add(image, BorderLayout.CENTER);

		back = new JButton("Back");
		back.addActionListener(listener);
		add(back, BorderLayout.SOUTH);
	}

	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == back) {
				game.setVisible(true);
				setVisible(false);
			}
		}
	}
}
