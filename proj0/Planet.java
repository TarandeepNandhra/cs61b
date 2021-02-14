public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String imgs) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = imgs;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    // will be invoked by a planet: samh.calcDistance(rocinante);
    public double calcDistance(Planet p) {
        double xdist = this.xxPos - p.xxPos;
        double ydist = this.yyPos - p.yyPos;
        return Math.sqrt(xdist * xdist + ydist * ydist);

    }


}
