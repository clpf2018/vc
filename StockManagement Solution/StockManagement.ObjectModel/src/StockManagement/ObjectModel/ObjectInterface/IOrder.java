/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.ObjectInterface;

import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;

/**
 *
 * @author mfaour
 */
public interface IOrder {

    public int add(Order order);

    public boolean update(Order order);

    public boolean delete(Order order);

    public boolean delete(int ordCode);

    public List<Order> getBySource(OrderRoute orderRoute);

    public List<Order> getByDestination(OrderRoute orderRoute);

    public List<Order> getByCompany(int compCode);
}
