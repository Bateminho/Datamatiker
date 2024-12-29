package gui;

import javafx.application.Application;
import model.Dao;


public class App {
    public static void main(String[] args) {
        Dao.createSomeObjects();
        Application.launch(Gui.class);

    }
}
