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
 * @author MikeRmaily
 */
public interface IBrand {

    public Brand get(int brdCode);

    public List<Brand> getAll();

    public List<Product> getProducts(int brdCode);
            
    public int add(Brand brand);

    public boolean update(Brand brand);

    public boolean delete(Brand brand);

    public boolean delete(int brdCode);

    public int addProduct(Product product);

    public int addProduct(int brdCode, Product product);

    public boolean deleteProduct(Product product);

    public boolean deleteProduct(int prCode);

    public boolean updateProduct(Product product);
}
