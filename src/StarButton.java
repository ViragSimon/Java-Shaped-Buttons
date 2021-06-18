
public class StarButton extends ShapedButton{
    
    public StarButton(Double length) {   
        super(10);
        Double[] xCoordinates = new Double[10];
        Double[] yCoordinates = new Double[10];
        int j = 0;
        int k = 0;
        for(int i =0; i< 10; i++){
            if(i%2==0){
                xCoordinates[i] = length*Math.cos(90 + (72* j));
                yCoordinates[i] =length*Math.sin(90 + (72* j++));


            }else{
                xCoordinates[i] = (length/2) *Math.cos(126 + (72* k));
                yCoordinates[i] = (length/2) *Math.sin(126 + (72* k++));

            }
           
        }
        setXCoordinates(xCoordinates);
        setYCoordinates(yCoordinates);
        mergeCoordinates(xCoordinates, yCoordinates);
        updateShape();

    }
     
}
