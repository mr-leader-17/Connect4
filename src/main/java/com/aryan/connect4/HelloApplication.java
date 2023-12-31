package com.aryan.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public HelloController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane= (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        stage.setScene(scene);
        stage.setTitle("Connect four Game");
        stage.setResizable(false);
        stage.show();
    }

    private MenuBar createMenu(){

        Menu fileMenu=new Menu("File");

        MenuItem newGame=new MenuItem("New Game");
        newGame.setOnAction(event -> {controller.resetGame();});

        MenuItem resetGame=new MenuItem("Reset Game");
        resetGame.setOnAction(event -> {controller.resetGame();});

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame=new MenuItem("Exit Game");
        exitGame.setOnAction(event -> {exitGame();});

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

        Menu helpMenu=new Menu("About");

        MenuItem aboutGame=new MenuItem("About Game");
        aboutGame.setOnAction(event -> {aboutConnect4();});

        SeparatorMenuItem separator=new SeparatorMenuItem();
        MenuItem aboutMe=new MenuItem("About me");
        aboutMe.setOnAction(event -> {aboutMe();});

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About developer");
        alert.setHeaderText("Aryan");
        alert.setContentText("I love to play and develop games, Connect4 is one of those games.");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players" +
                " first choose a color and then take turns dropping colored discs from the top into a seven-column," +
                " six-row vertically suspended grid. The pieces fall straight down, " +
                "occupying the next available space within the column." +
                " The objective of the game is to be the first to form a horizontal, vertical, " +
                "or diagonal line of four of one's own discs." +
                " Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}