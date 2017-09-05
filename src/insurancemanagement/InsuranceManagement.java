/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancemanagement;

import java.util.Scanner;

/**
 *
 * @author Dale K James
 */
public class InsuranceManagement {
    PolicyProvider policyProvider = new PolicyProvider();
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        
        InsuranceManagement insuranceManager = new InsuranceManagement();
        int choice;
        System.out.println("-------INSURANCE MANAGEMENT SYSTEM-------");
        do{
            System.out.print("\n\n1.ADD\n"
                    + "2.SEARCH\n"
                    + "3.SORT\n"
                    + "4.DISPLAY\n"
                    + "5.EXIT\n"
                    + "Enter your choice : ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if (choice==1){
                insuranceManager.policyProvider.add();
            }
            else if (choice==2){
                System.out.println("Enter Policy Number: ");
                insuranceManager.policyProvider.search(scanner.nextLong());
            }
            else if(choice==3){
                System.out.println("1.Sort by Name\n"
                        + "2.Sort By Policy Number");
                choice = scanner.nextInt();
                if(choice==1)
                    insuranceManager.policyProvider.sortByName();
                else if(choice==2)
                    insuranceManager.policyProvider.sortByPolicyNo();
                else
                    System.out.println("Wrong Choice");
            }
            else if(choice==4){
                insuranceManager.policyProvider.display();
            }
            else if (choice!=5)
                System.out.println("Please enter a valid choice!!");
        }while(choice!=5);

    }
}
