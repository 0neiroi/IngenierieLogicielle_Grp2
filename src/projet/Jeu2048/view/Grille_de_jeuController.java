/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Jeu2048.view;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashSet;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import projet.Jeu2048.Fenetre2048;
import projet.Jeu2048.model.Case;
import projet.Jeu2048.model.Parametres;

/**
 * FXML Controller class
 *
 * @author oneiroi
 */
public class Grille_de_jeuController implements Initializable {
    
    @FXML 
    Fenetre2048 mainApp;
    
    @FXML
    GridPane myGridPane;
    
    @FXML
    Label upBtn;
    
    @FXML
    Label leftBtn;
    
    @FXML
    Label rightBtn;
    
    @FXML
    Label downBtn;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setMainApp(Fenetre2048 mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        
    }
     
    @FXML 
    private void keyButtonAction(KeyEvent event ) {
        String str = event.getCharacter();
        HashSet<Case> grilleCopie=new HashSet<>();
        grilleCopie.addAll(mainApp.getMaGrille().getGrille());
        switch(str){
            case "w":
                    mainApp.getMaGrille().seDeplacer(Parametres.haut);
                    break;
            case "s":
                    mainApp.getMaGrille().seDeplacer(Parametres.bas);
                    break;
            case "a":
                    mainApp.getMaGrille().seDeplacer(Parametres.gauche);
                    break;
            case "d":
                    mainApp.getMaGrille().seDeplacer(Parametres.droite);
                    break;
            default:
                    System.out.println("NOP!");
                   break;
                    
        } 
        if(!grilleCopie.equals(mainApp.getMaGrille().getGrille())){
            mainApp.getMaGrille().nouvelleCase();
        }
        this.myGridPane.getChildren().removeAll();
        for(int j=0;j>-4;j--){
                this.myGridPane.add(new Tuile(this.mainApp.getMaGrille().getCase(0,j).getValeur()).tuileDeJeu,0,j*-1);
                for(int i=1;i<4;i++){
                    this.myGridPane.add(new Tuile(this.mainApp.getMaGrille().getCase(i,j).getValeur()).tuileDeJeu,i,j*-1);
                }
            }
        
    }
     
     
     
    @FXML 
    private void handleButtonAction(MouseEvent event ) {
        String str = ((Label)event.getSource()).getId();
        HashSet<Case> grilleCopie=new HashSet<>();
        grilleCopie.addAll(mainApp.getMaGrille().getGrille());
        switch(str){
            case "upBtn":
                    mainApp.getMaGrille().seDeplacer(Parametres.haut);
                    break;
            case "downBtn":
                    mainApp.getMaGrille().seDeplacer(Parametres.bas);
                    break;
            case "leftBtn":
                    mainApp.getMaGrille().seDeplacer(Parametres.gauche);
                    break;
            case "rightBtn":
                    mainApp.getMaGrille().seDeplacer(Parametres.droite);
                    break;
                    
        } 
        if(!grilleCopie.equals(mainApp.getMaGrille().getGrille())){
            mainApp.getMaGrille().nouvelleCase();
        }
        this.myGridPane.getChildren().removeAll();
        for(int j=0;j>-4;j--){
                this.myGridPane.add(new Tuile(this.mainApp.getMaGrille().getCase(0,j).getValeur()).tuileDeJeu,0,j*-1);
                for(int i=1;i<4;i++){
                    this.myGridPane.add(new Tuile(this.mainApp.getMaGrille().getCase(i,j).getValeur()).tuileDeJeu,i,j*-1);
                }
            }
    }
    
}
