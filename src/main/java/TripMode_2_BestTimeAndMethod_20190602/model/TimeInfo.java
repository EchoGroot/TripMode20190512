package TripMode_2_BestTimeAndMethod_20190602.model;

public class TimeInfo {
    private Integer START_POINT;
    private Integer END_POINT;
    private Integer TIME_CONSUMED;
    private String DATE_TIME;
    private String WAY;

    public TimeInfo(Integer START_POINT, Integer END_POINT, Integer TIME_CONSUMED, String DATE_TIME, String WAY) {
        this.START_POINT = START_POINT;
        this.END_POINT = END_POINT;
        this.TIME_CONSUMED = TIME_CONSUMED;
        this.DATE_TIME = DATE_TIME;
        this.WAY = WAY;
    }

    public TimeInfo() {
    }

    public Integer getSTART_POINT() {
        return START_POINT;
    }

    public void setSTART_POINT(Integer START_POINT) {
        this.START_POINT = START_POINT;
    }

    public Integer getEND_POINT() {
        return END_POINT;
    }

    public void setEND_POINT(Integer END_POINT) {
        this.END_POINT = END_POINT;
    }

    public Integer getTIME_CONSUMED() {
        return TIME_CONSUMED;
    }

    public void setTIME_CONSUMED(Integer TIME_CONSUMED) {
        this.TIME_CONSUMED = TIME_CONSUMED;
    }

    public String getDATE_TIME() {
        return DATE_TIME;
    }

    public void setDATE_TIME(String DATE_TIME) {
        this.DATE_TIME = DATE_TIME;
    }

    public String getWAY() {
        return WAY;
    }

    public void setWAY(String WAY) {
        this.WAY = WAY;
    }

    @Override
    public String toString() {
        return "TimeInfo{" +
                "START_POINT=" + START_POINT +
                ", END_POINT=" + END_POINT +
                ", TIME_CONSUMED=" + TIME_CONSUMED +
                ", DATE_TIME='" + DATE_TIME + '\'' +
                ", WAY='" + WAY + '\'' +
                '}';
    }
}
