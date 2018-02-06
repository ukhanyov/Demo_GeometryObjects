package shapes;

public class GeometryObject {

    protected String mColor;
    protected double mArea;

    public GeometryObject() {
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
}
