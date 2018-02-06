import utils.SquarePropertiesCalculations;

public class Square extends GeometryObject implements SquarePropertiesCalculations{

    private double mSide;
    private double mDiagonal;
    private double mPerimeter;

    private Square(double side, String color) {
        super();
        mSide = side;
        mColor = color;
    }

    public double getmSide() {
        return mSide;
    }

    public void setmSide(double mSide) {
        this.mSide = mSide;
    }

    public double getmDiagonal() {
        return mDiagonal;
    }

    public void setmDiagonal(double mDiagonal) {
        this.mDiagonal = mDiagonal;
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
}
