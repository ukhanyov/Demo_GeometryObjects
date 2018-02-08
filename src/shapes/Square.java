package shapes;

import utils.Colors;
import utils.ShapeNames;
import utils.SquarePropertiesCalculations;

import java.util.ArrayList;
import java.util.List;

public class Square extends GeometryObject implements SquarePropertiesCalculations {

    private double mSide;
    private double mDiagonal;
    private double mPerimeter;

    private List<Double> sidesOfTheShape = new ArrayList<>();

    private ShapeNames mName;

    Square(double side, Colors color) {
        this.mSide = side;
        this.mColor = color;
        this.mName = ShapeNames.SQUARE;

        this.sidesOfTheShape.add(mSide);

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
