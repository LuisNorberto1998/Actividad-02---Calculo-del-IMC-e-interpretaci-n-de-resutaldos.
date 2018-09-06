
package main;

import models.ModelImc;
import views.ViewImc;
import controllers.ControllerImc;
/**
 *
 * @author Norberto
 */
public class Main {
    private static ModelImc modelImc;
    private static ViewImc viewImc;
    private static ControllerImc controllerImc;

    public static void main(String[] args) 
    {
        modelImc = new ModelImc();
        viewImc = new ViewImc();
        controllerImc = new ControllerImc(modelImc, viewImc);
        
       
    }
    
}
