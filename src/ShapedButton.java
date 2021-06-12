
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;
/**
 * 
 */
public class ShapedButton extends Button{
    
    private Double[] points;
    private Polygon shape;

   /**
    * 
    * @param numberOfSides
    */
    public ShapedButton(int numberOfSides) {
        super();
        
        points = new Double[numberOfSides*2];

        calculatePoints(numberOfSides);
        createShape();
        setShape(shape);
        setPrefSize(100,100);
        setMinSize(60,60);
            
    }
/**
 * 
 * @param numberOfSides
 */
    public void calculatePoints(int numberOfSides){

        double degrees = ((numberOfSides - 2 ) * 180 ) / numberOfSides ;
        double alpha = degrees;
        double beta = (180 - alpha)/2;
        double gamma = 90 - beta;
        double sideLength = points[2] - points[0];

        double verticalMove = sideLength * Math.sin(beta);
        double horizontalMove =sideLength * Math.sin(gamma); 

        Double[] xCoordinates = new Double[numberOfSides];
        Double[] yCoordinates = new Double[numberOfSides];

        xCoordinates[0] =200.0;
        xCoordinates[1] =400.0;

        yCoordinates[0] = 100.0;
        yCoordinates[1] = 100.0;

        for(int i =2; i<numberOfSides; i++){
            xCoordinates[i] = xCoordinates[i-1] + horizontalMove; 
            yCoordinates[i] = yCoordinates[i-1] + verticalMove;
        }

        for(int i =0; i< numberOfSides*2; i++){
            points[i]= xCoordinates[i];
            i++;
            points[i]= xCoordinates[i-1];
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

    }

 
    public void setMinHeight(int minHeight){

    }
      
    public void setMinWidth(int minWidth){

    }

    public void resize(double width,double height){
        
    }


}
