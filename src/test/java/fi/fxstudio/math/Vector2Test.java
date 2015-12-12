package fi.fxstudio.math;

import org.junit.Test;

import static org.junit.Assert.*;
import static fi.fxstudio.math.Constants.*;

/**
 * Created by fxstudio on 9.12.2015.
 */
public class Vector2Test {

    private Double testErrorMargin = 0.000000001;

    @Test
    public void complexExponent_test1(){
        Vector2 v1 = Vector2.ofXY(2.0, 0.0);
        Vector2 v2 = Vector2.ofXY(3.0, 0.0);
        Vector2 vResult = v1.complexPower(v2);
        assertEquals(8.0, vResult.getX(), testErrorMargin);
        assertEquals(0.0, vResult.getY(), testErrorMargin);
    }

    @Test
    public void complexExponent_test2(){
        Vector2 v1 = Vector2.ofXY(Math.E, 0.0);
        Vector2 v2 = Vector2.ofXY(0.0, Math.PI);
        Vector2 vResult = v1.complexPower(v2);
        assertEquals(-1.0, vResult.getX(), testErrorMargin);
        assertEquals(0.0, vResult.getY(), testErrorMargin);
    }

    @Test
    public void complexExponent_test3(){
        Vector2 v1 = Vector2.ofRA(2.0, QUARTER_PI);
        Vector2 v2 = Vector2.ofRA(3.0, QUARTER_PI+EIGTH_PI);
        Vector2 vResult = v1.complexPower(v2);
        assertEquals(0.2513089959221, vResult.getR(), testErrorMargin);
        assertEquals(2.8228300742382, vResult.getA(), testErrorMargin);
    }

    @Test
    public void add() {
        Vector2 v1 = Vector2.ofXY(2.0, 3.0);
        Vector2 v2 = Vector2.ofXY(4.0, 8.0);
        Vector2 vResult = v1.add(v2);
        assertEquals(2.0 + 4.0, vResult.getX(), testErrorMargin);
        assertEquals(3.0 + 8.0, vResult.getY(), testErrorMargin);
    }

    @Test
    public void subtract() {
        Vector2 v1 = Vector2.ofXY(2.0, 3.0);
        Vector2 v2 = Vector2.ofXY(4.0, 8.0);
        Vector2 vResult = v1.subtract(v2);
        assertEquals(-2.0, vResult.getX(), testErrorMargin);
        assertEquals(-5.0, vResult.getY(), testErrorMargin);
    }

    @Test
    public void rotate() {
        Vector2 v = Vector2.ofRA(2.5, RADIANS_IN_35_DEGREES);
        Vector2 v2 = v.rotate(RADIANS_IN_60_DEGREES);
        assertEquals(RADIANS_IN_35_DEGREES + RADIANS_IN_60_DEGREES, v2.getA(), testErrorMargin);
    }

    @Test
    public void scale() {
        Vector2 v = Vector2.ofRA(2.5, RADIANS_IN_35_DEGREES);
        Vector2 v2 = v.multiply(16.5);
        assertEquals(2.5 * 16.5, v2.getR(), testErrorMargin);
    }

    @Test
    public void divide() {
        Vector2 v = Vector2.ofRA(10.0, RADIANS_IN_35_DEGREES);
        Vector2 v2 = v.divide(2.0);
        assertEquals(5.0, v2.getR(), testErrorMargin);
    }

    @Test
    public void multiplyByVector() {
        Vector2 v1 = Vector2.ofXY(2.0, 3.0);
        Vector2 v2 = Vector2.ofXY(4.0, 8.0);
        Vector2 vResult = v1.multiply(v2);
        assertEquals(v1.getR() * v2.getR(), vResult.getR(), testErrorMargin);
        assertEquals(v1.getA() + v2.getA(), vResult.getA(), testErrorMargin);

        // Test normalize
        Vector2 vNormalized = vResult.normalize();
        assertEquals(1.0, vNormalized.getR(), testErrorMargin);
        assertEquals(vResult.getA(), vNormalized.getA(), testErrorMargin);

        // Test setR()
        Vector2 vSetR = vResult.setR(6473.8);
        assertEquals(6473.8, vSetR.getR(), testErrorMargin);
        assertEquals(vResult.getA(), vSetR.getA(), testErrorMargin);
    }

    @Test
    public void divideByVector() {
        Vector2 v1 = Vector2.ofXY(2.0, 3.0);
        Vector2 v2 = Vector2.ofXY(4.0, 8.0);
        Vector2 vResult = v1.divide(v2).multiply(v2);
        assertEquals(v1.getR(), vResult.getR(), testErrorMargin);
        assertEquals(v1.getA(), vResult.getA(), testErrorMargin);
    }

