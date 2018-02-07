package shapes;

import utils.SquarePropertiesCalculations;

public class Square extends GeometryObject implements SquarePropertiesCalculations {

    private double mSide;
    private double mDiagonal;
    private double mPerimeter;

    private String mName;

    Square(double side, String color, String name) {
        this.mSide = side;
        this.mColor = color;
        this.mName = name;

        areTheNumbersRight();
        makeCalculations();
    }

    @Override
    public void calculatePerimeter() {
        mPerimeter = 4 * mSide;
    }

    @Override
    public void calculateArea() {
        mArea = Math.pow(mSide, 2);
    }

    @Override
    public void calculateDiagonal() {
        mDiagonal = mSide * Math.sqrt(2);
    }

    @Override
    public String toString() {
        return String.format("Square with following parameters:" + "\n" +
                "Color: " + getmColor() + "\n" +
                "Side: " + "%.3f" + "\n" +
                "Calculated Diagonal = " + "%.3f" + "\n" +
                "Calculated Perimeter = " + "%.3f" + "\n" +
                "Calculated Area = " + "%.3f",
                (float)getmSide(), (float) getmDiagonal(), (float) getmPerimeter(), (float) getmArea());
    }

    public void makeCalculations(){
        calculateDiagonal();
        calculatePerimeter();
        calculateArea();
    }

    private void areTheNumbersRight(){
        if(mSide <= 0){
            throw new IllegalArgumentException();
        }
    }

    protected double getmSide() {
        return mSide;
    }

    protected void setmSide(double mSide) {
        this.mSide = mSide;
    }

    protected double getmDiagonal() {
        return mDiagonal;
    }

    protected void setmDiagonal(double mDiagonal) {
        this.mDiagonal = mDiagonal;
    }

    protected double getmPerimeter() {
        return mPerimeter;
    }

    protected void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
    }

    public String getmName() {
        return mName;
    }

    protected void setmName(String mName) {
        this.mName = mName;
    }
}
