package shapes;

public class GeometryObject {

    String mColor;
    String mName;
    double mArea;

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
}
