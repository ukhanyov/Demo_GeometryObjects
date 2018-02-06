package shapes;

import utils.TrapezoidPropertiesCalculations;

public class Trapezoid extends GeometryObject implements TrapezoidPropertiesCalculations {

    private double mBigBase;
    private double mSmallBase;
    private double mLeftSide;
    private double mRightSide;

    private double mHeight;

    private double mPerimeter;

    public Trapezoid(double mBigBase, double mSmallBase, double mLeftSide, double mRightSide, String color) {
        this.mColor = color;
        this.mBigBase = mBigBase;
        this.mSmallBase = mSmallBase;
        this.mLeftSide = mLeftSide;
        this.mRightSide = mRightSide;

        areTheNumbersRight();
        makeCalculations();
    }

    @Override
    public void calculatePerimeter() {
        mPerimeter = mLeftSide + mRightSide + mSmallBase + mBigBase;
    }

    @Override
    public void calculateArea() {
        calculateHeight();
        mArea = 0.5 * mHeight * (mBigBase + mSmallBase);
    }

    @Override
    public void calculateHeight() {
        mHeight = Math.sqrt(((mBigBase + mLeftSide - mSmallBase + mRightSide)*
                                (-mBigBase + mLeftSide + mSmallBase + mRightSide)*
                                (mBigBase - mLeftSide - mSmallBase + mRightSide)*
                                (mBigBase + mLeftSide - mSmallBase - mRightSide)) /
                                (4 * Math.pow((mBigBase - mSmallBase),2)));
    }

    @Override
    public void makeCalculations() {
        calculatePerimeter();
        calculateArea();
    }

    @Override
    public String toString() {
        return "Trapezoid with following parameters:" + "\n" +
                "Color: " + getmColor() + "\n" +
                "Base: " + getmBigBase() + "; Top: " + getmSmallBase() +
                "; Left side: " + getmLeftSide() + "; Right side: " + getmRightSide() + "\n" +
                "Calculated Height = " + getmHeight() + "\n" +
                "Calculated Perimeter = " + getmPerimeter() + "\n" +
                "Calculated Area = " + getmArea();
    }

    public void areTheNumbersRight(){
        if(mBigBase < mSmallBase ||
                mBigBase < mLeftSide ||
                mBigBase < mRightSide){
            throw new IllegalArgumentException();
        }

        if(mBigBase <= 0){
            throw new IllegalArgumentException();
        }

        if(mSmallBase <= 0){
            throw new IllegalArgumentException();
        }

        if(mLeftSide <= 0){
            throw new IllegalArgumentException();
        }

        if(mRightSide <= 0){
            throw new IllegalArgumentException();
        }
    }

    public double getmBigBase() {
        return mBigBase;
    }

    protected void setmBigBase(double mBigBase) {
        this.mBigBase = mBigBase;
    }

    public double getmSmallBase() {
        return mSmallBase;
    }

    protected void setmSmallBase(double mSmallBase) {
        this.mSmallBase = mSmallBase;
    }

    public double getmLeftSide() {
        return mLeftSide;
    }

    protected void setmLeftSide(double mLeftSide) {
        this.mLeftSide = mLeftSide;
    }

    public double getmRightSide() {
        return mRightSide;
    }

    protected void setmRightSide(double mRightSide) {
        this.mRightSide = mRightSide;
    }

    public double getmPerimeter() {
        return mPerimeter;
    }

    protected void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
    }

    public double getmHeight() {
        return mHeight;
    }
}
