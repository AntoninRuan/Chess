package fr.antoninruan.chess.model;

import fr.antoninruan.chess.MainApp;
import javafx.scene.image.Image;

public class King extends Piece{

    public King(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "k.png").toString()));
    }

    @Override
    protected boolean isValidDestination(Square dest) {
        Square from = this.getSquare();
        if (from.equals(dest))
            return false;

        int dist = Math.abs(from.getColumn() - dest.getColumn()) + Math.abs(from.getRow() - dest.getRow());

        if (dist > 2) {
            return false;
        } else if (dist == 2) {
            return from.getColumn() != dest.getColumn() && from.getRow() != dest.getRow();
        } else {
            return true;
        }

    }
}
