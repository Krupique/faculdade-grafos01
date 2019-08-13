/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krupique.trabalho01.init;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.krupique.trabalho01.estruturas.grafo.Ligacao;
import com.krupique.trabalho01.estruturas.grafo.Vertice;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.QuadCurve;

/**
 * FXML Controller class
 *
 * @author Henrique K. Secchi
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private TableView<String> tableMA;
    @FXML
    private TableView<String> tableMI;
    @FXML
    private TableView<String> tableLista;
    @FXML
    private VBox vboxMA;
    @FXML
    private VBox vboxMI;
    @FXML
    private VBox vboxLista;
    @FXML
    private AnchorPane paneGrafos;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private ImageView imageview;
    @FXML
    private JFXComboBox<String> cbInicio;
    @FXML
    private JFXComboBox<String> cbFim;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXComboBox<String> cbVertice;
    @FXML
    private JFXComboBox<String> cbLigacao;
    @FXML
    private JFXButton btnAddCaminho;
    @FXML
    private JFXButton btnRmvGrafo;
    @FXML
    private JFXButton btnRmvLigacao;
    private ArrayList<Vertice> vertices;
    private String aux;
    private int auxInt;
    private int index;
    private int auxWidth;
    private int auxHeight;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        auxHeight = 1;
        auxWidth = 1; 
        vertices = new ArrayList<>();
        
        Image img = new Image("com/krupique/trabalho01/utils/recursos/icon1.png");
        imageview.setImage(img);
    }    

    @FXML
    private void evtAddVertice(ActionEvent event) {
        String style;
        String nome = "" + index;
        JFXButton bt = new JFXButton(nome);
        bt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                if(event.getButton().equals(MouseButton.SECONDARY)){ //Clique direito
                    System.out.println("Clique Secundário");
                }
                else if(event.getButton().equals(MouseButton.MIDDLE)){ //Clique meio
                    System.out.println("Clique meio");
                }
            }
        });
        bt.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){ //Clique esquerdo
                    bt.setLayoutX(event.getSceneX() - bt.getPrefWidth() / 2 - 320);
                    bt.setLayoutY(event.getSceneY() - bt.getPrefHeight() / 2 - 90);
                    System.out.println("Dragged");
                }
            }
        });
        bt.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                aux = bt.getText();
                aux = aux.replace("q", "");
                
                auxInt = Integer.parseInt(aux);
                System.out.println("Pressed");
            }
        });
        bt.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Released");
                Ligacao lig;
                JFXButton bt;
                Label lbl;
                bt = vertices.get(auxInt).getButton();
                for (int i = 0; i < vertices.get(auxInt).getLigSize(); i++) {
                    lig = vertices.get(auxInt).getLigacao(i);
                    lig.setStart(bt.getLayoutX() + bt.getWidth(), bt.getLayoutY() + bt.getHeight() / 2);
                    lig.setMid((lig.getStart()[0] + lig.getEnd()[0]) / 2, (lig.getStart()[1] + lig.getEnd()[1]) / 2 + 40 );
                    
                    lbl = lig.getLabel();
                    lbl.setLayoutX((lig.getLinha().getStartX() + lig.getLinha().getEndX()) / 2);
                    lbl.setLayoutY((lig.getLinha().getStartY() + lig.getLinha().getEndY()) / 2);
                    lig.setLabel(lbl);
                    
                    vertices.get(auxInt).setLigacao(lig, i);
                }
                
                for (int i = 0; i < vertices.size(); i++) {
                    for (int j = 0; j < vertices.get(i).getLigSize(); j++) {
                        lig = vertices.get(i).getLigacao(j);
                        if(lig.getLig() == auxInt)
                        {
                            lbl = lig.getLabel();
                            if(auxInt == vertices.get(i).getIndex())
                            {
                                lig.setEnd(bt.getLayoutX(), bt.getLayoutY() + bt.getHeight() / 2);
                                lig.setMid((lig.getStart()[0] + lig.getEnd()[0]) / 2 + bt.getWidth() / 2, (lig.getStart()[1] + lig.getEnd()[1]) / 2 + 140 );
                            
                                lbl.setLayoutX((lig.getLinha().getStartX() + lig.getLinha().getEndX()) / 2);
                                lbl.setLayoutY((lig.getLinha().getStartY() + lig.getLinha().getEndY()) / 2 + 30);
                            }
                            else
                            {
                                lig.setEnd(bt.getLayoutX(), bt.getLayoutY() + bt.getHeight() / 2);
                                lig.setMid((lig.getStart()[0] + lig.getEnd()[0]) / 2, (lig.getStart()[1] + lig.getEnd()[1]) / 2 + 40 );
                            
                                lbl.setLayoutX((lig.getLinha().getStartX() + lig.getLinha().getEndX()) / 2);
                                lbl.setLayoutY((lig.getLinha().getStartY() + lig.getLinha().getEndY()) / 2);
                            }
                            lig.setLabel(lbl);
                            
                            vertices.get(i).setLigacao(lig, j);
                        }
                    }
                }
            }
        });
        
        bt.setVisible(true);
        bt.setLayoutX(auxWidth);
        bt.setLayoutY(auxHeight);
        bt.setPrefSize(40, 40);
        
        paneGrafos.getChildren().add(bt);
        cbInicio.getItems().add(nome);
        cbFim.getItems().add(nome);
        cbVertice.getItems().add(nome);
        
        auxHeight += 30;
        auxWidth += 40;
        style = getEstilo();
        bt.setStyle(style);
        
        Vertice vertice = new Vertice(index, nome, bt);
        vertices.add(vertice);
        
        index++;
    }
    
    private String getEstilo() {
        return "-fx-background-radius: 15em; -fx-background-color:bababa;";
    }

    @FXML
    private void teste(MouseEvent event) {
        System.out.println("TESTE");
    }

    @FXML
    private void evtAddCaminho(ActionEvent event) {
        int ini = cbInicio.getSelectionModel().getSelectedIndex();
        int fim = cbFim.getSelectionModel().getSelectedIndex();
        Label lbl = new Label(txtValor.getText());
        QuadCurve linha;
        
        if(ini == fim)
        {
            System.out.println("Show");
            linha = new QuadCurve(vertices.get(ini).getButton().getLayoutX() + vertices.get(ini).getButton().getWidth(),
                        vertices.get(ini).getButton().getLayoutY() + vertices.get(ini).getButton().getHeight() / 2,
                        (vertices.get(ini).getButton().getLayoutX() + vertices.get(fim).getButton().getLayoutX()) / 2 + vertices.get(ini).getButton().getWidth() / 2,
                        (vertices.get(ini).getButton().getLayoutY()+ vertices.get(fim).getButton().getLayoutY()) / 2 + 140,
                        vertices.get(fim).getButton().getLayoutX(),
                        vertices.get(fim).getButton().getLayoutY() + vertices.get(fim).getButton().getHeight() / 2);
        
            lbl.setLayoutX((linha.getStartX() + linha.getEndX()) / 2);
            lbl.setLayoutY((linha.getStartY() + linha.getEndY()) / 2 + 30);
        }
        else
        {
            linha = new QuadCurve(vertices.get(ini).getButton().getLayoutX() + vertices.get(ini).getButton().getWidth(),
                        vertices.get(ini).getButton().getLayoutY() + vertices.get(ini).getButton().getHeight() / 2,
                        (vertices.get(ini).getButton().getLayoutX() + vertices.get(fim).getButton().getLayoutX()) / 2,
                        (vertices.get(ini).getButton().getLayoutY()+ vertices.get(fim).getButton().getLayoutY()) / 2 + 40,
                        vertices.get(fim).getButton().getLayoutX(),
                        vertices.get(fim).getButton().getLayoutY() );
            
            lbl.setLayoutX((linha.getStartX() + linha.getEndX()) / 2);
            lbl.setLayoutY((linha.getStartY() + linha.getEndY()) / 2);
        }
        
        Paint value = new javafx.scene.paint.Color(0, 0, 0, 0);
        linha.setFill(value);
        value = new javafx.scene.paint.Color(0, 0, 0, 1);
        linha.setStroke(value);
        paneGrafos.getChildren().add(linha);
        paneGrafos.getChildren().add(lbl);
        
        vertices.get(ini).add(new Ligacao(fim, txtValor.getText(), linha, lbl));
    }

    @FXML
    private void evtRmvGrafo(ActionEvent event) {
    }

    @FXML
    private void evtRmvLigacao(ActionEvent event) {
    }
    
}
