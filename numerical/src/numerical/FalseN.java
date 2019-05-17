
package numerical;
import java.text.DecimalFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public class FalseN {

    FalseN(double a, double b,int max , String equ) throws ScriptException 
    { 
        if (func(a,equ) * func(b,equ) >= 0)  
        { 
            JOptionPane.showMessageDialog(null,"You have not assumed right a and b");
            System.out.println("You have not assumed right a and b"); 
        } 

        double c = a;  
  
        for (int i = 0; i < max; i++)  
        { 
            // Find the point that touches x axis 
            c = (a * func(b,equ) - b * func(a,equ))  
                 / (func(b,equ) - func(a,equ)); 
  
            // Check if the above found point is root 
            if (func(c,equ) == 0) 
                break; 
  
            // Decide the side to repeat the steps 
            else if (func(c,equ) * func(a,equ) < 0) 
                b = c; 
            else
                a = c; 
        } 
        
        DecimalFormat format = new DecimalFormat("#.0000");
        String form = format.format(c) ;
        double x = Double.parseDouble(form);
        
        
        JOptionPane.showMessageDialog(null,  "The value of root is :"+ x);
        System.out.println("The value of root is : " + c); 
    } 
        
    
     double func(double x, String equ) throws ScriptException {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        engine.put("x", x);
        return (double) engine.eval(equ);

    }
}
