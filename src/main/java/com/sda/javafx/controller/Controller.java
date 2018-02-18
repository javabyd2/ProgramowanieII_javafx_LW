package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



import java.io.IOException;

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
    private void deletePerson(){
        int index = personTableView.getSelectionModel().getSelectedIndex();

        if(index >=0) {

            personTableView.getItems().remove(index);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Usunieto!");
            alert.setHeaderText("Usunales osobe z listy");
            alert.setContentText("Osoba usunieta to: " );
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Blad");
            alert.setHeaderText("To jest error");
            alert.setContentText("Nie mozna usunac");
            alert.showAndWait();
        }
    }

    public void addPerson(ActionEvent actionEvent) throws IOException{

        FXMLLoader addPersonLayout = new  FXMLLoader(getClass().getClassLoader().getResource("AddPerson.fxml"));

        AnchorPane addPersonLayou = addPersonLayout.load();

        AddController addController = addPersonLayout.getController();
        addController.setMain(main);
        Stage stage = new Stage();
        Scene scene = new Scene(addPersonLayou);

        stage.setScene(scene);
        stage.show();
    }

//    public void editPerson(ActionEvent actionEvent) throws IOException{
//
//        FXMLLoader addPersonLayout = new  FXMLLoader(getClass().getClassLoader().getResource("AddPerson.fxml"));
//
//        AnchorPane addPersonLayou = addPersonLayout.load();
//
//        AddController addController = addPersonLayout.getController();
//        addController.setMain(main);
//        Stage stage = new Stage();
//        Scene scene = new Scene(addPersonLayou);
//
//        stage.setScene(scene);
//        stage.show();
//    }


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
