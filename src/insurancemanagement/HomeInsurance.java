
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancemanagement;

/**
 *
 * @author Dale K James
 */
public class HomeInsurance extends Policy {
    
    private String address; //address of insured home
    private double area;    //in square feet 
    private int yearBuilt;  //year in which house was built

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    } 
}


