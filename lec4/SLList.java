/** Less bare version of IntList */
public class SLList {
    // nested class (subordinate class - only used by SLList)
    // static because the class "never looks outwards" - saves memory
    private static class IntNode {
        public int item;
        public IntNode next;

        public  IntNode(int i, IntNode n) {
            item = i;
            next = n;

        }
    }

    // first can only be used in the SLList class
    // can be used as part of an abstraction barrier, hides implementation.
    private IntNode first;
    private int size;

    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;

    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size++;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode p = first;
        size++;
        while( p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }


    /** Returns the size of the list that starts at IntNode p. */
    // helper method for SLList size as SLList is not inheritly recursive.
    // private static int size(IntNode p) {
    //     if (p.next == null) {
    //         return 1;
    //     }
    //     return 1 + size(p.next);
    // }

    /** Returns the size of the list that starts at IntNode p. */
    public int size() {
        return size;
    }


    public static void main(String[] args) {
        // List of one integer, without specifying null
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        L.addLast(20);
        System.out.println(L.size());;
    }
}
