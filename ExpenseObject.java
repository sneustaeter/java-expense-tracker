package pkg;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExpenseObject {

    //Variables pertaining to the ExpenseObject
    public String name = "";
    public double cost = 0;
    public int qty = 0;
    public double totalCost = 0;
    public String date = "";
    public String paymentMethod = "";

    //Null Constructor
    public ExpenseObject() {
    }

    //Constructor w/ args
    //Takes all data needed for object and gets at once for ease
    public ExpenseObject(String nameIn, double costIn, int qtyIn, double totalIn, String dateIn, String paymentIn) {
        name = nameIn;
        cost = costIn;
        qty = qtyIn;
        totalCost = totalIn;
        date = dateIn;
        paymentMethod = paymentIn;
    }

    //Geters and setters
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double newCost) {
        cost = newCost;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int newQty) {
        qty = newQty;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double newTotalCost) {
        totalCost = newTotalCost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String newDate) {
        date = newDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String newPaymentMethod) {
        paymentMethod = newPaymentMethod;
    }

    //ToString Method
    @Override
    public String toString() {
        return "Name:" + name + ";Cost:" + cost + ";Qty:" + qty + ";Total Cost:" + totalCost + ";Date:" + date + ";Payment Method:" + paymentMethod;
    }

    //toFile Method using toString()
    public void toFile(String path) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        PrintWriter out = new PrintWriter(fw);
        out.println(toString());
        out.close();

    }
    
    //Static To File method using String
    public static void toFile(String path, String data) throws IOException{
        FileWriter fw = new FileWriter(path, true);
        PrintWriter out = new PrintWriter(fw);
        out.println(data);
        out.close();
    }

}
