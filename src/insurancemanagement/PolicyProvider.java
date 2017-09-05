/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancemanagement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Dale K James
 */
public class PolicyProvider {
    private HashMap<Long,Policy> policies= new HashMap();
    private HashMap<Long,PolicyHolder> users = new HashMap();
    

    public void setPolicyDetails(Policy policy,int insuranceType){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Coverage Amount:  ");
        policy.setCoverageAmount(scanner.nextDouble());
        System.out.print("Enter time period:  ");
        policy.setTimePeriod(scanner.nextInt());
        policy.setInsuranceType(insuranceType);
    }
    
    public void setHomeInsurance(HomeInsurance homeInsurance){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter address of the property:    ");
        homeInsurance.setAddress(scanner.nextLine());
        System.out.print("Enter area in square feet:     ");
        homeInsurance.setArea(scanner.nextDouble());
        System.out.print("Enter year in which property was built:    ");
        homeInsurance.setYearBuilt(scanner.nextInt());
    }
    
    public void setVehicleInsurance(VehicleInsurance vehicleInsurance){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter vehicle model:");
        vehicleInsurance.setModel(scanner.next());
        System.out.print("Enter year in which built:");
        vehicleInsurance.setYear(scanner.nextInt());
        System.out.print("Enter license number:");
        vehicleInsurance.setLicenseNo(scanner.nextLong());
        System.out.print("Enter number of suspensions:");
        vehicleInsurance.setSuspensions(scanner.nextInt());
        System.out.print("Enter number of accidents:");
        vehicleInsurance.setAccidents(scanner.nextInt());
    }
    
    public void setLifeInsurance(LifeInsurance lifeInsurance){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter height:");
        lifeInsurance.setHeight(scanner.nextFloat());
        System.out.println("Enter weight:");
        lifeInsurance.setWeight(scanner.nextFloat());
    }
    
    public void setPolicyHolder(PolicyHolder policyHolder){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Name:");
        policyHolder.setName(scanner.next());
        System.out.print("Address:");
        policyHolder.setAddress(scanner.next()); 
        System.out.print("Phone Number:");
        policyHolder.setPhoneNo(scanner.nextLong());
        System.out.print("Email:");
        policyHolder.setEmail(scanner.next());
        System.out.print("Date of Birth:");
        policyHolder.setDob(scanner.next());
        System.out.print("Annual Income:");
        policyHolder.setAnnualIncome(scanner.nextDouble());
    }
    
    public Policy addPolicy(int insuranceType){
        Policy policy = null;
        switch(insuranceType){
            case 1: 
                policy = new HomeInsurance();
                setPolicyDetails(policy,insuranceType);
                setHomeInsurance((HomeInsurance)policy);               
                break;
            case 2:    
                policy = new VehicleInsurance();
                setPolicyDetails(policy,insuranceType);
                setVehicleInsurance((VehicleInsurance)policy);
                break;
            case 3:
                policy = new LifeInsurance();
                setPolicyDetails(policy,insuranceType);
                setLifeInsurance((LifeInsurance)policy); 
                break;
            default:
                System.out.println("Wrong Choice!");
        }
        policies.put(policy.getPolicyNumber(), policy);
        return policy;
    }
    
    public void addNewUser(Policy p){
        PolicyHolder policyHolder = new PolicyHolder();
        setPolicyHolder(policyHolder);
        users.put(policyHolder.getUserId(), policyHolder);
        policyHolder.policyNumbers.add(p.getPolicyNumber());
        p.setUserId(policyHolder.getUserId());
        Set set= users.entrySet();
        List list = new LinkedList(set);
        for(Iterator i=list.iterator();i.hasNext();){
            Map.Entry<Long,PolicyHolder> me = (Map.Entry<Long,PolicyHolder>) i.next();
            System.out.println(me.getKey());
        }
    }
    
    public void addExistingUser(long userId,Policy p){
        PolicyHolder policyHolder= getPolicyHolder(userId);
        policyHolder.policyNumbers.add(p.getPolicyNumber());
        
        p.setUserId(userId);
    }
    
    public Policy getPolicy(long policyNumber){
        return policies.get(new Long(policyNumber));
    }
    
