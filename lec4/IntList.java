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

    /** Return the ith item in this IntList */
    public int get(int i) {

        if (i == 0) {
            return this.first;
        }
        return this.rest.get(i - 1);
    }

    // don't need the this, it's implicit.

    /** Return an IntList identical to L, but with all values incremented by x. */
    // public static IntList incrList(IntList L, int x) {
    //     IntList Q;
    //     Q.first = L.first + x;
    //     while (L.rest != null) {
    //         L = L.rest;
    //
    //     }
    //
    // }

    /** Return an IntList identical to L, but with all values incremented by x. */
    public static IntList dincrList(IntList L, int x) {
        IntList M = L;
        M.first += x;
        while (M.rest != null) {
            M = M.rest;
            M.first += x;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.get(1));
        IntList Q = dincrList(L, 5);
    }

}
