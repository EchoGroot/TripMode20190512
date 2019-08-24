package main.java.domain;

/**
 * @author yuyy
 * @date 2019/8/22 9:40
 */
public class Result {
    private String RESULT_CODE;
    private String RESULT_INFO;

    public Result(String RESULT_CODE, String RESULT_INFO) {
        this.RESULT_CODE = RESULT_CODE;
        this.RESULT_INFO = RESULT_INFO;
    }

    public String getRESULT_CODE() {
        return RESULT_CODE;
    }

    public void setRESULT_CODE(String RESULT_CODE) {
        this.RESULT_CODE = RESULT_CODE;
    }

    public String getRESULT_INFO() {
        return RESULT_INFO;
    }

    public void setRESULT_INFO(String RESULT_INFO) {
        this.RESULT_INFO = RESULT_INFO;
    }

    @Override
    public String toString() {
        return "Result{" +
                "RESULT_CODE='" + RESULT_CODE + '\'' +
                ", RESULT_INFO='" + RESULT_INFO + '\'' +
                '}';
    }
}
