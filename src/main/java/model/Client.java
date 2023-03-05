package model;

/**
 *
 * @author Warner Moscoso M.
 */
public class Client {

    private int clientId;
    private String clientName;
    private String clientLname;
    private String clientEmail;
    private String clientPhone;
    private double clientTotalSales;

    public Client() {
    }

    public Client(int clientId, String clientName, String clientLname, double clientTotalSales) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientLname = clientLname;
        this.clientTotalSales = clientTotalSales;
    }

    public Client(String clientName, String clientLname, String clientEmail, String clientPhone, double clientTotalSales) {
        this.clientName = clientName;
        this.clientLname = clientLname;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.clientTotalSales = clientTotalSales;
    }

    
    public Client(int clientId, String clientName, String clientLname, String clientEmail, String clientPhone, double clientTotalSales) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientLname = clientLname;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.clientTotalSales = clientTotalSales;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLname() {
        return clientLname;
    }

    public void setClientLname(String clientLname) {
        this.clientLname = clientLname;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public double getClientTotalSales() {
        return clientTotalSales;
    }

    public void setClientTotalSales(double clientTotalSales) {
        this.clientTotalSales = clientTotalSales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client{");
        sb.append("clientId=").append(clientId);
        sb.append(", clientName=").append(clientName);
        sb.append(", clientLname=").append(clientLname);
        sb.append(", clientEmail=").append(clientEmail);
        sb.append(", clientPhone=").append(clientPhone);
        sb.append(", clientTotalSales=").append(clientTotalSales);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
