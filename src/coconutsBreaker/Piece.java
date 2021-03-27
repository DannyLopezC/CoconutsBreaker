package coconutsBreaker;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Piece extends JButton {
	private static int pieceXSize = 0;
	private static int pieceYSize = 0;
	private static int maxPieces = 0;
	private int[] pos;
	private int id;
	private ImageIcon image;

	public Piece(int[] pos, int id, ImageIcon image) {
		this.pos = pos;
		setImage(image, id);

		this.setBackground(Color.WHITE);
		Dimension size = new Dimension(pieceXSize, pieceYSize);
		this.setSize(size);
		setBorder(null);
//		setFocusPainted(true);
	}

	public int getPos(int index) {
		return this.pos[index];
	}

	public int[] getPos() {
		return pos;
	}

	public int getId() {
		return id;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image, int id) {
		this.image = image;
		this.id = id;

		if (id < maxPieces - 1) {
			setIcon(image);
		} else {
			setIcon(null);
		}
	}

	public static void setPieceSizeMaxPieces(int xSize, int ySize, int piecesNum) {
		pieceXSize = xSize;
		pieceYSize = ySize;
		maxPieces = piecesNum;
	}

	public void showImage() {
		setIcon(image);
	}

	public void exchangePieces(Piece piece) {
		int newId = piece.getId();
		ImageIcon newImage = piece.getImage();

		piece.setImage(image, id);
		setImage(newImage, newId);
	}

	public boolean hasImage() {
		if (getIcon() == null) {
			return false;
		}
		return true;
	}
}
