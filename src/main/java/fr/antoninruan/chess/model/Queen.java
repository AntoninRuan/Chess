package fr.antoninruan.chess.model;

import fr.antoninruan.chess.MainApp;
import javafx.scene.image.Image;

import java.util.ArrayList;
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

        return Bishop.isValidDestination(from, dest) || Rook.isValidDestination(from, dest);

    }

}
