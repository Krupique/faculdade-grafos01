/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krupique.trabalho01.estruturas.grafo;

import com.jfoenix.controls.JFXButton;
import java.util.ArrayList;
import javafx.event.EventType;
import javafx.scene.shape.Line;

/**
 *
 * @author Henrique K. Secchi
 */
public class Vertice {
    private JFXButton button;
    private ArrayList<Ligacao>lig;
    private String nome;
    private int index;
    private int tipo; //0-Inicial, 1-Transição, 2-Final
    
    public Vertice (int index, String nome, JFXButton button)
    {
        this.button = button;
        this.index = index;
        this.nome = nome;
        
        this.lig = new ArrayList<Ligacao>();
    }
    
    public void add(Ligacao l)
    {
        this.lig.add(l);
    }
    
    public Ligacao getLigacao(int pos)
    {
        return lig.get(pos);
    }
    
    public void setLigacao(Ligacao lig, int pos)
    {
        this.lig.set(pos, lig);
    }
    
    public int getLigSize()
    {
        return lig.size();
    }
    
    public void removePos(int pos)
    {
        lig.remove(pos);
    }

    public JFXButton getButton() {
        return button;
    }

    public void setButton(JFXButton button) {
        this.button = button;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
