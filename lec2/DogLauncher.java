/**
The DogLauncher class will test drive the Dog class
Java goes to Dog.java and finds the makeNoise method.
*/

public class DogLauncher {

    public static void main(String[] args) {

        Dog d = new Dog(15);

        Dog d2 = new Dog(100);

        //Dog bigger = Dog.maxDog(d, d2);

        Dog bigger = d.maxDog(d2);

        bigger.makeNoise();

        // System.out.println(d.binomen);
        // better practice to use the class name instead
        System.out.println(Dog.binomen);

        //d.makeNoise()
    }

}
