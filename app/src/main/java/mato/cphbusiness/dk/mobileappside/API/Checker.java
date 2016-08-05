package mato.cphbusiness.dk.mobileappside.API;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Mato on 05.08.16.
 */
public class Checker {


    private void compareLists(ArrayList<String> current, ArrayList<String> old){

        Collection<String> original = new ArrayList(old);
        Collection<String> updated = new ArrayList(current);


        List<String> toDelete = new ArrayList<String>(original);
        List<String> toDownload = new ArrayList<String>(updated);


        toDelete.removeAll(updated);
        toDownload.removeAll(original);


        System.out.println( toDelete );                                 //what should be deleted
        System.out.println( toDownload );                               //what should be downloaded



    }

}
