package coconutsBreaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MyComponents.Titles;

public class CoconutsBreaker extends JFrame {
	public static final String imagePath = "src/images/univalle.jpg";

	private int pieceSize = 100;
	private int gridSize = 4;
	private BufferedImage bufferImage = null;
	private Piece[][] board = new Piece[gridSize][gridSize];
	private JPanel centralPanel, buttonPanel;
	private JButton help, mix, exit;
	private Listener listener;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CoconutsBreaker() {

		try {
			bufferImage = ImageIO.read(new File(imagePath));
			Piece.setPieceSizeMaxPieces(pieceSize, gridSize * gridSize);

			initGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "didnt find image");
		}
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		setUndecorated(true);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		listener = new Listener();

		// Title
		Titles title = new Titles("Coconuts Breaker", 30, Color.BLACK);
		add(title, BorderLayout.NORTH);

		// gameZone
		divideImage();

		// buttons
		buttonPanel = new JPanel();
		help = new JButton("Help");
		help.addActionListener(listener);
		buttonPanel.add(help);

		mix = new JButton("Mix");
		mix.addActionListener(listener);
		buttonPanel.add(mix);

		exit = new JButton("Exit");
		exit.addActionListener(listener);
		buttonPanel.add(exit);

		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void divideImage() {
		// TODO Auto-generated method stub

	}

	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				System.exit(0);
			} else if (e.getSource() == help) {

			} else if (e.getSource() == mix) {

			}
		}
	}
}
