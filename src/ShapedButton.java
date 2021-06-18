
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;

/**
 * 
 */
public class ShapedButton extends Button{
    
    private Double[] points;
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
    * @param numberOfSides
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
    * 
    * @param numberOfSides
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
 * 
 * @param xCoordinates
 * @param yCoordinates
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
 * 
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
 * 
 */
    public void createShape(){
        shape= new Polygon();
        shape.getPoints().addAll(points);
    }

/**
 * 
 * @param degrees
 */
    public void rotate(double degrees){

        for (int i = 0; i<xCoordinates.length; i++ ){
        double xPoint = xCoordinates[i];
        double yPoint = yCoordinates[i];

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
     * 
     */
    public void updateShape(){
        createShape();
        setShape(shape);
    }

    
}
