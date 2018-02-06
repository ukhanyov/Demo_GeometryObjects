package shapes;

import utils.TrianglePropertiesCalculations;

public class Triangle extends GeometryObject implements TrianglePropertiesCalculations{

    private double mSideA;
    private double mSideB;
    private double mSideC;

    private double mBase;

    private double mPerimeter;


    public Triangle(double mSideA, double mSideB, double mSideC, String color) {
        this.mColor = color;
        this.mSideA = mSideA;
        this.mSideB = mSideB;
        this.mSideC = mSideC;

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
        return "Triangle with following parameters:" + "\n" +
                "Color: " + getmColor() + "\n" +
                "Side A: " + getmSideA() + "; Side B: " + getmSideB() +
                "; Side C: " + getmSideC() + "\n" +
                "Calculated Perimeter = " + getmPerimeter() + "\n" +
                "Calculated Area = " + getmArea() + "\n" +
                "Triangle's Base: " + getmBase();
    }

    public void areTheNumbersRight(){

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

    public double getmSideA() {
        return mSideA;
    }

    protected void setmSideA(double mSideA) {
        this.mSideA = mSideA;
    }

    public double getmSideB() {
        return mSideB;
    }

    protected void setmSideB(double mSideB) {
        this.mSideB = mSideB;
    }

    public double getmSideC() {
        return mSideC;
    }

    protected void setmSideC(double mSideC) {
        this.mSideC = mSideC;
    }

    public double getmPerimeter() {
        return mPerimeter;
    }

    public double getmBase() {
        return mBase;
    }

    protected void setmBase(double mBase) {
        this.mBase = mBase;
    }

    protected void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
    }

}
