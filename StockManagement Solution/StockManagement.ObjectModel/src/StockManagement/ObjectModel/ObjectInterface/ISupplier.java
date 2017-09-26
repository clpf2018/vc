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
 * @author Elie
 */
public interface ISupplier {
    public Supplier get(int supCode);
    public List<Supplier> getAll();
    public List<Product> getProducts(int supCode);
    public int add(Supplier supplier);
    public boolean update(Supplier supplier);
    public boolean delete(Supplier supplier);
    public boolean delete(int supCode);
    public int addProduct(Product product);
    public int addProduct(int supCode,Product product);
    public boolean deleteProduct(Product product);
    public boolean deleteProduct(int prCode);
    public boolean updateProduct(Product product);
}