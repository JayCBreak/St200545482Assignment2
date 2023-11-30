package com.example.st200545482assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class SearchViewController {

    @FXML
    private GridPane gridPane;

    @FXML
    private Label hostnameLabel;

    @FXML
    private Label ipLabel;

    @FXML
    private TextField ipTextField;

    @FXML
    private Label onlineLabel;

    @FXML
    private Label portLabel;

    @FXML
    private ImageView serverIconImageView;

    @FXML
    private Label versionLabel;

    public McSrvResponse server;

    /**
     * Initialize the program to safe values
     */
    @FXML
    public void initialize() {
        onlineLabel.setText("");
        gridPane.setVisible(false);
    }

    /**
     * Gets the Minecraft server given the IP and optional Port in ipTextField
     * @param event The current ActionEvent
     */
    @FXML
    void searchButton(ActionEvent event) {
        try {
            server = APIUtility.callMcSrvAPI(ipTextField.getText().trim());

            loadServer();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    /**
     * Gets the Minecraft server from the example .json file captured on Wednesday Nov. 29th 2023
     * @param event The current ActionEvent
     */
    @FXML
    void exampleButton(ActionEvent event) {
        try {
            server = APIUtility.getExampleServer();

            loadServer();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    /**
     * Changes the scene to show the players currently on the loaded server
     * @param event The current ActionEvent
     */
    @FXML
    void showPlayersButton(ActionEvent event) {
        try {
            SceneChanger.changeScenes(event, "player-view.fxml", server.getPlayerInfo());
        } catch (Exception e) {
            System.out.println("Cannot change scenes: " + e.getMessage());
        }
    }

    /**
     * A private helper method to remove redundant code from loading from API or local json file
     */
    private void loadServer() {
        if(server.isOnline()) {
            onlineLabel.setText("Server Is Online!");
            onlineLabel.setStyle("-fx-text-fill: green");
            gridPane.setVisible(true);
            hostnameLabel.setText(server.getHostname());
            ipLabel.setText(server.getIp());
            portLabel.setText(String.valueOf(server.getPort()));
            serverIconImageView.setImage(new Image(server.getIcon()));
            versionLabel.setText(server.getVersion());
        } else {
            onlineLabel.setText("Server Unavailable.");
            onlineLabel.setStyle("-fx-text-fill: red");
            gridPane.setVisible(false);
        }
    }
}
