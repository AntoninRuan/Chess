package fr.antoninruan.chess.model;

import fr.antoninruan.chess.MainApp;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "b.png").toString()));
    }

    @Override
    protected boolean isValidDestination(Square square) {
        Square from = this.getSquare();
        return isValidDestination(from, square);
    }

    protected static boolean isValidDestination(Square from, Square square) {
        if (from.equals(square))
            return false;

        if (from.isWhite() == square.isWhite()) {
            List<Square> possible = new ArrayList<>();
            boolean[] blocked = new boolean[]{false, false, false, false};
            for (int i = 0; i <= 4; i++) {
                if (!blocked[0]) {
                    if (from.getColumn() + i < 8 && from.getRow() + i < 8 && !MainApp.getSquare(from.getColumn() + i, from.getRow() + i).isEmpty())
                        blocked[0] = true;
                    possible.add(MainApp.getSquare(from.getColumn() + i, from.getRow() + i));
                } else if (!blocked[1]) {
                    if (from.getColumn() + i < 8 && from.getRow() - i >= 0 &&  !MainApp.getSquare(from.getColumn() + i, from.getRow() - i).isEmpty())
                        blocked[1] = true;
                    possible.add(MainApp.getSquare(from.getColumn() + i, from.getRow() - i));
                } else if (!blocked[2]) {
                    if (from.getColumn() - i >= 0 && from.getRow() + i < 8 && !MainApp.getSquare(from.getColumn() - i, from.getRow() + i).isEmpty())
                        blocked[2] = true;
                    MainApp.getSquare(from.getColumn() - i, from.getRow() + i);
                } else if (!blocked[3]) {
                    if (from.getColumn() - i >= 0 && from.getRow() - i >= 0 && !MainApp.getSquare(from.getColumn() + i, from.getRow() - i).isEmpty())
                        blocked[3] = true;
                    MainApp.getSquare(from.getColumn() - i, from.getRow() - i);
                }
            }

            return possible.contains(square);

        }
        return false;
    }

}
