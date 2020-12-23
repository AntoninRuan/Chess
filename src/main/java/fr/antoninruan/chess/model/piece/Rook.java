package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.Square;
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
        return isValidDestination(from, dest, this.isWhite());
    }

    protected static boolean isValidDestination(Square from, Square dest, boolean isWhite) {
        if (from.equals(dest))
            return false;

        if (from.getColumn() != dest.getColumn() && from.getRow() != dest.getRow())
            return false;
        else {
            return getValidMoves(from, isWhite).contains(dest);
        }
    }

    @Override
    public List<Square> getValidMoves() {
        return getValidMoves(this.getSquare(), this.isWhite());
    }

    protected static List<Square> getValidMoves(Square from, boolean isWhite) {
        List<Square> possibles = new ArrayList<>();
        boolean[] blocked = new boolean[] {false, false, false, false};
        for (int i = 1; i <= 7; i ++) {

            if (!blocked[0] && from.getRow() + i < 8) {
                Square checking = MainApp.getSquare(from.getColumn(), from.getRow() + i);
                if(!checking.isEmpty()) {
                    blocked[0] = true;
                    if (checking.getPiece().isWhite() != isWhite)
                        possibles.add(checking);
                } else
                    possibles.add(checking);
            }
            if(!blocked[1] && from.getRow() - i >= 0) {
                Square checking = MainApp.getSquare(from.getColumn(), from.getRow() - i);
                if(!checking.isEmpty()) {
                    blocked[1] = true;
                    if (checking.getPiece().isWhite() != isWhite)
                        possibles.add(checking);
                } else
                    possibles.add(checking);
            }
            if (!blocked[2] && (from.getColumn() + i) < 8) {
                Square checking = MainApp.getSquare(from.getColumn() + i, from.getRow());
                if(!checking.isEmpty()) {
                    blocked[2] = true;
                    if (checking.getPiece().isWhite() != isWhite)
                        possibles.add(checking);
                } else
                    possibles.add(checking);
            }
            if(!blocked[3] && (from.getColumn() - i) >= 0) {
                Square checking = MainApp.getSquare(from.getColumn() - i, from.getRow());
                if(!checking.isEmpty()) {
                    blocked[3] = true;
                    if (checking.getPiece().isWhite() != isWhite)
                        possibles.add(checking);
                } else
                    possibles.add(checking);
            }

        }
        return possibles;
    }


}
