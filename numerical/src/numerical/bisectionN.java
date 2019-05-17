
package numerical;
import java.text.DecimalFormat;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.JOptionPane;


public class bisectionN {
    
     bisectionN(double a, double b ,double EPSILON,String equ) throws ScriptException 
    { 
        if (func(a,equ) * func(b,equ) >= 0) 
        { 
            JOptionPane.showMessageDialog(null,"You have not assumed"
                        + " right a and b");
            System.out.println("You have not assumed"
                        + " right a and b"); 
            return; 
        } 
  
        double c = a; 
        while ((b-a) >= EPSILON*0.1) 
        { 
            // Find middle point 
            c = (a+b)/2; 
  
            // Check if middle point is root 
            if (func(c,equ) == 0.0) 
                break; 
  
            // Decide the side to repeat the steps 
            else if (func(c,equ)*func(a,equ) < 0) 
                b = c; 
            else
                a = c; 
        } 
        
        //prints value of c upto 4 decimal places 
        DecimalFormat format = new DecimalFormat("#.0000");
        String form = format.format(c) ;
        double x = Double.parseDouble(form);
        
        
        JOptionPane.showMessageDialog(null,  "The value of root is :"
                        + x);       
        System.out.printf("The value of root is : %.4f"
                        ,c); 
    } 
    
     double func(double x, String equ) throws ScriptException {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        engine.put("x", x);
        return (double) engine.eval(equ);

    }
}
