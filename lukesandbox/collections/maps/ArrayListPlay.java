// An advanced Array that grows and shrinks and is mutable.
// check
package lukesandbox.collections.maps;

import java.util.ArrayList;

public class ArrayListPlay {
    public static void main(String[] args) {

    // collections
    // happy paths
        // build an ArrayList and add things to it.
        ArrayList aryLst = new ArrayList();
        aryLst.add("CIT 225");
        aryLst.add("CIT 325");
        aryLst.add("FDREL 341");
        aryLst.add("CS 124");
        System.out.println(aryLst);

        // add an element to the ArrayList
        aryLst.add(0, "CIT 999");
        System.out.println(aryLst);

        // change an element in the ArrayList
        aryLst.set(1, "CIT 998");
        System.out.println(aryLst);

        // remove an element from an ArrayList
        aryLst.remove(4);
        System.out.println(aryLst);

        // clone an existing an ArrayList to a new one
        ArrayList aryLst2 = (ArrayList) aryLst.clone();
        System.out.println(aryLst2);

        // merge another ArrayList to the very end of an existing ArrayList unless specified
        aryLst.addAll(aryLst2);
        System.out.println(aryLst);

    // bad paths
        // add an element to an ArrayList for a spot that doesn't exist
        try {
            aryLst.add(10, "CIT 333");
            //System.out.println(aryLst);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // remove an element an a ArrayList that doesn't exist
        try {
            aryLst.remove(10);
            //System.out.println(aryLst);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // getting an element that has been removed from an ArrayList
        try {
            aryLst.get(4);
            //System.out.println(aryLst);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // add null? - just puts in null, no error
        try {
            aryLst.add(null);
            System.out.println(aryLst);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // merging an ArrayList somewhere that doesn't exist you get IndexOutOfBounds
        try {
            aryLst.addAll(99, aryLst2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

