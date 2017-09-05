/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancemanagement;

/**
 *
 * @author Dale K James
 */
public class VehicleInsurance extends Policy{
    
    private String model;   //vehicle model
    private int year; 
    private long licenseNo; //license of driver
    private int suspensions;    //no. of suspensions in past 5 years
    private int accidents;  //no. of accidents in past 5 years


    public int getAccidents() {
        return accidents;
    }

    public void setAccidents(int accidents) {
        this.accidents = accidents;
    }

    public long getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(long licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSuspensions() {
        return suspensions;
    }

    public void setSuspensions(int suspensions) {
        this.suspensions = suspensions;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
