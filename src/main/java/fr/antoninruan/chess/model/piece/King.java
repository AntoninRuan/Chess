package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.Square;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    public King(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "k.png").toString()));
    }

    public boolean isChecked() {
        Square from = this.getSquare();

        if(from.getColumn() + 2 < 8) {

            if (from.getRow() + 1 < 8) {

                Square square = MainApp.getSquare(from.getColumn() + 2, from.getRow() + 1);
                if (square.getPiece() instanceof Knight && square.getPiece().isWhite() != this.isWhite()) {
                    return true;
                }

            }
            if (from.getRow() - 1 >= 0) {

                Square square = MainApp.getSquare(from.getColumn() + 2, from.getRow() - 1);
                if (square.getPiece() instanceof Knight && square.getPiece().isWhite() != this.isWhite()) {
                    return true;
                }

            }

        }
        if(from.getColumn() + 1 < 8) {

            if (from.getRow() + 2 < 8) {

                Square square = MainApp.getSquare(from.getColumn() + 1, from.getRow() + 2);
                if (square.getPiece() instanceof Knight && square.getPiece().isWhite() != this.isWhite()) {
                    return true;
                }

            }
            if (from.getRow() - 2 >= 0) {

                Square square = MainApp.getSquare(from.getColumn() + 1, from.getRow() - 2);
                if (square.getPiece() instanceof Knight && square.getPiece().isWhite() != this.isWhite()) {
                    return true;
                }

            }

        }
        if(from.getColumn() - 1 >= 0) {

            if (from.getRow() + 2 < 8) {

                Square square = MainApp.getSquare(from.getColumn() - 1, from.getRow() + 2);
                if (square.getPiece() instanceof Knight && square.getPiece().isWhite() != this.isWhite()) {
                    return true;
                }

            }
            if (from.getRow() - 2 >= 0) {

                Square square = MainApp.getSquare(from.getColumn() - 1, from.getRow() - 2);
                if (square.getPiece() instanceof Knight && square.getPiece().isWhite() != this.isWhite()) {
                    return true;
                }

            }

        }
        if (from.getColumn() - 2 >= 0) {

            if (from.getRow() + 1 < 8) {

                Square square = MainApp.getSquare(from.getColumn() - 2, from.getRow() + 1);
                if (square.getPiece() instanceof Knight && square.getPiece().isWhite() != this.isWhite()) {
                    return true;
                }

            }
            if (from.getRow() - 1 >= 0) {

                Square square = MainApp.getSquare(from.getColumn() - 2, from.getRow() - 1);
                if (square.getPiece() instanceof Knight && square.getPiece().isWhite() != this.isWhite()) {
                    return true;
                }

            }

        }

        boolean[] blocked = new boolean[] {false, false, false, false};
        for (int i = 1; i < 8; i ++) {

            if(!blocked[0] && from.getColumn() + i < 8) {
                Square square = MainApp.getSquare(from.getColumn() + i, from.getRow());
                if (!square.isEmpty()) {
                    if (square.getPiece().isWhite() != this.isWhite() && (square.getPiece() instanceof Rook || square.getPiece() instanceof Queen))
                        return true;
                    blocked[0] = true;
                }
            }
            if(!blocked[1] && from.getColumn() - i >= 0) {
                Square square = MainApp.getSquare(from.getColumn() - i, from.getRow());
                if (!square.isEmpty()) {
                    if(square.getPiece().isWhite() != this.isWhite() && (square.getPiece() instanceof Rook || square.getPiece() instanceof Queen))
                        return true;
                    blocked[1] = true;
                }
            }
            if(!blocked[2] && from.getRow() + i < 8) {
                Square square = MainApp.getSquare(from.getColumn(), from.getRow() + i);
                if(!square.isEmpty()) {
                    if(square.getPiece().isWhite() != this.isWhite() && (square.getPiece() instanceof Rook || square.getPiece() instanceof Queen))
                        return true;
                    blocked[2] = true;
                }
            }
            if(!blocked[3] && from.getRow() - i >= 0) {
                Square square = MainApp.getSquare(from.getColumn(), from.getRow() - i);
                if(!square.isEmpty()) {
                    if(square.getPiece().isWhite() != this.isWhite() && (square.getPiece() instanceof Rook || square.getPiece() instanceof Queen))
                        return true;
                    blocked[3] = true;
                }
            }

        }

        blocked = new boolean[] {false, false, false, false};
        for (int i = 1; i < 8; i ++) {
            if (!blocked[0] && from.getColumn() + i < 8 && from.getRow() + i < 8) {
                Square square = MainApp.getSquare(from.getColumn() + i, from.getRow() + i);
                if (!square.isEmpty()) {
                    if(square.getPiece().isWhite() != this.isWhite() && (square.getPiece() instanceof Bishop || square.getPiece() instanceof Queen))
                        return true;
                    blocked[0] = true;
                }
            }
            if(!blocked[1] && from.getColumn() + i < 8 && from.getRow() - i >= 0) {
                Square square = MainApp.getSquare(from.getColumn() + i, from.getRow() - i);
                if(!square.isEmpty()) {
                    if(square.getPiece().isWhite() != this.isWhite() && (square.getPiece() instanceof Bishop || square.getPiece() instanceof Queen))
                        return true;
                    blocked[1] = true;
                }
            }
            if(!blocked[2] && from.getColumn() - i >= 0 && from.getRow() + i < 8) {
                Square square = MainApp.getSquare(from.getColumn() - i, from.getRow() + i);
                if(!square.isEmpty()) {
                    if(square.getPiece().isWhite() != this.isWhite() && (square.getPiece() instanceof Bishop || square.getPiece() instanceof Queen))
                        return true;
                    blocked[2] = true;
                }
            }
            if(!blocked[3] && from.getColumn() - i >= 0 && from.getRow() - i >= 0) {
                Square square = MainApp.getSquare(from.getColumn() - i, from.getRow() - i);
                if(!square.isEmpty()) {
                    if(square.getPiece().isWhite() != this.isWhite() && (square.getPiece() instanceof Bishop || square.getPiece() instanceof Queen))
                        return true;
                    blocked[3] = true;
                }
            }
        }

        return false;
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
        for (int i = -1; i <= 1; i ++) {
            for (int j = -1; j <= 1; j ++) {
                if ((from.getColumn() + i >= 0 && from.getColumn() + i < 8) && (from.getRow() + j >= 0 && from.getRow() + j < 8)) {
                    Square checking = MainApp.getSquare(from.getColumn() + i, from.getRow() + j);
                    if(!checking.equals(from)) {
                        if(checking.isEmpty() || checking.getPiece().isWhite() != this.isWhite())
                            possibles.add(checking);
                        //TODO ajouter une vérification pour que le roi ne se mette pas en situation d'échecs
                    }
                }
            }
        }
        return possibles;
    }
}
