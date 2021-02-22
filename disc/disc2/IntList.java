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

    // Disc 2

    // Implement square and squareMutative which are static methods that both take in
    // an IntList L and return an IntList with its integer values all squared.
    // square does this non-mutatively with recursion by creating new IntLists
    // squareMutative uses a recursive approach to change the instance variables of the input IntList L.

    public static IntList square(IntList L) {
        if (L == null) {
            return L;
        }
        IntList rest = square(L.rest);
        IntList M = new IntList(L.first * L.first, rest);
        return M;
    }

    public static IntList squareMutative(IntList L) {
        L.first = L.first * L.first;
        if (L.rest == null) {
            return L;
        }
        return squareMutative(L.rest);
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        IntList M = square(L);
        squareMutative(L);
    }

}
