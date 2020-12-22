package fr.antoninruan.chess;

import fr.antoninruan.chess.model.Square;
import fr.antoninruan.chess.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.HashMap;

public class MainApp extends Application {

    private static Stage primaryStage;
    private static AnchorPane rootLayout;
    private static RootLayoutController rootController;
    private static HashMap<Pair<Integer, Integer>, Square> squares = new HashMap<>();
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
            rootController.setMainApp(this);

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
