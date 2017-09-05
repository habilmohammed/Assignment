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
public class PnoComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2 ) {
        Entry<Long,PolicyHolder> e1 = (Entry<Long,PolicyHolder>) o1;
        Entry<Long,PolicyHolder> e2= (Entry<Long,PolicyHolder>) o2;
        if(e1.getKey()>e2.getKey())
            return 1;
        else if(e2.getKey()>e1.getKey())
            return -1;
        else
            return 0;
    }
}
