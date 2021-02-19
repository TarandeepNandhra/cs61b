/** Less bare version of IntList */
public class SLList {
    private IntNode first;
    // first can only be used in the SLList class
    // can be used as part of an abstraction barrier, hides implementation.

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


    public SLList(int x) {
        first = new IntNode(x, null);

    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return first.item;
    }

    public static void main(String[] args) {
        // List of one integer, without specifying null
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
    }

    // SLList adds an extra layer between code and programmer, compared to IntList






}
