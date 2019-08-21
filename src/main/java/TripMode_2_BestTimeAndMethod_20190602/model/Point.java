package TripMode_2_BestTimeAndMethod_20190602.model;

public class Point {
    private int POINT_ID;
    private String LON_MIN;
    private String LON_MAX;
    private String LAT_MIN;
    private String LAT_MAX;

    public Point() {
    }

    public Point(int POINT_ID, String LON_MIN, String LON_MAX, String LAT_MIN, String LAT_MAX) {
        this.POINT_ID = POINT_ID;
        this.LON_MIN = LON_MIN;
        this.LON_MAX = LON_MAX;
        this.LAT_MIN = LAT_MIN;
        this.LAT_MAX = LAT_MAX;
    }

    public int getPOINT_ID() {
        return POINT_ID;
    }

    public void setPOINT_ID(int POINT_ID) {
        this.POINT_ID = POINT_ID;
    }

    public String getLON_MIN() {
        return LON_MIN;
    }

    public void setLON_MIN(String LON_MIN) {
        this.LON_MIN = LON_MIN;
    }

    public String getLON_MAX() {
        return LON_MAX;
    }

    public void setLON_MAX(String LON_MAX) {
        this.LON_MAX = LON_MAX;
    }

    public String getLAT_MIN() {
        return LAT_MIN;
    }

    public void setLAT_MIN(String LAT_MIN) {
        this.LAT_MIN = LAT_MIN;
    }

    public String getLAT_MAX() {
        return LAT_MAX;
    }

    public void setLAT_MAX(String LAT_MAX) {
        this.LAT_MAX = LAT_MAX;
    }

    @Override
    public String toString() {
        return "Point{" +
                "POINT_ID=" + POINT_ID +
                ", LON_MIN='" + LON_MIN + '\'' +
                ", LON_MAX='" + LON_MAX + '\'' +
                ", LAT_MIN='" + LAT_MIN + '\'' +
                ", LAT_MAX='" + LAT_MAX + '\'' +
                '}';
    }
}
