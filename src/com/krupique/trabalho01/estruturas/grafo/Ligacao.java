/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krupique.trabalho01.estruturas.grafo;

import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;

/**
 *
 * @author Henrique K. Secchi
 */
public class Ligacao
{
    private int lig;
    private String caracter;
    private QuadCurve linha;
    private Label label;

    public Ligacao()
    {
    }

    public Ligacao(int lig, String caracter, QuadCurve linha, Label label)
    {
        this.lig = lig;
        this.caracter = caracter;
        this.linha = linha;
        this.label = label;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public int getLig()
    {
        return lig;
    }

    public void setLig(int lig)
    {
        this.lig = lig;
    }

    public String getCaracter()
    {
        return caracter;
    }

    public void setCaracter(String caracter)
    {
        this.caracter = caracter;
    }

    public QuadCurve getLinha()
    {
        return linha;
    }

    public void setLinha(QuadCurve linha)
    {
        this.linha = linha;
    }
    
    public void setEnd(double x, double y)
    {
        linha.setEndX(x);
        linha.setEndY(y);
    }
    
    public void setStart(double x, double y)
    {
        linha.setStartX(x);
        linha.setStartY(y);
    }
    
    public void setMid(double x, double y)
    {
        linha.setControlX(x);
        linha.setControlY(y);
    }
    
    public double[] getEnd()
    {
        double[] pos = new double[2];
        pos[0] = linha.getEndX();
        pos[1] = linha.getEndY();
        
        return pos;
    }
    
    public double[] getStart()
    {
        double[] pos = new double[2];
        pos[0] = linha.getStartX();
        pos[1] = linha.getStartY();
        
        return pos;
    }
    
}
