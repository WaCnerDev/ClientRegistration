/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DAO.ClientDAO;
import java.util.List;
import model.Client;

/**
 *
 * @author Warner Moscoso M.
 */
public class ServicesClient {
    
    private final ClientDAO dao=new ClientDAO();
    
    public List<Client> getClientsInf() {
        return dao.getClientsInf();
    }

    public Client getClientInf(int clientId) {
        return dao.getClientInf(clientId);
    }

    public int addClient(String clientName, String clientLname, String clientEmail, String clientPhone, double clientTotalSales) {
        return dao.addClient(new Client(clientName, clientLname, clientEmail, clientPhone, clientTotalSales));
    }

    public int updateClient(int clientId, String clientName, String clientLname, String clientEmail, String clientPhone, double clientTotalSales) {
        return dao.updateClient(new Client(clientId,clientName, clientLname, clientEmail, clientPhone, clientTotalSales));
    }

    public int removeClient(int clientId) {
        return dao.removeClient(clientId);
    }
    
    public int getTotalRevenue(List<Client> clients){
        int totalRevenue=0;
        for (Client client : clients) {
            totalRevenue+=client.getClientTotalSales();
        }
        return totalRevenue;
    }
}
