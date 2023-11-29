package com.example.st200545482assignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.util.List;

public class PlayerViewController  implements PlayerLoader{

    @FXML
    private TableColumn<Player, ImageView> imageColumn;

    @FXML
    private TableColumn<Player, String> nameColumn;

    @FXML
    private TableView<Player> playerTableView;

    public void initialize() {
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("imageView"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @FXML
    void searchServersButton(ActionEvent event) {

    }

    public void loadPlayers(List<Player> players) {
        ObservableList<Player> data = FXCollections.observableArrayList(players);
        playerTableView.setItems(data);
    }

}
