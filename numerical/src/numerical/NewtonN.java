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
public class NewtonN {

    public NewtonN(double x0 , double eps , String fun ,String derv) throws ScriptException {
    
         double h = func(x0,fun) / derivFunc(x0,derv); 
        while (Math.abs(h) >= eps) 
        { 
            h = func(x0,fun) / derivFunc(x0,derv); 
      
            // x(i+1) = x(i) - f(x) / f'(x)  
            x0 = x0 - h; 
        } 
      
        DecimalFormat format = new DecimalFormat("#.0000");
        String form = format.format((x0 * 100.0) / 100.0);
        double x = Double.parseDouble(form);
        
        
        JOptionPane.showMessageDialog(null,  "The value of root is :"+ x);
        System.out.printf("The value of the root is : %4f" 
                , (x0 * 100.0) / 100.0); 
    }    
    
        //function
         double func(double x, String equ) throws ScriptException
        {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        engine.put("x", x);
        return (double) engine.eval(equ);
        }
        //derivative
          double derivFunc(double x, String equ) throws ScriptException
        {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        engine.put("x", x);
        return (double) engine.eval(equ);
        }
    
    
}
