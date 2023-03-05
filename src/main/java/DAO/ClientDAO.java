package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Client;
import util.DbConexion;

/**
 *
 * @author Warner Moscoso M.
 */
public class ClientDAO {

    private final DbConexion clientConexion = DbConexion.getInstConexion();
    private Connection clientConnection=null;

    public Connection singletonConnection() {
        try {
            if (clientConnection == null) {
                return clientConexion.getConnection();
            } else if(clientConnection.isClosed()) {
                return clientConexion.getConnection();
            }else{
                return clientConnection;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Client> getClientsInf() {
        CallableStatement statement = null;
        ResultSet rs = null;
        try {
            clientConnection = singletonConnection();
            statement = clientConnection.prepareCall("CALL listarClientes()");
            rs = statement.executeQuery();
            List<Client> clientsRegister = new ArrayList();
            while (rs.next()) {
                int clientId = rs.getInt("idclientes");
                String clientName = rs.getString("nombre");
                String clientLastName = rs.getString("apellidos");
                Double clientTotalSales = rs.getDouble("saldo");
                clientsRegister.add(new Client(clientId, clientName, clientLastName, clientTotalSales));
            }
            return clientsRegister;
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error en la conexion de la DB: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }finally {
            try {
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Client getClientInf(int clientId) {
        CallableStatement statement = null;
        ResultSet rs = null;
        try {
            clientConnection = singletonConnection();
            statement = clientConnection.prepareCall("CALL infoCliente(?)");
            statement.setInt(1, clientId);
            rs = statement.executeQuery();
            if (rs.next()) {
                String clientName = rs.getString("nombre");
                String clientLastName = rs.getString("apellidos");
                String clientEmail = rs.getString("email");
                String clientPhone = rs.getString("telefono");
                Double clientTotalSales = rs.getDouble("saldo");
                return new Client(clientId, clientName, clientLastName, clientEmail, clientPhone, clientTotalSales);
            }
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error en la conexion de la DB: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } finally {
            try {
                statement.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public int addClient(Client newClient) {
        CallableStatement statement = null;
        try {
            clientConnection = singletonConnection();
            statement = clientConnection.prepareCall("CALL agregarCliente(?,?,?,?)");
            statement.setString(1, newClient.getClientName());
            statement.setString(2, newClient.getClientLname());
            statement.setString(3, newClient.getClientEmail());
            statement.setString(4, newClient.getClientPhone());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error en la conexion de la DB: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public int updateClient(Client updateClient) {
        CallableStatement statement = null;
        try {
            clientConnection = singletonConnection();
            statement = clientConnection.prepareCall("CALL editarCliente(?,?,?,?,?,?)");
            statement.setInt(1, updateClient.getClientId());
            statement.setString(2, updateClient.getClientName());
            statement.setString(3, updateClient.getClientLname());
            statement.setString(4, updateClient.getClientEmail());
            statement.setString(5, updateClient.getClientPhone());
            statement.setDouble(6, updateClient.getClientTotalSales());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error en la conexion de la DB: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public int removeClient(int clientId) {
        CallableStatement statement = null;
        try {
            clientConnection = singletonConnection();
            statement = clientConnection.prepareCall("CALL eliminarCliente(?)");
            statement.setInt(1, clientId);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error en la conexion de la DB: " + ex.getMessage());
            ex.printStackTrace(System.out);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
}
