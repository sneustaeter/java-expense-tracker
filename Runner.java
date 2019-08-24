package pkg;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Runner {

    public static void main(String[] args) throws IOException {

        //ArrayList to Store the ExpenseObjects
        ArrayList<ExpenseObject> expenses = new ArrayList<ExpenseObject>();
        
        //Input Loop Control Variable
        boolean proceed = false;

        //Loop to Get input until user is done
        while (proceed == false) {

            //Creates new ExpenseObject
            ExpenseObject exp = new ExpenseObject();
            
            //Sets the ExpenseObject Properties using a GUI form for user input
            exp.setName(JOptionPane.showInputDialog(null, "Enter the Name of the Expense"));
            exp.setCost(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the Cost per Item")));
            exp.setQty(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Quantity of Items Purchased")));
            exp.setTotalCost(exp.getCost() * exp.getQty());
            exp.setDate(JOptionPane.showInputDialog(null, "Enter the Date the Expense was Incurred on in MM/DD/YYYY Format"));
            exp.setPaymentMethod(JOptionPane.showInputDialog(null, "Enter the Payment Method Used"));
            
            //Writes the ExpenseObject to terminal. Mostly for debugging
            System.out.println(exp.toString());

            //Asks user if they have more to input
            int usrIn = JOptionPane.showConfirmDialog(null, "Do You Have More Expenses to Add?", "", JOptionPane.YES_NO_OPTION);
            
            //Checks if user clicks yes
            if (usrIn == JOptionPane.YES_OPTION) {
                //Set loop control to continue looping
                proceed = false;
            }
            //If user does not click yes
            else {
                //Sets loop control to terminate loop
                proceed = true;
            }
            
            //Adds ExpenseObject to ArrayList
            expenses.add(exp);
        }
        
        //Writes ArrayList of ExpenseObjects to terminal for debugging
        System.out.println(expenses.toString());

        //Gets path to outfile
        String path = JOptionPane.showInputDialog(null, "Enter the Path to Save the File To");
        
        //Creates variable for output
        String out = "";
        
        //Loop through ArrayList and add each ExpenseObject to output string 
        for(int i = 0; i < expenses.size(); i++){
            out += expenses.get(i).toString();
            //Adds new line on end if not last item
            if(i < expenses.size()-1){
                out += "\n";
            }
        }
        
        //Get sort method
        
        
        //Show preview to user
        
        //Writes all ExpenseObjects to file
        ExpenseObject.toFile(path, out);
                
        //Exits the program gracefully to ensure no memory leaks
        System.exit(0);
    }

}
