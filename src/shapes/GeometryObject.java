package shapes;

import java.util.List;

public class GeometryObject {

    String mColor;
    String mName;
    double mArea;

    List<Double> sidesOfTheShape;

    GeometryObject() {
    }

    public String getmColor() {
        return mColor;
    }

    protected void setmColor(String mColor) {
        this.mColor = mColor;
    }

    public double getmArea() {
        return mArea;
    }

    protected void setmArea(double mArea) {
        this.mArea = mArea;
    }

    public String getmName() {
        return mName;
    }

    protected void setmName(String mName) {
        this.mName = mName;
    }

    public List<Double> getSidesOfTheShape() {
        return sidesOfTheShape;
    }

    protected void setSidesOfTheShape(List<Double> sidesOfTheSpape) {
        this.sidesOfTheShape = sidesOfTheSpape;
    }
}
