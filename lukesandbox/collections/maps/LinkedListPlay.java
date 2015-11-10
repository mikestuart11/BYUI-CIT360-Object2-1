// First In, First Out (FIFO)
package lukesandbox.collections.maps;

import java.util.LinkedList;

public class LinkedListPlay {
    public static void main(String[] args) {

    // collections
    // happy paths

        // pushes elements to the LinkedList
        LinkedList lnkLst = new LinkedList();
        lnkLst.push("Kayla");
        lnkLst.push("Brad");
        lnkLst.push("Henry");
        lnkLst.push("Liesel");
        System.out.println(lnkLst);

        // pops out the reverse order of the LinkedList
        System.out.println(lnkLst.pop());
        System.out.println(lnkLst.pop());

        // removes an element from the LinkedList
        lnkLst.remove(1);
        System.out.println(lnkLst);

        // pushes element into a LinkedList
        lnkLst.push(5);
        System.out.println(lnkLst);

        // puts an element last no matter what in a LinkedList
        lnkLst.addLast("Last?");
        System.out.println(lnkLst);

        // gets the element in the LinkedList at index 1
        System.out.println(lnkLst.get(1));

    // nasty paths

        // asking for an element that doesn't exist.
        try {
            lnkLst.get(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // trying a negative index
        try {
            lnkLst.get(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
