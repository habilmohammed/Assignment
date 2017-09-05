/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancemanagement;

/**
 *
 * @author Dale K James
 */
public abstract class Policy {
    
    private double coverageAmount;
    private int timePeriod;
    private long userId;
    private int insuranceType;
    private long policyNumber;
    private static long policyCount=0;

    public int getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(int insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Policy() {
        policyCount++;
        this.policyNumber = policyCount;
    }

    
    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public static long getPolicyCount() {
        return policyCount;
    }

    public static void setPolicyCount(long policyCount) {
        Policy.policyCount = policyCount;
    }

    public long getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(long policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
