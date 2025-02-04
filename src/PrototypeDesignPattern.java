//concept is to copy an existing object rather than creating new instance from scratch.
//because creating new instance is costly

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrototypeDesignPattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp("1.2.5.6");

        networkConnection.loadImportantData();
        System.out.println("networkConnection : "+networkConnection);


        NetworkConnection networkConnection1 = networkConnection.clone();
        networkConnection.setIp("1.2.5.7");
        networkConnection.getDomain().add("LMN");
        System.out.println("after changes networkConnection : "+networkConnection);
        System.out.println("networkConnection1 : "+networkConnection1);
        networkConnection1.loadImportantData();

    }
}
class NetworkConnection implements Cloneable
{
    private String ip;
    private String importantData;
    private List<String> domain=new ArrayList<>();

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", importantData='" + importantData + '\'' +
                ", domain=" + domain +
                '}';
    }

    public List<String> getDomain() {
        return domain;
    }

    public void setDomain(List<String> domain) {
        this.domain = domain;
    }

    public void loadImportantData()
{
    this.domain.add("XYZ");
    this.domain.add("PQR");
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
    public NetworkConnection clone() throws CloneNotSupportedException {
       /* NetworkConnection clone = (NetworkConnection) super.clone();
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return clone;*/
        NetworkConnection cloned = new NetworkConnection();
        cloned.setIp(this.ip);
        cloned.setImportantData(this.importantData);
        for(String s: this.getDomain())
        {
            cloned.getDomain().add(s);
        }
        return cloned;
    }
}