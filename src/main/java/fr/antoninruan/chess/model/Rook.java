package fr.antoninruan.chess.model;

import fr.antoninruan.chess.MainApp;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "r.png").toString()));
    }

    @Override
    protected boolean isValidDestination(Square dest) {
        Square from = this.getSquare();
        return isValidDestination(from, dest);
    }

    protected static boolean isValidDestination(Square from, Square dest) {
        if (from.getColumn() != dest.getColumn() && from.getRow() != dest.getRow())
            return false;
        else {
            List<Square> possible = new ArrayList<>();
            boolean[] blocked = new boolean[] {false, false};
            if (from.getColumn() == dest.getColumn()) {

                for (int i = 0; i <= 4; i ++) {

                    if (!blocked[0] && from.getRow() + i < 8) {
                        if (!MainApp.getSquare(from.getColumn(), from.getRow() + i).isEmpty())
                            blocked[0] = true;
                        possible.add(MainApp.getSquare(from.getColumn(), from.getRow() + i));
                    } else if(!blocked[1] && from.getRow() - i >= 0) {
                        if(!MainApp.getSquare(from.getColumn(), from.getRow() - i).isEmpty())
                            blocked[1] = true;
                        possible.add(MainApp.getSquare(from.getColumn(), from.getRow() - i));
                    }

                }

            } else {
                for (int i = 0; i <= 4; i ++) {

                    if (!blocked[0] && from.getColumn() + i < 8) {
                        if (!MainApp.getSquare(from.getColumn() + i, from.getRow()).isEmpty())
                            blocked[0] = true;
                        possible.add(MainApp.getSquare(from.getColumn() + i, from.getRow()));
                    } else if(!blocked[1] && from.getColumn() - i >= 0) {
                        if(!MainApp.getSquare(from.getColumn() - i, from.getRow()).isEmpty())
                            blocked[1] = true;
                        possible.add(MainApp.getSquare(from.getColumn() - i, from.getRow()));
                    }

                }

            }
            return possible.contains(dest);
        }
    }

}
