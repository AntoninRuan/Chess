package fr.antoninruan.chess;

import fr.antoninruan.chess.model.Square;
import fr.antoninruan.chess.model.piece.King;
import fr.antoninruan.chess.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.HashMap;

public class MainApp extends Application {

    private static Stage primaryStage;
    private static AnchorPane rootLayout;
    private static RootLayoutController rootController;
    private static HashMap<Pair<Integer, Integer>, Square> squares = new HashMap<>();
    private static King whiteKing;
    private static King blackKing;
    private static boolean whiteTurn = true;

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        initRootLayout();
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getClassLoader().getResource("fxml/RootLayout.fxml"));

            rootLayout = loader.load();

            rootController = loader.getController();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResource("img/bq.png").toString()));
            primaryStage.setTitle("Échecs");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Pair<Integer, Integer>, Square> getSquares() {
        return squares;
    }

    public static Square getSquare(int c, int r) {
        Pair pair = new Pair(c, r);
        return squares.get(pair);
    }

    public static King getWhiteKing() {
        return whiteKing;
    }

    public static void setWhiteKing(King whiteKing) {
        MainApp.whiteKing = whiteKing;
    }

    public static King getBlackKing() {
        return blackKing;
    }

    public static void setBlackKing(King blackKing) {
        MainApp.blackKing = blackKing;
    }

    public static boolean isWhiteTurn() {
        return whiteTurn;
    }

    public static void setWhiteTurn(boolean whiteTurn) {
        MainApp.whiteTurn = whiteTurn;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
