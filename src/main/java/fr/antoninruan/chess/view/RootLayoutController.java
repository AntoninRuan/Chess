package fr.antoninruan.chess.view;

import fr.antoninruan.chess.MainApp;
import fr.antoninruan.chess.model.*;
import fr.antoninruan.chess.model.piece.*;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;


public class RootLayoutController {

    private MainApp mainApp;

    @FXML
    private GridPane grid;

    @FXML
    private void initialize() {

        for (int c = 0; c < 8; c ++) {

            for (int r = 0; r < 8; r ++) {

                Square square = new Square(c, r);

                if (r == 0) {
                    if (c == 0 || c == 7)
                        square.setPiece(new Rook(square, true));
                    else if (c == 1 || c == 6)
                        square.setPiece(new Knight(square, true));
                    else if (c == 2 || c == 5)
                        square.setPiece(new Bishop(square, true));
                    else if (c == 3)
                        square.setPiece(new Queen(square, true));
                    else
                        square.setPiece(new King(square, true));

                } else if (r == 1) {
                    square.setPiece(new Pawn(square, true));
                } else if (r == 6) {
                    square.setPiece(new Pawn(square, false));
                } else if (r == 7) {
                    if (c == 0 || c == 7)
                        square.setPiece(new Rook(square, false));
                    else if (c == 1 || c == 6)
                        square.setPiece(new Knight(square, false));
                    else if (c == 2 || c == 5)
                        square.setPiece(new Bishop(square, false));
                    else if (c == 3)
                        square.setPiece(new Queen(square, false));
                    else
                        square.setPiece(new King(square, false));
                }

                MainApp.getSquares().put(new Pair<>(c, r), square);

                ImageView view = new ImageView("img/background.jpg");
                view.setFitHeight(75);
                view.setFitWidth(75);
                if (!square.isEmpty()) {
                    view.setImage(square.getPiece().getImage());
                    view.setCursor(Cursor.HAND);
                } else
                    view.setOpacity(0);

                square.pieceProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue == null) {
                        view.setImage(new Image("img/background.jpg"));
                        view.setOpacity(0);
                        view.setCursor(Cursor.DEFAULT);
                    } else {
                        view.setOpacity(1);
                        view.setImage(newValue.getImage());
                        view.setCursor(Cursor.HAND);
                    }
                });

                int finalC = c;
                int finalR = r;
                view.setOnDragDetected(event -> {

                    if (event.getButton() == MouseButton.SECONDARY || event.getButton() == MouseButton.MIDDLE)
                        return;

                    if(square.isEmpty())
                        return;

                    if(square.getPiece().isWhite() != MainApp.isWhiteTurn())
                        return;

                    Dragboard dragboard = view.startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(finalC + "," + finalR);
                    dragboard.setContent(content);

                });

                view.setOnDragOver(event  -> {
                    if (event.getGestureSource() != view && event.getDragboard().hasString())
                        event.acceptTransferModes(TransferMode.MOVE);
                    event.consume();
                });

                view.setOnDragEntered(event -> {
                    if (event.getGestureSource() != view && event.getDragboard().hasString() && !square.isEmpty())
                        view.setOpacity(.3);
                });

                view.setOnDragExited(event -> {
                    if (event.getGestureSource() != view && event.getDragboard().hasString() && !square.isEmpty())
                        view.setOpacity(1);
                });

                view.setOnDragDropped(event -> {

                    Dragboard db = event.getDragboard();
                    if (db.hasString()) {
                        String[] s = db.getString().split(",");
                        int cd = Integer.valueOf(s[0]);
                        int rd = Integer.valueOf(s[1]);

                        Square from = MainApp.getSquare(cd, rd);
                        boolean moved = from.getPiece().moveTo(square);

                        if (moved)
                            MainApp.setWhiteTurn(!MainApp.isWhiteTurn());

                    }

                });

                grid.add(view, c, r);

            }

        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
