package coconutsBreaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import MyComponents.Titles;

public class CoconutsBreaker extends JFrame {
	public static final String imagePath = "src/images/univalle.jpg";

	private int pieceXSize = 270;
	private int pieceYSize = 156;
	private int gridSize = 4;
	private BufferedImage bufferImage = null;
	private Piece[][] board = new Piece[gridSize][gridSize];
	private JPanel centralPanel, buttonPanel;
	private JButton help, mix, exit;
	private Listener listener;
	private Help helpWindow = new Help(this);
	private JFrame myself = this;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CoconutsBreaker() {

		try {
			bufferImage = ImageIO.read(new File(imagePath));
			Piece.setPieceSizeMaxPieces(pieceXSize, pieceYSize, gridSize * gridSize);

			initGUI();

			setUndecorated(true);
			pack();
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "didnt find image");
		}
	}

	private void initGUI() {
		// TODO Auto-generated method stub

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
		centralPanel = new JPanel();
		centralPanel.setLayout(new GridLayout(gridSize, gridSize));
		add(centralPanel, BorderLayout.CENTER);

		int id = 0;

		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				BufferedImage subImage = bufferImage.getSubimage(j * pieceXSize, i * pieceYSize, pieceXSize,
						pieceYSize);

				ImageIcon buttonImage = new ImageIcon(subImage);
				board[i][j] = new Piece(new int[] { i, j }, id, buttonImage);
				board[i][j].addMouseListener(listener);
				centralPanel.add(board[i][j]);
				id++;
			}
		}
	}

	private void clickedPiece(Piece piece) {
		int x = piece.getPos(0);
		int y = piece.getPos(1);

		if (x < gridSize - 1 && !board[x + 1][y].hasImage()) {
			piece.exchangePieces(board[x + 1][y]);
		} else if (y < gridSize - 1 && !board[x][y + 1].hasImage()) {
			piece.exchangePieces(board[x][y + 1]);
		} else if (x > 0 && !board[x - 1][y].hasImage()) {
			piece.exchangePieces(board[x - 1][y]);
		} else if (y > 0 && !board[x][y - 1].hasImage()) {
			piece.exchangePieces(board[x][y - 1]);
		}
	}

	private class Listener extends MouseAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == exit) {
				System.exit(0);
			} else if (e.getSource() == help) {
				helpWindow.setVisible(true);
				myself.setVisible(false);
			} else if (e.getSource() == mix) {

			}
		}

		public void mouseClicked(MouseEvent e) {
			Piece piece = (Piece) e.getSource();
			clickedPiece(piece);
		}
	}
}
