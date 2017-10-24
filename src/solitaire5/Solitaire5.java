/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solitaire5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author lkettlex
 */
public class Solitaire5 extends Application {
    GameLoop gameLoop  = new GameLoop(this);
    final int PREF_WIDTH = 990;
    final int PREF_HEIGHT = 684;
    private static GridPane root;
    private static InitialPoo poo = new InitialPoo();
    private final static List<Card> allCards = loadCards(); // all Cards from res.cards location
    
    @Override
    public void start(Stage primaryStage) {
        root = initGrid();
        Scene scene = new Scene(root, PREF_WIDTH, PREF_HEIGHT);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        gameLoop.start();
    }
    
    private GridPane initGrid()
    {
        GridPane grid = new GridPane();
        for (int i = 0; i < 7; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0/7);
            col.setHalignment(HPos.CENTER);
            grid.getColumnConstraints().add(col);
        }
        
        RowConstraints row1 = new RowConstraints();
        row1.setValignment(VPos.CENTER);
        row1.setPercentHeight(33.333333);
        grid.getRowConstraints().add(row1);
        
        RowConstraints row2 = new RowConstraints();
        row2.setValignment(VPos.TOP);
        row2.setPercentHeight(66.666666);
        grid.getRowConstraints().add(row2);
        
        grid.gridLinesVisibleProperty().set(true);
        grid.setStyle("-fx-background-color:green");

//        grid.setHgap(10);
        return grid;
    }
    
    private static List<Card> loadCards(){
        List<Card> tempCardList = new ArrayList<>();
        File[][] cardFiles = new File[4][];
        
        cardFiles[0] = new File("src/res/cards/heart").listFiles();
        cardFiles[1] = new File("src/res/cards/diamond").listFiles();
        cardFiles[2] = new File("src/res/cards/club").listFiles();
        cardFiles[3] = new File("src/res/cards/spade").listFiles();
        
        for (int i = 0; i < 4; i++) {
            for (File cardFile : cardFiles[i]) {
                String pathName = "file:" + cardFile.getAbsolutePath();
                int cardNumber = Integer.parseInt(cardFile.getName().replace(".png", ""));
                switch (i){
                    case 0:
                        tempCardList.add(new Card(pathName,Figure.KIER,cardNumber, poo));
                        break;
                    case 1:
                        tempCardList.add(new Card(pathName,Figure.KARO,cardNumber, poo));
                        break;
                    case 2:
                        tempCardList.add(new Card(pathName,Figure.TREFL,cardNumber, poo));
                        break;
                    case 3:
                        tempCardList.add(new Card(pathName,Figure.PIK,cardNumber, poo));
                        break;
                    default:
                        break;
                }
            }
        }
        return tempCardList;
    }
    
    public void gameUpdate(){        
        //isMousePressed();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