    public PolicyHolder getPolicyHolder(long userId){
        Set set= users.entrySet();
        List list = new LinkedList(set);
        for(Iterator i=list.iterator();i.hasNext();){
            Map.Entry<Long,PolicyHolder> me = (Map.Entry<Long,PolicyHolder>) i.next();
            System.out.println(me.getKey());
        }
        try{
            if(users.containsKey(userId))
                return users.get(new Long(userId));
            else
                System.out.println("userId not found");
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
        finally{
            return null;
        }
        
    } 
    
    public void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter insurance type:\n"
                + "1.Home Insurance\n"
                + "2.Vehicle Insurance\n"
                + "3.Life Insurance");
        int insuranceType= scanner.nextInt();
        Policy p = addPolicy(insuranceType);
        System.out.println("Do you want to link with an existing user account?"
                + "(Y/N)");
        String choice = scanner.next();
        if(choice.equals("Y")){
            System.out.println("Enter user id   :");
            long userId = scanner.nextLong();
            addExistingUser(userId, p);
        }
        else if(choice.equals("N")){
            addNewUser(p);
        }    
        else
            System.out.println("Wrong Choice!");
    }
    
    public void search(long policyNumber){
        Policy p = policies.get(policyNumber);
        displayPolicy(p);
        PolicyHolder ph = users.get(p.getUserId());
        if(p instanceof HomeInsurance)
            displayHomeInsurance((HomeInsurance)p);
        else if(p instanceof VehicleInsurance)
            displayVehicleInsurance((VehicleInsurance)p);
        else if(p instanceof LifeInsurance)
            displayLifeInsurance((LifeInsurance)p);
        displayPolicyHolder(ph);
    }
    
    
    public void displayPolicy(Policy p){
        System.out.println("Coverage Amount: "+p.getCoverageAmount());
        System.out.println("Time Period: "+ p.getTimePeriod());
    }
    
    public void displayHomeInsurance(HomeInsurance h){
        System.out.println("Details of House:");
        System.out.println("address: "+h.getAddress());
        System.out.println("area: "+h.getArea());
        System.out.println("Year of construction: "+h.getYearBuilt());
    }
    
    public void displayVehicleInsurance(VehicleInsurance v){
        System.out.println("Model :" + v.getModel() );
        System.out.println("Year build :" + v.getYear() );
        System.out.println("License number : " + v.getLicenseNo());
        System.out.println("suspensions : " + v.getSuspensions());
        System.out.println("accidents : " + v.getAccidents());
    }
    
    public void displayLifeInsurance(LifeInsurance l){
        System.out.println("Weight: "+l.getWeight());
        System.out.println("Height: "+l.getHeight());
    }
    
    public void displayPolicyHolder(PolicyHolder ph){
        System.out.println("Name: "+ph.getName());
        System.out.println("Address: "+ph.getAddress());
        System.out.println("Phone Number: "+ph.getPhoneNo());
        System.out.println("E-Mail: "+ph.getEmail());
        System.out.println("Date Of Birth: "+ph.getDob());
        System.out.println("Annual Income: "+ph.getAnnualIncome());
    }
    
    public void sortByName(){
        Set set= policies.entrySet();
        List list = new LinkedList(set);
        Collections.sort(list,new NameComparator());
        
        for(Iterator i = list.iterator();i.hasNext();){
            Map.Entry me= (Map.Entry) i.next();
            Policy p =(Policy) me.getValue();
            PolicyHolder ph = getPolicyHolder(p.getUserId());
            System.out.println(me.getKey()+"\t"+ph.getName());           
        }         
    }
    
    public void sortByPolicyNo(){
        Set set= policies.entrySet();
        List list = new LinkedList(set);
        Collections.sort(list,new PnoComparator());
        
        for(Iterator i = list.iterator();i.hasNext();){
            Map.Entry me= (Map.Entry) i.next();
            Policy p =(Policy) me.getValue();
            PolicyHolder ph = getPolicyHolder(p.getUserId());
            System.out.println(me.getKey()+"\t"+ph.getName());           
        }         
    }
    
    public void display(){
        Set s= policies.entrySet();
        for(Iterator i= s.iterator();i.hasNext();){
            Map.Entry me= (Map.Entry)i.next();
            Policy p= (Policy) me.getValue();
            displayPolicy(p);
            if(p instanceof HomeInsurance)
                displayHomeInsurance((HomeInsurance)p);
            else if(p instanceof VehicleInsurance)
                displayVehicleInsurance((VehicleInsurance)p);
            else if(p instanceof LifeInsurance)
                displayLifeInsurance((LifeInsurance)p);
            PolicyHolder ph = users.get(p.getUserId());
            displayPolicyHolder(ph);
        }
    }
}
