/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.liam.stocks;

import javax.ejb.Stateful;

/**
 *
 * @author benray
 */
@Stateful
public class StockBean {

    private int price;
    private String stockname;
   
    public int getPrice() {
        return price;
    }
    public int setPrice(int price) {
        this.price = price;
        return price;
    }
    public String getStockname() {
        return stockname;
    }
    public void setStockname(String stockname) {
        this.stockname = stockname;
    }
     
    @Override
    public String toString() {
        return "SampleBean [param1=" + price + ", param2=" + stockname + "]";
    }
}
