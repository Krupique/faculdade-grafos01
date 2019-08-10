/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krupique.trabalho01.init;

import com.jfoenix.controls.JFXButton;
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

    
    private ArrayList<Vertice> vertices;
    private String aux;
    private int auxInt;
    private int index;
    private int auxWidth;
    private int auxHeight;
    /**
     * Initializes the controller class.
     */
    ArrayList<String> lista_nomes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        auxHeight = 1;
        auxWidth = 1; 
        vertices = new ArrayList<>();
        
        Image img = new Image("com/krupique/trabalho01/utils/recursos/icon1.png");
        imageview.setImage(img);
        lista_nomes = new ArrayList<>();
    }    

    @FXML
    private void evtAddVertice(ActionEvent event) {
        lista_nomes.add("A");
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
                    bt.setLayoutX(event.getSceneX() - bt.getPrefWidth() / 2 - 15);
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
        //cbLigInicio.getItems().add(nome);
        //cbLigFim.getItems().add(nome);
        
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
        
    }
    
}
