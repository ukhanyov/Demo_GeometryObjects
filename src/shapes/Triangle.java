package shapes;

import utils.TrianglePropertiesCalculations;

public class Triangle extends GeometryObject implements TrianglePropertiesCalculations{

    private double mSideA;
    private double mSideB;
    private double mSideC;

    private double mBase;
    private double mCathetusOne;
    private double mCathetusTwo;

    private double mPerimeter;


    public Triangle(double mSideA, double mSideB, double mSideC, String color) {
        this.mColor = color;
        this.mSideA = mSideA;
        this.mSideB = mSideB;
        this.mSideC = mSideC;

        findTheBase();
    }

    private void findTheBase() {
        if(Double.compare(mSideA, mSideB) > 0 && Double.compare(mSideA, mSideC) > 0){
            setmBase(mSideA);
            setmCathetusOne(mSideB);
            setmCathetusTwo(mSideC);
            return;
        }
        if(Double.compare(mSideB, mSideA) > 0 && Double.compare(mSideB, mSideC) > 0){
            setmBase(mSideB);
            setmCathetusOne(mSideA);
            setmCathetusTwo(mSideC);
            return;
        }
        setmBase(mSideC);
        setmCathetusOne(mSideA);
        setmCathetusTwo(mSideB);
    }

    public double getmSideA() {
        return mSideA;
    }

    public void setmSideA(double mSideA) {
        this.mSideA = mSideA;
    }

    public double getmSideB() {
        return mSideB;
    }

    public void setmSideB(double mSideB) {
        this.mSideB = mSideB;
    }

    public double getmSideC() {
        return mSideC;
    }

    public void setmSideC(double mSideC) {
        this.mSideC = mSideC;
    }

    public double getmBase() {
        return mBase;
    }

    public void setmBase(double mBase) {
        this.mBase = mBase;
    }

    public double getmCathetusOne() {
        return mCathetusOne;
    }

    public void setmCathetusOne(double mCathetusOne) {
        this.mCathetusOne = mCathetusOne;
    }

    public double getmCathetusTwo() {
        return mCathetusTwo;
    }

    public void setmCathetusTwo(double mCathetusTwo) {
        this.mCathetusTwo = mCathetusTwo;
    }

    public double getmPerimeter() {
        return mPerimeter;
    }

    public void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
    }

    @Override
    public void calculatePerimeter() {
        mPerimeter = mBase + mCathetusOne + mCathetusTwo;
    }

    @Override
    public void calculateArea() {
        double halfPerimeter = (mBase + mCathetusOne + mCathetusTwo) / 2;
        mArea = Math.sqrt(halfPerimeter * (halfPerimeter - mBase) *
                                            (halfPerimeter - mCathetusOne) *
                                            (halfPerimeter - mCathetusTwo));
    }


    @Override
    public void makeCalculations() {
        calculatePerimeter();
        calculateArea();
    }

    public String areTheNumbersRigth(){
        if (mBase >= mCathetusOne + mCathetusTwo){
            return "In given triangle is not valid triangle inequality";
        }
        return null;
    }

}
