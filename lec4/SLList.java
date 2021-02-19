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

    /* The first item, if it exists, is at sentinel.next */
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;

    }

    /** Creates an empty SLList. */
    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        size++;

        IntNode p = sentinel;

        while( p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Returns the size of the list that starts at IntNode p. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        // List of one integer, without specifying null
        SLList L = new SLList();
        L.addLast(5);
    }
}
