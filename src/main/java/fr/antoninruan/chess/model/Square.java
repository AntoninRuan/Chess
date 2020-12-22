package fr.antoninruan.chess.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Objects;

public class Square {

    private int column, row;
    private ObjectProperty<Piece> piece = new SimpleObjectProperty<>();
    private boolean isWhite;

    public Square(int column, int row) {
        this.column = column;
        this.row = row;
        this.isWhite = (column + row) % 2 == 1;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public Piece getPiece() {
        return piece.getValue();
    }

    public ObjectProperty<Piece> pieceProperty() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece.setValue(piece);
    }

    public boolean isEmpty() {
        return piece.getValue() == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return column == square.column && row == square.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }
}
