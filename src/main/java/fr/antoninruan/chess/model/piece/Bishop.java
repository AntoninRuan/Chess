package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.Square;
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
        return isValidDestination(from, square, this.isWhite());
    }

    protected static boolean isValidDestination(Square from, Square dest, boolean isWhite) {
        if (from.equals(dest))
            return false;

        if (from.isWhite() == dest.isWhite()) {
            List<Square> possibles = new ArrayList<>();
            boolean[] blocked = new boolean[]{false, false, false, false};
            for (int i = 1; i <= 8; i++) {

                if (!blocked[0] && from.getColumn() + i < 8 && from.getRow() + i < 8) {
                    Square checking = MainApp.getSquare(from.getColumn() + i, from.getRow() + i);

                    if (!checking.isEmpty()) {
                        blocked[0] = true;
                        if (!checking.getPiece().isWhite() == isWhite) {
                            possibles.add(checking);
                        }
                    } else
                        possibles.add(checking);

                }

                if (!blocked[1] && from.getColumn() + i < 8 && from.getRow() - i >= 0) {
                    Square checking = MainApp.getSquare(from.getColumn() + i, from.getRow() - i);
                    if (!checking.isEmpty()) {
                        blocked[1] = true;
                        if (!checking.getPiece().isWhite() == isWhite)
                            possibles.add(checking);
                    } else
                        possibles.add(checking);
                }

                if (!blocked[2] && from.getColumn() - i >= 0 && from.getRow() + i < 8) {
                    Square checking = MainApp.getSquare(from.getColumn() - i, from.getRow() + i);
                    if (!checking.isEmpty()) {
                        blocked[2] = true;
                        if (!checking.getPiece().isWhite() == isWhite)
                            possibles.add(checking);
                    } else
                        possibles.add(checking);
                }

                if (!blocked[3] && from.getColumn() - i >= 0 && from.getRow() - i >= 0) {
                    Square checking = MainApp.getSquare(from.getColumn() - i, from.getRow() - i);
                    if (!checking.isEmpty()) {
                        blocked[3] = true;
                        if (!checking.getPiece().isWhite() == isWhite)
                            possibles.add(checking);
                    } else
                        possibles.add(checking);
                }
            }

            return possibles.contains(dest);

        }
        return false;
    }

}
