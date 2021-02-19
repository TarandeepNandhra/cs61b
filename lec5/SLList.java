/** Less bare version of IntList */
public class SLList<LochNess> {
    // nested class (subordinate class - only used by SLList)
    // static because the class "never looks outwards" - saves memory
    private class StuffNode {
        public LochNess item;
        public StuffNode next;

        public  StuffNode(LochNess i, StuffNode n) {
            item = i;
            next = n;

        }
    }

    /* The first item, if it exists, is at sentinel.next */
    private StuffNode sentinel;
    private int size;

    public SLList() {
        sentinel = new StuffNode(0, null);
        size = 0;

    }

    /** Creates an empty SLList. */
    public SLList(LochNess x) {
        sentinel = new StuffNode(0, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(LochNess x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size++;
    }

    /** Returns the first item in the list. */
    public LochNess getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(LochNess x) {
        size++;

        StuffNode p = sentinel;

        while( p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
    }

    /** Returns the size of the list that starts at StuffNode p. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        // List of one integer, without specifying null
        SLList L = new SLList();
        L.addLast(5);
    }
}
