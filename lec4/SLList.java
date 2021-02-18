/** Less bare version of IntList */

public class SLList {
    public IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);

    }

    public static void main(String[] args) {
        // List of one integer, without specifying null
        SLList L = new SLList(10);
    }


}
