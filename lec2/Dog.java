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
    // static method which invokes on the Dog class
    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }
    // non-static method which invokes on an instantiation of Dog
    public Dog maxDog(Dog d2) {
        if (this.weightInPounds > d2.weightInPounds) {
            return this;
        }
        return d2;
    }
}
