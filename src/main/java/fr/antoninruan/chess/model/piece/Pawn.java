package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.Square;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{
    public Pawn(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "p.png").toString()));
    }

    void promote() {
        this.getSquare().setPiece(new Queen(this.getSquare(), this.isWhite()));
    }

    @Override
    protected boolean isValidDestination(Square dest) {
        Square from = this.getSquare();
        if (from.equals(dest))
            return false;

        return getValidMoves().contains(dest);
    }

    @Override
    public List<Square> getValidMoves() {
        Square from = this.getSquare();
        List<Square> possibles = new ArrayList<>();

        int v = isWhite() ? 1 : -1;

        if(isWhite()) {
            if(from.getRow() == 1) {
                Square checking = MainApp.getSquare(from.getColumn(), from.getRow() + v);
                Square checking2 = MainApp.getSquare(from.getColumn(), from.getRow() + (2 * v));
                if(checking.isEmpty() && checking2.isEmpty())
                    possibles.add(checking2);
            }
        } else {
            if(from.getRow() == 6) {
                Square checking = MainApp.getSquare(from.getColumn(), from.getRow() + v);
                Square checking2 = MainApp.getSquare(from.getColumn(), from.getRow() + (2 * v));
                if(checking.isEmpty() && checking2.isEmpty())
                    possibles.add(checking2);
            }
        }

        if(MainApp.getSquare(from.getColumn(), from.getRow() + v).isEmpty())
            possibles.add(MainApp.getSquare(from.getColumn(), from.getRow() + v));
        if (from.getColumn() + 1 < 8) {
            Square checking = MainApp.getSquare(from.getColumn() + 1, from.getRow() + v);
            if(!checking.isEmpty() && checking.getPiece().isWhite() != this.isWhite())
                possibles.add(checking);

        }
        if(from.getColumn() - 1 >= 0) {
            Square checking = MainApp.getSquare(from.getColumn() - 1, from.getRow() + v);
            if(!checking.isEmpty() && checking.getPiece().isWhite() != this.isWhite())
                possibles.add(checking);
        }

        return possibles;
    }
}
