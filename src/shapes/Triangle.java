package shapes;

import utils.Colors;
import utils.ShapeNames;
import utils.TrianglePropertiesCalculations;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends GeometryObject implements TrianglePropertiesCalculations{

    private double mSideA;
    private double mSideB;
    private double mSideC;

    // A list of available side(s) of the created shape object
    private List<Double> sidesOfTheShape = new ArrayList<>();

    private ShapeNames mName;

    private double mBase;
    private double mPerimeter;

    /** Create Triangle, derived from GeometryObject
     *
     * @param mSideA First side of a triangle
     * @param mSideB Second side of a triangle
     * @param mSideC Third side of a triangle
     * @param color Color of a triangle
     */
    Triangle(double mSideA, double mSideB, double mSideC, Colors color) {
        this.mColor = color;
        this.mSideA = mSideA;
        this.mSideB = mSideB;
        this.mSideC = mSideC;
        this.mName = ShapeNames.TRIANGE;

        this.sidesOfTheShape.add(mSideA);
        this.sidesOfTheShape.add(mSideB);
        this.sidesOfTheShape.add(mSideC);

        identifyBase();

        areTheNumbersRight();
        makeCalculations();
    }

    @Override
    public void calculatePerimeter() {
        mPerimeter = mSideA + mSideB + mSideC;
    }

    @Override
    public void calculateArea() {
        double halfPerimeter = (mSideA + mSideB + mSideC) / 2;
        mArea = Math.sqrt(halfPerimeter * (halfPerimeter - mSideA) *
                                            (halfPerimeter - mSideB) *
                                            (halfPerimeter - mSideC));
    }


    @Override
    public void makeCalculations() {
        calculatePerimeter();
        calculateArea();
    }

    @Override
    public String toString() {
        return String.format("Triangle with following parameters:" + "\n" +
                "Color: " + getmColor() + "\n" +
                "Side A: " + "%.3f" + "\n" +
                "Side B: " + "%.3f" + "\n" +
                "Side C: " + "%.3f" + "\n" +
                "Calculated Perimeter = " + "%.3f" + "\n" +
                "Calculated Area = " + "%.3f" + "\n" +
                "Triangle's Base: " + "%.3f",
                (float)getmSideA(), (float)getmSideB(), (float)getmSideC(),
                (float)getmPerimeter(), (float)getmArea(), (float)getmBase());
    }

    /** Checks, if the numbers are ok, allowing to proceed with creation of desirable object
     *
     */
    private void areTheNumbersRight(){

        if(mSideA + mSideB <= mSideC){
            throw new IllegalArgumentException();
        }

        if(mSideA + mSideC <= mSideB){
            throw new IllegalArgumentException();
        }

        if(mSideC + mSideB <= mSideA){
            throw new IllegalArgumentException();
        }

        if(mSideA <= 0){
            throw new IllegalArgumentException();
        }

        if(mSideB <= 0){
            throw new IllegalArgumentException();
        }

        if(mSideC <= 0){
            throw new IllegalArgumentException();
        }

    }

    private void identifyBase(){
        if(mSideA > mSideB && mSideA > mSideC){
            mBase = mSideA;
        } else {
            if(mSideB > mSideA && mSideB > mSideC){
                mBase = mSideB;
            }else {
                mBase = mSideC;
            }
        }
    }

    protected double getmSideA() {
        return mSideA;
    }

    protected void setmSideA(double mSideA) {
        this.mSideA = mSideA;
    }

    protected double getmSideB() {
        return mSideB;
    }

    protected void setmSideB(double mSideB) {
        this.mSideB = mSideB;
    }

    protected double getmSideC() {
        return mSideC;
    }

    protected void setmSideC(double mSideC) {
        this.mSideC = mSideC;
    }

    protected double getmPerimeter() {
        return mPerimeter;
    }

    protected double getmBase() {
        return mBase;
    }

    protected void setmBase(double mBase) {
        this.mBase = mBase;
    }

    protected void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
    }

    public ShapeNames getmName() {
        return mName;
    }

    protected void setmName(ShapeNames mName) {
        this.mName = mName;
    }

    @Override
    public List<Double> getSidesOfTheShape() {
        return sidesOfTheShape;
    }

    @Override
    protected void setSidesOfTheShape(List<Double> sidesOfTheShape) {
        this.sidesOfTheShape = sidesOfTheShape;
    }
}
