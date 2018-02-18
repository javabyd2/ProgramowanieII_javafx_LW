package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    public AddController(){
    }

    private Main main;

    public void setMain(Main main){
        this.main = main;
    }

    @FXML
    private void addPerson(){

        main.getPerson().add(new Person(firstNameText.getText(),
        lastNameText.getText(),
        streetText.getText(),
        postalCodeText.getText(),
        cityText.getText(),
        birthdayText.getText()));

    }
}
