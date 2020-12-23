package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.model.Square;
import javafx.scene.image.Image;

public abstract class Piece {

    private Image image;
    private Square square;
    private boolean white;

    Piece(Square square, boolean white, Image image) {
        this.square = square;
        this.white = white;
        this.image = image;
    }

    public Square getSquare() {
        return square;
    }

    public Image getImage() {
        return image;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean moveTo(Square dest) {
        if (isValidDestination(dest)) {
            this.square.setPiece(null);
            dest.setPiece(this);
            this.square = dest;
            return true;
        } else
            return false;
    }

    protected abstract boolean isValidDestination(Square square);

}
