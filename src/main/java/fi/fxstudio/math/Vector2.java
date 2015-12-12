package fi.fxstudio.math;

import static fi.fxstudio.math.Constants.*;

/**
 * Created by fxstudio on 9.12.2015.
 */
public class Vector2 {
    private Double x;
    private Double y;
    private Double r;
    private Double a;

    /**
     * Creates unit vector (1.0; 0.0)
     */
    public Vector2() {
        x = 1.0;
        y = 0.0;

        calculateRA();
    }

    /**
     * Returns a vector from cartesian coordinates x & y
     *
     * @param x
     * @param y
     * @return
     */
    public static Vector2 ofXY(double x, double y) {
        Vector2 v = new Vector2();
        v.x = x;
        v.y = y;
        v.calculateRA();

        return v;
    }

    /**
     * Returns a vector from polar coordinates radius r & angle a radians
     *
     * @param r
     * @param a
     * @return
     */
    public static Vector2 ofRA(double r, double a) {
        Vector2 v = new Vector2();
        v.r = r;
        v.a = a;
        v.normalizeA();
        v.calculateXY();

        return v;
    }

    /**
     * Modify internal X and Y according to polar values
     */
    private void calculateXY() {
        if (r == 0.0 && a == 0.0) {
            x = 0.0;
            y = 0.0;
            return;
        }

        x = Math.cos(a) * r;
        y = Math.sin(a) * r;
    }

    /**
     * Modify internal radius R and angle A according to cartesian values
     */
    private void calculateRA() {
        r = Math.sqrt(x * x + y * y);

        if (r == 0.0) {
            a = 0.0;
            return;
        }

        if (x == 0.0) {
            if (y >= 0.0) {
                a = HALF_PI;
            } else {
                a = THREE_QUARTERS_TWO_PI;
            }
        } else {
            a = Math.atan2(y, x);
        }

        normalizeA();
    }

    /**
     * Normalizes angle a between 0.0 and TWO_PI
     */
    private void normalizeA() {
        while (a > TWO_PI) {
            a -= TWO_PI;
        }

        while (a < 0.0) {
            a += TWO_PI;
        }
    }

    /**********************************/
    /**********************************/
    /**********************************/
    /*** getters & setters - begins ***/
    /**********************************/
    public Double getX() {
        return x;
    }

    public Vector2 setX(Double x) {
        Vector2 v = Vector2.ofXY(x, this.y);

        return v;
    }

    public Double getY() {
        return y;
    }

    public Vector2 setY(Double y) {
        Vector2 v = Vector2.ofXY(this.x, y);

        return v;
    }

    public Double getR() {
        return r;
    }

    public Vector2 setR(Double r) {
        Vector2 v = Vector2.ofRA(r, this.a);

        return v;
    }

    public Double getA() {
        return a;
    }

    public Vector2 setA(Double a) {
        Vector2 v = Vector2.ofRA(this.r, a);

        return v;
    }

    /**********************************/
    /*** getters & setters - ends *****/
    /**********************************/

    /**
     * Vectors are treated as complex numbers; raises current vector to power <i>exponent</i>.
     * <br> http://www.milefoot.com/math/complex/exponentofi.htm
     * <br>
     * @param exponent
     * @return
     */
    public Vector2 complexPower(Vector2 exponent){
        Double r=this.r;
        Double fi=this.a;
        Double c=exponent.x;
        Double d=exponent.y;


        // Some intermediate values
        Double first = Math.pow(r, c) * Math.pow(Math.E, -1.0*d*fi);
        Double second = Math.cos(d * Math.log(r)+c*fi);
        Double third = Math.sin(d * Math.log(r)+c*fi);

        // Result is:
        // first * ( second + i * third ) = f * ( s + i * t )
        // = fs+fit = Re; fs, Im; ft

        Double re = first * second;
        Double im = first * third;

        Vector2 result = Vector2.ofXY(re, im);

        return result;
    }

    /**
     * Returns complex-conjugate-vector of current vector, i.e. x-compnent remains same but y is negated.
     * <br>https://en.wikipedia.org/wiki/Complex_conjugate
     * @return
     */
    public Vector2 complexConjugate(){
        Vector2 v = Vector2.ofXY(x, -1.0*y);

        return v;
    }

    /**
     * Returns dot product
     * @param v
     * @return
     */
    public Double dotProduct(Vector2 v){
        Double value = x*v.x + y*v.y;

        return value;
    }

    /**
     * Rotates vector +180degrees or PI or negates both x and y.
     * @return
     */
    public Vector2 negate(){
        Vector2 v = Vector2.ofXY(-1.0*x, -1.0*y);

        return v;
    }

    /**
     * Normalizes radius (=length) to 1.0
     *
     * @return
     */
    public Vector2 normalize() {
        Vector2 v = setR(1.0);

        return v;
    }

    /**
     * Concatenates vectors
     *
     * @param v
     * @return
     */
    public Vector2 add(Vector2 v) {
        Vector2 value = Vector2.ofXY(this.x + v.x, this.y + v.y);

        return value;
    }

    public Vector2 subtract(Vector2 v) {
        Vector2 value = this.add(v.negate());

        return value;
    }

    /**
     * Rotate vector by a radians
     *
     * @param a
     * @return
     */
    public Vector2 rotate(Double a) {
        Vector2 v = Vector2.ofRA(this.r, this.a + a);

        return v;
    }

    /**
     * Scales (=multiplies) the radius (=length) by scalar value
     *
     * @param scalar
     * @return
     */
    public Vector2 multiply(Double scalar) {
        Vector2 v = Vector2.ofRA(this.r * scalar, this.a);

        return v;
    }

    public Vector2 divide(Double scalar) {
        if(scalar==0){
            return Vector2.ofXY(0.0, 0.0);
        }

        Vector2 v = Vector2.ofRA(this.r / scalar, this.a);

        return v;
    }

    /**
     * Scales (=multiplies) by vector ( i.e. complex number * complex number )
     *
     * @param vector
     * @return
     */
    public Vector2 multiply(Vector2 vector) {
        Vector2 v = Vector2.ofRA(this.r * vector.r, this.a + vector.a);

        return v;
    }

    public Vector2 divide(Vector2 vector) {
        if(vector.a==0){
            return Vector2.ofXY(0.0, 0.0);
        }
        Vector2 v = Vector2.ofRA(this.r / vector.r, this.a - vector.a);

        return v;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("[Vector2:{");

        sb.append("x:").append(x).append(';');
        sb.append("y:").append(y).append(';');
        sb.append("r:").append(r).append(';');
        sb.append("a:").append(a).append(';');

        sb.append("aDegrees:").append(DEGREES_PER_RADIAN * a).append(';');
        if(a!=0.0){
            sb.append("pi/a:").append(Math.PI / a).append(';');
        } else {
            sb.append("pi/a:0;");
        }

        sb.append("}]");

        return sb.toString();
    }

}
