package coconutsBreaker;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Piece extends JButton {
	private static int pieceSize = 0;
	private static int maxPieces = 0;
	private int[] pos;
	private int id;
	private ImageIcon image;

	public Piece(int[] pos, int id, ImageIcon image) {
		this.pos = pos;
		setImage(image, id);

		this.setBackground(Color.WHITE);
		Dimension size = new Dimension(pieceSize, pieceSize);
		this.setSize(size);
	}

	public int getPos(int index) {
		return this.pos[index];
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

	public static void setPieceSizeMaxPieces(int size, int piecesNum) {
		pieceSize = size;
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
