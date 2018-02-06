package shapes;

public class GeometryObject {

    String mColor;
    double mArea;

    GeometryObject() {
    }

    String getmColor() {
        return mColor;
    }

    protected void setmColor(String mColor) {
        this.mColor = mColor;
    }

    double getmArea() {
        return mArea;
    }

    void setmArea(double mArea) {
        this.mArea = mArea;
    }
}
