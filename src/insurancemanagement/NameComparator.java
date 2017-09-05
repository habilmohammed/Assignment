/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package insurancemanagement;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 *
 * @author Dale K James
 */
public class NameComparator implements Comparator{
    

    PolicyProvider policyProvider = new PolicyProvider();
    @Override
    public int compare(Object o1, Object o2 ) {
        Entry<Long,Policy> e1 = (Entry<Long,Policy>) o1;
        Entry<Long,Policy> e2= (Entry<Long,Policy>) o2;
        long userId1= e1.getValue().getUserId();
        long userId2= e2.getValue().getUserId();
        PolicyHolder ph1= policyProvider.getPolicyHolder(1);
        PolicyHolder ph2 = policyProvider.getPolicyHolder(2);
        return ph1.getName().compareTo(ph2.getName());
    }

   
      
}
