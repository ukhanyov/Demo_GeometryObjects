package shapes;

import utils.Colors;
import utils.ShapeNames;
import utils.TrapezoidPropertiesCalculations;

import java.util.ArrayList;
import java.util.List;

public class Trapezoid extends GeometryObject implements TrapezoidPropertiesCalculations {

    private double mBigBase;
    private double mSmallBase;
    private double mLeftSide;
    private double mRightSide;

    private List<Double> sidesOfTheShape = new ArrayList<>();

    private ShapeNames mName;

    private double mHeight;

    private double mPerimeter;

    Trapezoid(double mBigBase, double mSmallBase, double mLeftSide, double mRightSide, Colors color) {
        this.mColor = color;
        this.mBigBase = mBigBase;
        this.mSmallBase = mSmallBase;
        this.mLeftSide = mLeftSide;
        this.mRightSide = mRightSide;
        this.mName = ShapeNames.TRAPEZOID;

        this.sidesOfTheShape.add(mBigBase);
        this.sidesOfTheShape.add(mSmallBase);
        this.sidesOfTheShape.add(mLeftSide);
        this.sidesOfTheShape.add(mRightSide);

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
        return String.format("Trapezoid with following parameters:" + "\n" +
                "Color: " + getmColor() + "\n" +
                "Base: " + "%.3f" + "\n" +
                "Top: " + "%.3f" + "\n" +
                "Left side: " + "%.3f" + "\n" +
                "Right side: " + "%.3f" + "\n" +
                "Calculated Height = " + "%.3f" + "\n" +
                "Calculated Perimeter = " + "%.3f" + "\n" +
                "Calculated Area = " + "%.3f",
                (float)getmBigBase(), (float)getmSmallBase(), (float)getmLeftSide(), (float)getmRightSide(),
                (float)getmHeight(), (float)getmPerimeter(), (float)getmArea());
    }

    private void areTheNumbersRight(){
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

    protected double getmBigBase() {
        return mBigBase;
    }

    protected void setmBigBase(double mBigBase) {
        this.mBigBase = mBigBase;
    }

    protected double getmSmallBase() {
        return mSmallBase;
    }

    protected void setmSmallBase(double mSmallBase) {
        this.mSmallBase = mSmallBase;
    }

    protected double getmLeftSide() {
        return mLeftSide;
    }

    protected void setmLeftSide(double mLeftSide) {
        this.mLeftSide = mLeftSide;
    }

    protected double getmRightSide() {
        return mRightSide;
    }

    protected void setmRightSide(double mRightSide) {
        this.mRightSide = mRightSide;
    }

    protected double getmPerimeter() {
        return mPerimeter;
    }

    protected void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
    }

    protected double getmHeight() {
        return mHeight;
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
