/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import Services.ServicesClient;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Client;

/**
 *
 * @author Warner Moscoso M.
 */
@WebServlet("/ServletControlador")
public class ServletController extends HttpServlet {

    private final ServicesClient sc = new ServicesClient();

    private void loadMainPageClient(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Client> registerClients = sc.getClientsInf();
            HttpSession session = request.getSession();
            session.setAttribute("registerClients", registerClients);
            session.setAttribute("totalRevenue", sc.getTotalRevenue(registerClients));
            session.setAttribute("totalClients", registerClients.size());
            response.sendRedirect("client.jsp");
        } catch (IOException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Double totalSales = Double.valueOf(request.getParameter("TotalSales"));
        sc.addClient(name, lastname, email, phone, totalSales);
    }

    private void formEditClient(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idClient = Integer.parseInt(request.getParameter("clientId"));
            Client infClient = sc.getClientInf(idClient);
            request.setAttribute("infClient", infClient);
            request.getRequestDispatcher("editClient.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editClient(HttpServletRequest request, HttpServletResponse response) {
        int idClient = Integer.parseInt(request.getParameter("clientId"));
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Double totalSales = Double.valueOf(request.getParameter("TotalSales"));
        System.out.println("id: "+ idClient+"nombre: " + name +" Apellido: " + lastname + " email: "+email +" Telefono: "+ phone+ " Total Sales: " +totalSales);
        sc.updateClient(idClient, name, lastname, email, phone, totalSales);
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) {
        int idClient = Integer.parseInt(request.getParameter("clientId"));
        sc.removeClient(idClient);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("accion");
        if (null == accion) {
            loadMainPageClient(request, response);
        } else {
            switch (accion) {
                case "deleteClient":
                    deleteClient(request, response);
                    loadMainPageClient(request, response);
                    break;
                case "editClient":
                    formEditClient(request, response);
                    break;
                default:
                    loadMainPageClient(request, response);
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "addClient":
                    addClient(request, response);
                    loadMainPageClient(request, response);
                    break;
                case "editClient":
                    editClient(request, response);
                    loadMainPageClient(request, response);
                    break;
                default:
                    loadMainPageClient(request, response);
            }
        }

    }
}
