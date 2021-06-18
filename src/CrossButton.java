

/**
 * This class represtens the customized Cross shaped button 
 * 
 * 
 * @author  Simon Istvan Virag
 * @version 28.05.2021
 */
class CrossButton extends ShapedButton   {

    
/**
 * Constructor of a CrossButton that defines the intial coordinates of a CrossButton instance
 */
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


