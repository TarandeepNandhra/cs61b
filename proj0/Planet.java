public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String imgs) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = imgs;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    // will be invoked by a planet: samh.calcDistance(rocinante);
    public double calcDistance(Planet p) {
        double xdist = this.xxPos - p.xxPos;
        double ydist = this.yyPos - p.yyPos;
        return Math.sqrt(xdist * xdist + ydist * ydist);
    }

    // will be invoked by a planet: samh.calcForceExertedBy(rocinante)
    public double calcForceExertedBy(Planet p) {
        double r  = this.calcDistance(p);
        return G * this. mass * p.mass / (r * r);

    }
    // want to calc the force and + or - dep on x and y coords
    public double calcForceExertedByX(Planet p) {
        double xdist = p.xxPos - this.xxPos;
        return this.calcForceExertedBy(p) * xdist / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        double ydist = p.yyPos - this.yyPos;
        return this.calcForceExertedBy(p) * ydist / this.calcDistance(p);
    }
    // Need to avoid including the planet itself in calculations.
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double F = 0;
        for (Planet p : allPlanets) {
            if (!this.equals(p)) {
                F += this.calcForceExertedByX(p);
            }
        }
        return F;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double F = 0;
        for (Planet p : allPlanets) {
            if (!this.equals(p)) {
                F += this.calcForceExertedByY(p);
            }
        }
        return F;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
    }
}
