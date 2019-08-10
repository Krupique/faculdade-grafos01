/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krupique.trabalho01.init;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Henrique K. Secchi
 */
public class Main extends Application{

    @Override
    public void start(Stage stage){
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }catch(Exception er){
            Alert a = new Alert(Alert.AlertType.ERROR, "Não foi possível carregar a aplicação!\nErro: " + er.getMessage(), ButtonType.OK);
            a.showAndWait();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
