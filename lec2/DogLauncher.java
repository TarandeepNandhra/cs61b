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
    }

}
