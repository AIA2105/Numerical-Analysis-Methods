/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */
public class numerical {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ScriptException {
        
        while (true) {            
            
         String x = JOptionPane.showInputDialog("1- Bisection\n2- Fixed point\n3- False position\n4- Newton\n5- Exit");
         if (x.isEmpty()){JOptionPane.showMessageDialog(null, "Try again Later !");
             main(args);
            
         }
         
        switch (Integer.parseInt(x))
        {
            case 1 : 
                String a = JOptionPane.showInputDialog( "Enter a"); 
                String b = JOptionPane.showInputDialog("Enter b");
                String EPSILON = JOptionPane.showInputDialog("Enter EPSILON");
                String Equ = JOptionPane.showInputDialog("Enter Equation");
                bisectionN bisection = new bisectionN(Double.parseDouble(a),Double.parseDouble(b),Double.parseDouble(EPSILON), Equ);
                
                break ;
            case 2 :
                 a = JOptionPane.showInputDialog( "Enter a"); 
                 b = JOptionPane.showInputDialog("Enter Max itretion");
                 EPSILON = JOptionPane.showInputDialog("Enter EPSILON");
                 Equ = JOptionPane.showInputDialog("Enter x = ....");
                 FixedN fixed =new FixedN(Double.parseDouble(a), Double.parseDouble(EPSILON),Integer.parseInt(b) , Equ);
                break ;
            case 3 :
                 a = JOptionPane.showInputDialog( "Enter a"); 
                 b = JOptionPane.showInputDialog("Enter b");
                 EPSILON = JOptionPane.showInputDialog("Enter Max itretion");
                 Equ = JOptionPane.showInputDialog("Enter Equation");
                 FalseN fals = new FalseN(Double.parseDouble(a),Double.parseDouble(b),Integer.parseInt(EPSILON), Equ);
                break ;
            case 4 :
                 a = JOptionPane.showInputDialog( "Enter x0"); 
                 EPSILON = JOptionPane.showInputDialog("Enter EPSILON");
                 Equ = JOptionPane.showInputDialog("Enter Equation");
                 b = JOptionPane.showInputDialog("Enter Derivative");

                 NewtonN newton = new NewtonN(Double.parseDouble(a),Double.parseDouble(EPSILON),Equ, b);
                break;
            case 5 :
                System.exit(0);
                break;
                
            default: JOptionPane.showMessageDialog(null, "please choose a correct number");
        }
        }
        
        //bisectionN e = new bisectionN(0, 1, 0.0001, "x*x*x+x*x-1");
        //FalseN f = new FalseN(2, 3, 10, "x*x*x - 2*x - 5");
        //FixedN g = new FixedN(0, 0.001, 6, "1/3*(Math.cos(x)+1)");
        //NewtonN h = new NewtonN(0.6, 0.0001, "3*x-Math.cos(x)-1", "3+Math.sin(x)");
        
        //bisection a = new bisection(2.706,2.707,0.0001); //in between values
        //Fixed b = new Fixed();
        //False c = new False(2,3); //in between values
        //Newton d = new Newton(0.6); //value of x0
    }
    
}
