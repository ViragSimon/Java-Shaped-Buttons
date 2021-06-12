
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;

import java.util.HashMap;

/**
 * This class represtens the customized hexagonshaped button that is used in the borough map
 * 
 * 
 * @author  Simon Istvan Virag
 * @version 28.03.2021
 */
class ArrowButton extends Button   {
    private static  javafx.scene.shape.Polygon arrow;
    

   
    public ArrowButton() {
        
        arrow= new Polygon();
        addPoints();
        setShape(arrow);
        setPrefSize(100,100);
        setMinSize(60,60);

    }
    
    /**
     * Add shape defining points to object
     * These points define the border of the ploygon that shapes the buttons
     */
    public void addPoints() {
        arrow.getPoints().addAll(
                new Double[]{
               100.0,200.0,
               400.0,200.0,
               400.0,100.0,
               550.0,250.0,
               400.0,400.0,
               400.0,300.0,
               100.0,300.0
            });

    }
    
}


