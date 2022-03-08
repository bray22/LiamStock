/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.liam.stocks;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benray
 */
public class StockServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stockname = request.getParameter("name");
       // String price = request.getParameter("price");
       // int priceInt = Integer.parseInt(price);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet55</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServle." + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
              StockBean eObj = new StockBean();
       
        eObj.setPrice( getWebService() );
       eObj.setStockname(stockname);
       
 
        eObj.getPrice();
        
        /**** Storing Bean In Session ****/
        request.getSession().setAttribute("emp", eObj);
 
       RequestDispatcher rd = request.getRequestDispatcher("Stock.jsp");
       rd.forward(request, response);
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    public int getWebService() throws IOException {
        String key = "4VXR79BQJX7LYJ80";
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=" + key;
        
        
        
        
         HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response;
         ObjectMapper objectMapper = new ObjectMapper();
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            
            response.body();
            System.out.println(response.body());
           
        } catch (InterruptedException ex) {
            Logger.getLogger(StockServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //TODO get stock quote from API
       
        return 45;
    }

}
