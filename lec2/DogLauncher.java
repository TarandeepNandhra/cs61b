/**
The DogLauncher class will test drive the Dog class
Java goes to Dog.java and finds the makeNoise method.
*/

public class DogLauncher {

    public static void main(String[] args) {
        // create a new dog d
        Dog d = new Dog();
        d.weightInPounds = 51;
        d.makeNoise();
    }

}
