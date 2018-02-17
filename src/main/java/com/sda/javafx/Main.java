package com.sda.javafx;

import com.sda.javafx.controller.Controller;
import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

    public Main(){
        personObservableList.add(new Person("Marcin", "Kowalski","87-796","Bydgoszcz",
                "02.03.1997","Fordonska"));
        personObservableList.add(new Person("Jan", "Nowak","95-796","Warszawa",
                "02.03.1970","Lecha"));
        personObservableList.add(new Person("Janusz", "Chlebowski","50-796","Wroclaw",
                "04.05.1990","Warszawska"));
        personObservableList.add(new Person("Karol", "Podloga","10-796","Bydgoszcz",
                "02.03.1950","Bydgoska"));
    }

    public ObservableList<Person> getPerson() {
        return personObservableList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        initRootLayout();
        showPersonLayout();
    }

    public void initRootLayout() throws IOException{
        rootLayout = FXMLLoader.load(getClass().getClassLoader()
                .getResource("RootLayout.fxml"));
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMinHeight(463);
    }
    public void showPersonLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getClassLoader()
                .getResource("PersonOverview.fxml")));
        AnchorPane person = loader.load();
        rootLayout.setCenter(person);

        Controller controller = loader.getController();
        controller.setMain(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
