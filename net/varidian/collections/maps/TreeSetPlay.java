// Like an ArrayList but no duplicate elements can exist
// check
package net.varidian.collections.maps;

import java.util.TreeSet;

public class TreeSetPlay {
    public static void main(String[] args){
    // collections
    // happy paths

        // build a TreeSet, and add elements to it
        TreeSet treeSet = new TreeSet();
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        treeSet.add("4");
        System.out.println(treeSet);

        // print out the first element in the TreeSet
        System.out.println(treeSet.first());

        // see if the element exists in the TreeSet
        boolean test = treeSet.contains("4");
        System.out.println(test);

        // see the size of the TreeSet
        System.out.println(treeSet.size());

        // removes an element from the TreeSet
        treeSet.remove("2");
        System.out.println(treeSet);


    //nasty paths
        // try to add a int to a TreeSet of strings
        try {
            treeSet.add(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // try to add a null to a TreeSet
        try {
            treeSet.add(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // duplicate value - no error, skips or replaces it?
        try {
            treeSet.add("1");
            System.out.println(treeSet);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
