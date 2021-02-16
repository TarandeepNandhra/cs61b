public class NBody {

    public static double readRadius(String s) {

        In in = new In(s);
        int number_of_planets = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String s) {

        In in = new In(s);
        // size of Planet[]
        int number_of_planets = in.readInt();
        // don't need the radius
        in.readDouble();
        // Delcare Planet array to be returned
        Planet[] planets = new Planet[number_of_planets];

        for (int i = 0; i < number_of_planets; i++) {

            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String imgs = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, imgs);
        }

        return planets;

    }

}
