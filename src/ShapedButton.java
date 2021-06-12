
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;

public class ShapedButton extends Button{
    
    private Double[] points;
    private Polygon shape;
   
    public ShapedButton(int numberOfSides) {
        super();
        
        points = new Double[numberOfSides*2];

        calculatePoints(numberOfSides);
        createShape();
        setShape(shape);
        setPrefSize(100,100);
        setMinSize(60,60);
            
    }

    public void calculatePoints(int numberOfSides){
        points[0] = 200.0;
        points[1] = 100.0;
        points[2] = 400.0;
        points[3] = 100.0;

        double degrees = ((numberOfSides - 2 ) * 180 ) / numberOfSides ;
        double alpha = degrees;
        double beta = (180 - alpha)/2;
        double gamma = 9 - beta;
        double sideLength = points[2] - points[0];

        double verticalMove = sideLength * Math.sin(beta);
        double horizontalMove =sideLength * Math.sin(gamma); 

        for(int i =0; i<numberOfSides-2; i++){
            points[i+4] = points[i+2] + horizontalMove;
            points[i+5] = points[i+3] + verticalMove;
        }
        
            }

    public void createShape(){
        shape= new Polygon();
        shape.getPoints().addAll(points);
        
    }
        

}
