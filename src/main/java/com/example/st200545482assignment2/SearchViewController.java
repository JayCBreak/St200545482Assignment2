package com.example.st200545482assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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

    private McSrvResponse server;

    @FXML
    public void initialize() {
        onlineLabel.setText("");
        gridPane.setVisible(false);
    }

    @FXML
    void searchButton(ActionEvent event) {
        try {
            server = APIUtility.callMcSrvAPI(ipTextField.getText().trim());

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
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    @FXML
    void showPlayersButton(ActionEvent event) {
        try {
            SceneChanger.changeScenes(event, "search-view.fxml", server.getPlayerInfo().getPlayerList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
