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
    private TableColumn<Player, ImageView> imageColumn;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableView<Player> playerTableView;

    public void initialize() {
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("icon"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        onlineNumLabel.setText("Online Players: 0");
        maxNumLabel.setText("Max Players: 25");
    }

    @FXML
    void searchServersButton(ActionEvent event) {
        try {
            SceneChanger.changeScenes(event, "search-view.fxml");
        } catch (Exception e) {
            System.out.println("Cannot change scenes: " + e.getMessage());
        }
    }

    @Override
    public void loadPlayers(ServerPlayerInfo playerInfo) {
        onlineNumLabel.setText("Online Players: " + playerInfo.getOnline());
        maxNumLabel.setText("Max Players: " + playerInfo.getMax());

        ObservableList<Player> data = FXCollections.observableArrayList(playerInfo.getPlayerList());
        playerTableView.setItems(data);
    }

}
