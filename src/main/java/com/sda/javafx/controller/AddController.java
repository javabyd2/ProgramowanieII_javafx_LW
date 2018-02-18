package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddController {

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField streetText;
    @FXML
    private TextField postalCodeText;
    @FXML
    private TextField cityText;
    @FXML
    private TextField birthdayText;

    @FXML
    public Button closeButton;

    public AddController() {
    }

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void addPerson() {

        main.getPerson().add(new Person(firstNameText.getText(),
                lastNameText.getText(),
                streetText.getText(),
                postalCodeText.getText(),
                cityText.getText(),
                birthdayText.getText()));
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
