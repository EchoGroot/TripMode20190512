package TripMode.Model;

public class Connection {
    private String connectionId;
    private String connectionValue;

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionValue() {
        return connectionValue;
    }

    public void setConnectionValue(String connectionValue) {
        this.connectionValue = connectionValue;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "connectionId='" + connectionId + '\'' +
                ", connectionValue='" + connectionValue + '\'' +
                '}';
    }
}
