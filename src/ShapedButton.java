
import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;
import java.awt.geom.AffineTransform;
/**
 * 
 */
public class ShapedButton extends Button{
    
    private Double[] points;
    private Polygon shape;
    private int numberOfSides;
    private double[] xCoordinates;
    private double[] yCoordinates;

   /**
    * @param numberOfSides
    */
    public ShapedButton(int numberOfSides, double length) {
        super();

        if (numberOfSides <3){
        throw new IllegalArgumentException("The provided number of sides are not sufficent to create a polygon");
        }

        this.numberOfSides = numberOfSides;
        
        points = new Double[numberOfSides * 2];

         xCoordinates = new double[numberOfSides];
         yCoordinates = new double[numberOfSides];

        calculatePoints(numberOfSides, length);
        createShape();
        setShape(shape);
        setPrefSize(100,100);
        setMinSize(60,60);
            


    }


 /**
    * 
    * @param numberOfSides
    */
    public ShapedButton(double[] coordinates) {
        super();

        if (coordinates.length / 6 <= 1){
            throw new IllegalArgumentException("The provided number of coordinates are not sufficent to create a polygon");
            }

        if (coordinates.length % 2 == 1){
        throw new IllegalArgumentException("The provided x points are not the same length as the provided y points.");
        }
     
        
        this.numberOfSides =  coordinates.length /2;
        
        points = new Double[numberOfSides * 2];

        createShape();
        setShape(shape);
        setPrefSize(100,100);
        setMinSize(60,60);
            
    }


/**
 * 
 * @param numberOfSides
 * @param length
 */
    public void calculatePoints(int numberOfSides, double length){


        

        double theta = Math.PI/2;
        double dTheta = 2 * Math.PI / numberOfSides; 

        xCoordinates[0] = 0.0;
        yCoordinates[0] = length;


        for(int i =1; i< numberOfSides; i++){
        theta += dTheta;
        xCoordinates[i]= xCoordinates[i-1] + length * Math.cos(theta);
        yCoordinates[i]= yCoordinates[i-1] + length * Math.sin(theta);

        }

        if(numberOfSides%2 ==1){
            rotate(theta);
        }
        mergeCoordinates(xCoordinates, yCoordinates);
        
            }


    private void mergeCoordinates(double[] xCoordinates, double[] yCoordinates){

        int k=0;
        int j=0;
        for(int i =0; i< numberOfSides*2; i++){

            if (i%2 ==0){
                points[i]= xCoordinates[k++];
            }else{
                points[i]= yCoordinates[j++];
            }
        }
    }
/**
 * 
 */
    public void createShape(){
        shape= new Polygon();
        shape.getPoints().addAll(points);
    }


    public void rotate(double degrees){

        for (int i = 0; i<xCoordinates.length; i++ ){
        double xPoint = xCoordinates[i];
        double yPoint = yCoordinates[i];

        xCoordinates[i] = xPoint*Math.cos(degrees) - yPoint * Math.sin(degrees);
        yCoordinates[i] = yPoint*Math.cos(degrees) + xPoint * Math.sin(degrees);

        }

        mergeCoordinates(xCoordinates, yCoordinates);

    }
}
