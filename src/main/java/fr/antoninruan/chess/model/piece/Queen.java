package fr.antoninruan.chess.model.piece;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.Square;
import javafx.scene.image.Image;

import java.util.List;

public class Queen extends Piece{

    public Queen(Square square, boolean white) {
        super(square, white, new Image(MainApp.class.getClassLoader().getResource("img/" + (white ? "w" : "b") + "q.png").toString()));
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
        List<Square> possibles = Bishop.getValidMoves(this.getSquare(), this.isWhite());
        possibles.addAll(Rook.getValidMoves(this.getSquare(), this.isWhite()));
        return possibles;
    }
}
