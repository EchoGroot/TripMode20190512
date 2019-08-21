package TripMode_2_BestTimeAndMethod_20190602.model;

public class Result {
    private String Time;
    private String Method;
    private Double value;

    public Result() {
    }

    public Result(String time, String method) {
        Time = time;
        Method = method;
    }

    public Result(String time, String method, Double value) {
        Time = time;
        Method = method;
        this.value = value;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result{" +
                "Time='" + Time + '\'' +
                ", Method='" + Method + '\'' +
                '}';
    }
}
