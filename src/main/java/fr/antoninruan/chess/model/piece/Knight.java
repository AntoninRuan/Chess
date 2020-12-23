package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.Square;
import javafx.scene.image.Image;

public class Knight extends Piece{
    public Knight(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "n.png").toString()));
    }

    @Override
    protected boolean isValidDestination(Square dest) {
        Square from = this.getSquare();
        if (from.equals(dest))
            return false;

        if (from.getColumn() + 2 < 8 && from.getColumn() + 2 == dest.getColumn()) {

            if (from.getRow() + 1 < 8 && from.getRow() + 1 == dest.getRow())
                return true;
            else if (from.getRow() - 1 >= 0 && from.getRow() - 1 == dest.getRow())
                return true;
            else
                return false;

        } else if (from.getColumn() - 2 >= 0 && from.getColumn() - 2 == dest.getColumn()) {

            if (from.getRow() + 1 < 8 && from.getRow() + 1 == dest.getRow())
                return true;
            else if (from.getRow() - 1 >= 0 && from.getRow() - 1 == dest.getRow())
                return true;
            else
                return false;

        } else if (from.getColumn() + 1 < 8 && from.getColumn() + 1 == dest.getColumn()) {

            if (from.getRow() + 2 < 8 && from.getRow() + 2 == dest.getRow())
                return true;
            else if (from.getRow() - 2 >= 0 && from.getRow() - 2 == dest.getRow())
                return true;
            else
                return false;

        } else if (from.getColumn() - 1 >= 0 && from.getColumn() - 1 == dest.getColumn()) {

            if (from.getRow() + 2 < 8 && from.getRow() + 2 == dest.getRow())
                return true;
            else if (from.getRow() - 2 >= 0 && from.getRow() - 2 == dest.getRow())
                return true;
            else
                return false;

        } else
            return false;

    }
}
