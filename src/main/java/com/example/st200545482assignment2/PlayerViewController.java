package com.example.st200545482assignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.util.List;

public class PlayerViewController  implements PlayerLoader{

    @FXML
    private Label maxNumLabel;

    @FXML
    private Label onlineNumLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private TableColumn<Player, ImageView> imageColumn;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableView<Player> playerTableView;

    /**
     * Initialize the program to safe values
     */
    public void initialize() {
        onlineNumLabel.setText("Online Players: 0");
        maxNumLabel.setText("Max Players: 25");
        errorLabel.setText("");
    }

    /**
     * Changes the scene so the user can load a new server to view
     * @param event The current ActionEvent
     */
    @FXML
    void searchServersButton(ActionEvent event) {
        try {
            SceneChanger.changeScenes(event, "search-view.fxml");
        } catch (Exception e) {
            System.out.println("Cannot change scenes: " + e.getMessage());
        }
    }

    /**
     *  A helper function that loads player data from the currently loaded server into this view
     * @param playerInfo A ServerPlayerInfo object containing player numbers and data is used for display in the view
     */
    @Override
    public void loadPlayers(ServerPlayerInfo playerInfo) {
        onlineNumLabel.setText("Online Players: " + playerInfo.getOnline());
        maxNumLabel.setText("Max Players: " + playerInfo.getMax());

        //Hide the table if there is no or tons of players since the api won't show anything
        if(playerInfo.getOnline() == 0 || playerInfo.getOnline() > 50 || playerInfo.getPlayerList().isEmpty()) {
            playerTableView.setVisible(false);
            errorLabel.setText("ERROR: No Players/Too Many Players");
            errorLabel.setStyle("-fx-text-fill: red");
        } else {
            playerTableView.setVisible(true);
            errorLabel.setText("");
            imageColumn.setCellValueFactory(new PropertyValueFactory<>("icon"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            ObservableList<Player> data = FXCollections.observableArrayList(playerInfo.getPlayerList());
            playerTableView.setItems(data);
        }
    }

}
