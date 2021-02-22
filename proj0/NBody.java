// java NBody 157788000.0 25000.0 data/planets.txt
public class NBody {
    public static double readRadius(String FileName) {
        In in = new In(FileName);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String FileName) {
        In in = new In(FileName);
        int N = in.readInt();
        double R = in.readDouble();
        // Delcare Planet array to be returned
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            planets[i] = p;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        // needed to create smooth animations
        StdDraw.enableDoubleBuffering();

        // draw background and set coord scale to fit with radius
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        // draw planets
        for (Planet pl: planets) {
            pl.draw();
        }

        double t = 0;
        // number of planets
        int n = planets.length;
        while (t < T) {
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            // calculate net X and Y forces for each planet
            for (int i = 0; i < n; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            // use update method to update position
            for (int i = 0; i < n; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            // draw background and then planets ontop
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (Planet pl: planets) {
                pl.draw();
            }
            StdDraw.show();
            StdDraw.pause(8);
            t += dt;
        }
        // prints out the final state of the universe
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
