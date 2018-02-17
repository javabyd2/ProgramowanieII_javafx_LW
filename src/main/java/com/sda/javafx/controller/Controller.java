package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.event.ChangeListener;

public class Controller {
    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> firstnameColumn;

    @FXML
    private TableColumn<Person, String> lastnameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    public Controller(){
    }

    @FXML
    private void initialize(){
        firstnameColumn.setCellValueFactory(data -> data.getValue().firstnameProperty());
        lastnameColumn.setCellValueFactory(data -> data.getValue().lastnameProperty());
        cityLabel.setLabelFor(cityLabel);
        streetLabel.setLabelFor(streetLabel);
        postalCodeLabel.setLabelFor(postalCodeLabel);
        birthdayLabel.setLabelFor(birthdayLabel);

        personTableView.getSelectionModel().selectedItemProperty().addListener((observable, x, y )-> showPerson(y));

    }

    public void showPerson(Person person){
        firstNameLabel.setText(person.getFirstname());
        lastNameLabel.setText(person.getLastname());
        cityLabel.setText(person.getCity());
        streetLabel.setText(person.getStreet());
        postalCodeLabel.setText(person.getPostalcode());
        birthdayLabel.setText(person.getBirthday());
        System.out.println(person.getFirstname() + " " + person.getLastname());
        System.out.println("KLIKAM!");
    }

    private Main main;

    public void setMain(Main main){
        this.main = main;
        personTableView.setItems(main.getPerson());
    }

    public Controller(Main main) {
        this.main = main;
    }
}
