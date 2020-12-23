package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.Square;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "n.png").toString()));
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
        if (from.getColumn() + 2 < 8) {
            if (from.getRow() + 1 < 8) {
                Square checking = MainApp.getSquare(from.getColumn() + 2 , from.getRow() + 1);
                if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                    possibles.add(checking);
            }
            if(from.getRow() - 1 >= 0) {
                Square checking = MainApp.getSquare(from.getColumn() + 2 , from.getRow() - 1);
                if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                    possibles.add(checking);
            }
        }
        if (from.getColumn() - 2 >= 0) {
            if (from.getRow() + 1 < 8) {
                Square checking = MainApp.getSquare(from.getColumn() - 2 , from.getRow() + 1);
                if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                    possibles.add(checking);
            }
            if(from.getRow() - 1 >= 0) {
                Square checking = MainApp.getSquare(from.getColumn() - 2 , from.getRow() - 1);
                System.out.println(checking);
                if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                    possibles.add(checking);
            }
        }
        if (from.getColumn() + 1 < 8) {
            if (from.getRow() + 2 < 8) {
                Square checking = MainApp.getSquare(from.getColumn() + 1 , from.getRow() + 2);
                if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                    possibles.add(checking);
            }
            if(from.getRow() - 2 >= 0) {
                Square checking = MainApp.getSquare(from.getColumn() + 1 , from.getRow() - 2);
                if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                    possibles.add(checking);
            }
        }
        if (from.getColumn() - 1 < 8) {
            if (from.getRow() + 2 < 8) {
                Square checking = MainApp.getSquare(from.getColumn() - 1 , from.getRow() + 2);
                if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                    possibles.add(checking);
            }
            if(from.getRow() - 2 >= 0) {
                Square checking = MainApp.getSquare(from.getColumn() - 1, from.getRow() - 2);
                if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                    possibles.add(checking);
            }
        }
        return possibles;
    }
}
