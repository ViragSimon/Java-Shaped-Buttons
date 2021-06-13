
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
    public ShapedButton(int numberOfSides, double length) {
        super();
        
        points = new Double[numberOfSides * 2];

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
    public void calculatePoints(int numberOfSides, double length){

        Double[] xCoordinates = new Double[numberOfSides];
        Double[] yCoordinates = new Double[numberOfSides];

// new calculation of popints

double theta = Math.PI/2;
double dTheta = 2* Math.PI / numberOfSides; 
xCoordinates[0] = 0.0;
yCoordinates[0] = length;

for(int i =1; i< numberOfSides; i++){
theta += dTheta;
xCoordinates[i]= xCoordinates[i-1] + length * Math.cos(theta);
yCoordinates[i]= yCoordinates[i-1] + length * Math.sin(theta);

}

        int k=0;
        int j=0;
        for(int i =0; i< numberOfSides*2; i++){

            if (i%2 ==0){
                points[i]= xCoordinates[k++];
                System.out.println("x " + points[i]);
            }else{
                points[i]= yCoordinates[j++];
                System.out.println("y " + points[i]);
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

    }
/**
 * 
 * @return
 */
    public Double[] calculateCentroid(){

    return new Double[3];
    }


}