    @Test
    public void setters(){
        Vector2 vXY = Vector2.ofXY(2.0, 3.0);
        //
        Vector2 vSetX = vXY.setX(15.0);
        assertEquals(15.0, vSetX.getX(), testErrorMargin);
        assertEquals(vXY.getY(), vSetX.getY(), testErrorMargin);
        //
        Vector2 vSetY = vXY.setY(903.0);
        assertEquals(vXY.getX(), vSetY.getX(), testErrorMargin);
        assertEquals(903, vSetY.getY(), testErrorMargin);

        Vector2 vRA = Vector2.ofRA(2.0, 3.0);
        //
        Vector2 vSetR = vRA.setR(18.0);
        assertEquals(18.0, vSetR.getR(), testErrorMargin);
        assertEquals(vRA.getA(), vSetR.getA(), testErrorMargin);
        //
        Vector2 vSetA = vRA.setA(1.2345);
        assertEquals(vRA.getR(), vSetA.getR(), testErrorMargin);
        assertEquals(1.2345, vSetA.getA(), testErrorMargin);
    }

    @Test
    public void testXY() {
        Double testAngleDegrees = 0.0;
        Vector2 v = Vector2.ofRA(2.5, RADIANS_PER_DEGREE * testAngleDegrees);
        assertNotNull(v);
        assertEquals(2.5, v.getX(), testErrorMargin);
        assertEquals(0.0, v.getY(), testErrorMargin);

        testAngleDegrees = 90.0;
        v = Vector2.ofRA(2.5, RADIANS_PER_DEGREE * testAngleDegrees);
        assertNotNull(v);
        assertEquals(0.0, v.getX(), testErrorMargin);
        assertEquals(2.5, v.getY(), testErrorMargin);

        testAngleDegrees = 180.0;
        v = Vector2.ofRA(2.5, RADIANS_PER_DEGREE * testAngleDegrees);
        assertNotNull(v);
        assertEquals(-2.5, v.getX(), testErrorMargin);
        assertEquals(0.0, v.getY(), testErrorMargin);

        testAngleDegrees = 270.0;
        v = Vector2.ofRA(2.5, RADIANS_PER_DEGREE * testAngleDegrees);
        assertNotNull(v);
        assertEquals(0.0, v.getX(), testErrorMargin);
        assertEquals(-2.5, v.getY(), testErrorMargin);

        // Angle should be normalized
        testAngleDegrees = 72.0;
        Vector2 vMoreThanOneCircle = Vector2.ofRA(33.0, TWO_PI * 5.0 + RADIANS_PER_DEGREE * testAngleDegrees);
        assertEquals(33.0, vMoreThanOneCircle.getR(), testErrorMargin);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, vMoreThanOneCircle.getA(), testErrorMargin);
        assertEquals(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees) * 33.0, vMoreThanOneCircle.getX(), testErrorMargin);
        assertEquals(Math.sin(RADIANS_PER_DEGREE * testAngleDegrees) * 33.0, vMoreThanOneCircle.getY(), testErrorMargin);

        testAngleDegrees = 96.0;
        vMoreThanOneCircle = Vector2.ofRA(33.0, TWO_PI * 5.0 + RADIANS_PER_DEGREE * testAngleDegrees);
        assertEquals(33.0, vMoreThanOneCircle.getR(), testErrorMargin);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, vMoreThanOneCircle.getA(), testErrorMargin);
        assertEquals(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees) * 33.0, vMoreThanOneCircle.getX(), testErrorMargin);
        assertEquals(Math.sin(RADIANS_PER_DEGREE * testAngleDegrees) * 33.0, vMoreThanOneCircle.getY(), testErrorMargin);

        testAngleDegrees = 201.0;
        vMoreThanOneCircle = Vector2.ofRA(33.0, TWO_PI * 5.0 + RADIANS_PER_DEGREE * testAngleDegrees);
        assertEquals(33.0, vMoreThanOneCircle.getR(), testErrorMargin);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, vMoreThanOneCircle.getA(), testErrorMargin);
        assertEquals(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees) * 33.0, vMoreThanOneCircle.getX(), testErrorMargin);
        assertEquals(Math.sin(RADIANS_PER_DEGREE * testAngleDegrees) * 33.0, vMoreThanOneCircle.getY(), testErrorMargin);

        testAngleDegrees = 273.0;
        vMoreThanOneCircle = Vector2.ofRA(33.0, TWO_PI * 5.0 + RADIANS_PER_DEGREE * testAngleDegrees);
        assertEquals(33.0, vMoreThanOneCircle.getR(), testErrorMargin);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, vMoreThanOneCircle.getA(), testErrorMargin);
        assertEquals(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees) * 33.0, vMoreThanOneCircle.getX(), testErrorMargin);
        assertEquals(Math.sin(RADIANS_PER_DEGREE * testAngleDegrees) * 33.0, vMoreThanOneCircle.getY(), testErrorMargin);

        // Angle should be normalized
        testAngleDegrees = 39.0;
        Vector2 vLessThanOneCircle = Vector2.ofRA(98.0, TWO_PI * -5.0 - RADIANS_PER_DEGREE * testAngleDegrees);
        assertEquals(98.0, vLessThanOneCircle.getR(), testErrorMargin);
        assertEquals(TWO_PI - RADIANS_PER_DEGREE * testAngleDegrees, vLessThanOneCircle.getA(), testErrorMargin);
        assertEquals(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees) * 98.0, vLessThanOneCircle.getX(), testErrorMargin);
        assertEquals(-Math.sin(RADIANS_PER_DEGREE * testAngleDegrees) * 98.0, vLessThanOneCircle.getY(), testErrorMargin);
    }

    @Test
    public void testRP() {
        Vector2 v = new Vector2();
        Double testAngleDegrees = 0.0;
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);

        v = Vector2.ofXY(2.0, 2.0);
        testAngleDegrees = 45.0;
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);
        assertEquals(Math.sqrt(2.0) * 2.0, v.getR(), testErrorMargin);

        v = Vector2.ofXY(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees), Math.sin(RADIANS_PER_DEGREE * testAngleDegrees));
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);
        assertEquals(1.0, v.getR(), testErrorMargin);

        testAngleDegrees = 109.0;
        v = Vector2.ofXY(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees), Math.sin(RADIANS_PER_DEGREE * testAngleDegrees));
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);
        assertEquals(1.0, v.getR(), testErrorMargin);

        testAngleDegrees = 239.0;
        v = Vector2.ofXY(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees), Math.sin(RADIANS_PER_DEGREE * testAngleDegrees));
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);
        assertEquals(1.0, v.getR(), testErrorMargin);

        testAngleDegrees = 348.0;
        v = Vector2.ofXY(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees), Math.sin(RADIANS_PER_DEGREE * testAngleDegrees));
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);
        assertEquals(1.0, v.getR(), testErrorMargin);

        testAngleDegrees = 0.0;
        v = Vector2.ofXY(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees), Math.sin(RADIANS_PER_DEGREE * testAngleDegrees));
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);
        assertEquals(1.0, v.getR(), testErrorMargin);

        testAngleDegrees = 90.0;
        v = Vector2.ofXY(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees), Math.sin(RADIANS_PER_DEGREE * testAngleDegrees));
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);
        assertEquals(1.0, v.getR(), testErrorMargin);

        testAngleDegrees = 270.0;
        v = Vector2.ofXY(Math.cos(RADIANS_PER_DEGREE * testAngleDegrees), Math.sin(RADIANS_PER_DEGREE * testAngleDegrees));
        assertNotNull(v);
        assertEquals(RADIANS_PER_DEGREE * testAngleDegrees, v.getA(), testErrorMargin);
        assertEquals(1.0, v.getR(), testErrorMargin);

        assertTrue(true);
    }

    @Test
    public void complexConjugate(){
        Vector2 v = Vector2.ofXY(5.0, 3.0);
        Vector2 vConjugate = v.complexConjugate();
        assertNotNull(vConjugate);
        assertEquals(v.getX(), vConjugate.getX(), testErrorMargin);
        assertEquals(-1.0*v.getY(), vConjugate.getY(), testErrorMargin);

        v = Vector2.ofXY(2.0, -63.0);
        vConjugate = v.complexConjugate();
        assertNotNull(vConjugate);
        assertEquals(v.getX(), vConjugate.getX(), testErrorMargin);
        assertEquals(-1.0*v.getY(), vConjugate.getY(), testErrorMargin);
    }

    @Test
    public void negate(){
        Vector2 v = Vector2.ofXY(5.0, 3.0);
        Vector2 vN = v.negate();
        assertNotNull(vN);
        assertEquals(-1.0*v.getX(), vN.getX(), testErrorMargin);
        assertEquals(-1.0*v.getY(), vN.getY(), testErrorMargin);
        assertEquals(v.getR(), vN.getR(), testErrorMargin);
        assertEquals(v.rotate(Math.PI).getA(), vN.getA(), testErrorMargin);

        v = Vector2.ofXY(-18.0, -1773.98);
        vN = v.negate();
        assertNotNull(vN);
        assertEquals(-1.0*v.getX(), vN.getX(), testErrorMargin);
        assertEquals(-1.0*v.getY(), vN.getY(), testErrorMargin);
        assertEquals(v.getR(), vN.getR(), testErrorMargin);
        assertEquals(v.rotate(Math.PI).getA(), vN.getA(), testErrorMargin);
    }

    @Test
    public void dotProduct(){
        Vector2 v1 = Vector2.ofXY(2.0, 3.0);
        Vector2 v2 = Vector2.ofXY(5.0, 6.0);
        // 2.0*5.0 + 3.0*6.0
        Double dp = v1.dotProduct(v2);
        assertEquals(28.0, dp, testErrorMargin);
    }

    @Test
    public void someAbuse(){
        Vector2 zeroXY = Vector2.ofXY(0.0, 0.0);
        assertNotNull(zeroXY);
        assertEquals(0.0, zeroXY.getR(), testErrorMargin);
        assertEquals(0.0, zeroXY.getA(), testErrorMargin);

        Vector2 zeroRA = Vector2.ofRA(0.0, 0.0);
        assertNotNull(zeroRA);
        assertEquals(0.0, zeroRA.getX(), testErrorMargin);
        assertEquals(0.0, zeroRA.getY(), testErrorMargin);
    }
}
