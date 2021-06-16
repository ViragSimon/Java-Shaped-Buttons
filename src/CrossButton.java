

/**
 * This class represtens the customized hexagonshaped button that is used in the borough map
 * 
 * 
 * @author  Simon Istvan Virag
 * @version 28.03.2021
 */
class CrossButton extends ShapedButton   {

    

  
    public CrossButton(){
        super(new Double[]{
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


