/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical;

import java.text.DecimalFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */
public class FixedN {

    public FixedN(double p0 , double eps , int max , String equ) throws ScriptException {
    double p ;
    int i =1;
            while (i<=max){
            p = func(p0,equ);

            if(Math.abs(p-p0) <eps*0.01)
                break;

            

            i++;
            p0 = p;

            if(i>max)
                System.out.printf("Method failed after %d iterations\n", max);
        }
            i--;
        
        DecimalFormat format = new DecimalFormat("#.0000");
        String form = format.format(p0) ;
        double x = Double.parseDouble(form);
        
        
        JOptionPane.showMessageDialog(null,  "The value of root is :"+ x);
            System.out.printf("Iteration %d: Current value  %.4f\n", i,p0);
    
    }
    //x=......
     double func(double x, String equ) throws ScriptException {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        engine.put("x", x);
        return (double) engine.eval(equ);

    }
    
    /*static double g(double x){
        return 1/(Math.sqrt(1+x));
    }*/
    
    
}
