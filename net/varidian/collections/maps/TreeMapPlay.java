// Like a HashMap with Key-Value Pairs but sorts the keys in ascending order.
// How does it know how to sort the keys in logical order?
package net.varidian.collections.maps;

import java.util.TreeMap;

public class TreeMapPlay {
    public static void main(String[] args) {
    // maps
    // happy paths

        // create a TreeMap
        TreeMap map2 = new TreeMap();
        map2.put(2, "JJ");
        map2.put(5, "KK");
        map2.put(1, "LL");
        map2.put(7, "MM");
        map2.put(8, "MM1");

        // prints out the TreeMap
        System.out.println(map2);

        // prints out the value of the key
        System.out.println(map2.get(7));

        // removes the value of the key
        map2.remove(1);
        System.out.println(map2);

        // tells you if the key exists
        System.out.println(map2.containsKey(2));

        // replaces the existing key with new data
        map2.replace(8, "MM3");
        System.out.println(map2);

    // nasty paths

        // removing a null gives you a null pointer exception
        try {
            map2.remove(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // trying to put in a string as a key when you have it set to an int, casting error
        try {
            map2.put("3", "TT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // getting a null gives you a null pointer exception
        try {
            map2.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // replacing a key that doesn't exist doesn't change anything
        try {
            map2.replace(50, "Test");
            System.out.println(map2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
