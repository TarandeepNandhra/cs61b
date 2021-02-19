public class SLListLauncher {
    public static void main(String[] args) {
        SLList<Integer> s1 = new SLList<>(5);
        SLList<String> s1 = new SLList<>("hi");

        // When instantiating, the type in <> is substiuted
        // into the <var name> in the class
        // Allow for different types.
        s1.addFirst(10);
    }

}
