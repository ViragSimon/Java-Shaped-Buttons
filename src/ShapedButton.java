
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;

/**
 * This class represtens the customized Arrow shaped button 
 * 
 * 
 * @author  Simon Istvan Virag
 * @version 28.05.2021
 */
public class ShapedButton extends Button{
    
    private Double[] points; // points to create a shape
    private Polygon shape; 
    private int numberOfSides; 
    private Double[] xCoordinates; 
    private Double[] yCoordinates;

    /**
     * 
     * @param coordinateSize 
     */
    public ShapedButton(int coordinateSize){
        xCoordinates = new Double[coordinateSize];
        yCoordinates = new Double[coordinateSize];
        points = new Double[coordinateSize * 2];
    }


    /**
     * Constructor for a symmetric polygon
     * 
     * @param numberOfSides
     * @param length distance of edges from the centre
     */
    public ShapedButton(int numberOfSides, Double length) {
        super();

        if (numberOfSides <3){
        throw new IllegalArgumentException("The provided number of sides are not sufficent to create a polygon");
        }

        this.numberOfSides = numberOfSides;
        
        points = new Double[numberOfSides * 2];

         xCoordinates = new Double[numberOfSides];
         yCoordinates = new Double[numberOfSides];

        calculatePoints(numberOfSides, length);
        createShape();
        setShape(shape);
        setPrefSize(100,100);
        setMinSize(60,60);
            


    }


/**
 * Contstuctor of a button with given coordinates
 * 
 * @param coordinates An array that has both x and y coordinates 
 */
    public ShapedButton(Double[] coordinates) {
        super();

        if (coordinates.length / 6 <= 1){
            throw new IllegalArgumentException("The provided number of coordinates are not sufficent to create a polygon");
            }

        if (coordinates.length % 2 == 1){
        throw new IllegalArgumentException("The provided x points are not the same length as the provided y points.");
        }

        this.numberOfSides =  coordinates.length /2;
        
        points = new Double[coordinates.length];
        points = coordinates;
        xCoordinates = new Double[numberOfSides];
        yCoordinates = new Double[numberOfSides];
        separateCoordinates();
        createShape();
        setShape(shape);
        setPrefSize(100,100);
        setMinSize(60,60);
            
    }

/**
 * Calculates the points for a symmetric polygon
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

/**
 * Merges the x and y coordiantes into the poiunts array
 * 
 * @param xCoordinates points on the x axis
 * @param yCoordinates points on the y axis
 */
    protected void mergeCoordinates(Double[] xCoordinates, Double[] yCoordinates){

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
 * This method separates the x and y coordinates from the points array 
 * and allocate them to their corresponding arrays: xCoordinates, yCoordintes
 */
protected void separateCoordinates(){
int k =0;
int j =0;
    for(int i =0; i< points.length; i++){

        if(i%2 ==0){
            xCoordinates[k++] = points[i];
        }else{
            yCoordinates[j++] = points[i];
            }


    }

}

/**
 * Creates the shape of the button and sets it 
 */
    public void createShape(){
        shape= new Polygon();
        shape.getPoints().addAll(points);
    }

/**
 * Rotates the polygon with the given degrees
 * 
 * @param degrees number of degrees of rotation, anticlockwise
 */
    public void rotate(double degrees){

        for (int i = 0; i<xCoordinates.length; i++ ){
        double xPoint = xCoordinates[i];
        double yPoint = yCoordinates[i];

        //translate coordinates
        xCoordinates[i] = xPoint*Math.cos(degrees) - yPoint * Math.sin(degrees);
        yCoordinates[i] = yPoint*Math.cos(degrees) + xPoint * Math.sin(degrees);

        }

        mergeCoordinates(xCoordinates, yCoordinates);
        createShape();
        setShape(shape);

    }

/**
 * 
 * @param newXCoordiantes
 */
    public void setXCoordinates(Double [] newXCoordiantes){
xCoordinates = newXCoordiantes;
    }

    /**
     * 
     * @param newYCoordiantes
     */
    public void setYCoordinates(Double [] newYCoordiantes){
        yCoordinates = newYCoordiantes;
    }

    /**
     * Upadate the shape of the button  
     */
    public void updateShape(){
        createShape();
        setShape(shape);
    }

    
}
