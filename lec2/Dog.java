public class Dog {

    // property of Dog class, instance variable
    public int weightInPounds;

    // Constructor for dogs, determines how to instantiate the class
    public Dog (int w) {
        weightInPounds = w;
    }

    // Non-static method or instance method,
    // non-static as invoked by an instance of the class.
    // Can't access instance variables from a static context.
    public void makeNoise() {
        if(weightInPounds < 10) {
            System.out.println("yip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark.");
        } else {
            System.out.println("wooooooof!");
        }

    }

}
