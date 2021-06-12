
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
class CrossButton extends Button   {
    private static  javafx.scene.shape.Polygon cross;
    

    /**
     * Creates a new HexagonButton object
     * 
     * @param manager The Arraymanager that holds the list of properties
     * @param neighborhood The correct name of the borough
     * @param abbreviation The abbreviated version of the name of the borough
     * @param cartController The cartController that holds the objects in the cart
     */
    public CrossButton() {
        
        cross= new Polygon();
        addPoints();
        setShape(cross);
        setPrefSize(100,100);
        setMinSize(60,60);

    }
    
    /**
     * Add shape defining points to object
     * These points define the border of the ploygon that shapes the buttons
     */
    public void addPoints() {
        cross.getPoints().addAll(
                new Double[]{
                300.0,100.0,
                400.0,100.0,
                400.0,300.0,
                600.0,300.0,
                600.0,400.0,
                400.0,400.0,
                400.0,600.0,
                300.0,600.0,
                300.0,400.0,
                100.0,400.0,
                100.0,300.0,
                300.0,300.0
            });

    }
    
}


