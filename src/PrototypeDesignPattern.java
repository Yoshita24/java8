//concept is to copy an existing object rather than creating new instance from scratch.
//because creating new instance is costly

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp("1.2.5.6");

        networkConnection.loadImportantData();
        System.out.println("networkConnection : "+networkConnection);
        NetworkConnection networkConnection1 = networkConnection.clone();
        System.out.println("networkConnection1 : "+networkConnection1);
        networkConnection1.loadImportantData();

    }
}
class NetworkConnection implements Cloneable
{
    private String ip;
    private String importantData;

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", importantData='" + importantData + '\'' +
                '}';
    }

    public void loadImportantData()
{
    this.importantData = "Very very important data";
}
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImportantData() {
        return importantData;
    }

    public void setImportantData(String importantData) {
        this.importantData = importantData;
    }

    @Override
    public NetworkConnection clone() {
        try {
            NetworkConnection clone = (NetworkConnection) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}