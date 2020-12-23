package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.Square;
import javafx.scene.image.Image;

public class Pawn extends Piece{
    public Pawn(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "p.png").toString()));
    }

    @Override
    protected boolean isValidDestination(Square dest) {
        Square from = this.getSquare();
        if (from.equals(dest))
            return false;

        int v = isWhite() ? 1 : -1;

        if (dest.getColumn() == from.getColumn()) {
            return (dest.isEmpty() && dest.getRow() == from.getRow() + v) ||
                    (from.getRow() + (v * 2) == dest.getRow() && dest.isEmpty() && from.getRow() == (isWhite() ? 1 : 6));
        } else if (dest.getColumn() == from.getColumn() + 1 || dest.getColumn() == from.getColumn() - 1) {
            return !dest.isEmpty() && dest.getRow() == from.getRow() + v;
        } else
            return false;
    }
}
