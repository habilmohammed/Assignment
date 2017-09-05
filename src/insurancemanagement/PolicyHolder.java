/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancemanagement;

import java.util.ArrayList;

/**
 *
 * @author Dale K James
 */
public class PolicyHolder {
    private static long userCount=0;
    private long userId;
    private String name;
    private String address;
    private long phoneNo;
    private String email;
    private String dob; //date of birth
    private double annualIncome;
    ArrayList<Long> policyNumbers = new ArrayList();

    public PolicyHolder(){
        userCount++;
        this.userId=userCount;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public ArrayList<Long> getPolicyNumbers() {
        return policyNumbers;
    }

    public void setPolicyNumbers(ArrayList<Long> policyNumbers) {
        this.policyNumbers = policyNumbers;
    }

    public static long getUserCount() {
        return userCount;
    }

    public static void setUserCount(long userCount) {
        PolicyHolder.userCount = userCount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    

}
