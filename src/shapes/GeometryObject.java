package shapes;

import utils.Colors;
import utils.ShapeNames;

import java.util.List;

public class GeometryObject {

    Colors mColor;
    ShapeNames mName;
    double mArea;

    List<Double> sidesOfTheShape;

    GeometryObject() {
    }

    public Colors getmColor() {
        return mColor;
    }

    protected void setmColor(Colors mColor) {
        this.mColor = mColor;
    }

    public double getmArea() {
        return mArea;
    }

    protected void setmArea(double mArea) {
        this.mArea = mArea;
    }

    public ShapeNames getmName() {
        return mName;
    }

    protected void setmName(ShapeNames mName) {
        this.mName = mName;
    }

    public List<Double> getSidesOfTheShape() {
        return sidesOfTheShape;
    }

    protected void setSidesOfTheShape(List<Double> sidesOfTheShape) {
        this.sidesOfTheShape = sidesOfTheShape;
    }
}
