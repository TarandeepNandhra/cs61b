public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    // L = new IntList(10, L);
    // rest = r means that the rest of the new list instance points to L so it's not lost.

    /** Return the size of the list using... recusion! */
    public int size() {
        // keep going through list until rest is null
        if (this.rest == null) {
            return 1;
        }
        else {
            return 1 + this.rest.size();
        }
    }
    
    /** Return the size of the list using no recusion! */
    public int iterativeSize() {
        int count = 1;
        IntList L = this;
        while (L.rest != null) {
            count++;
            L = L.rest;
        }
        return count;
    }

    // can't do this = this.rest as this is a "final" variable

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.iterativeSize());
    }

}
