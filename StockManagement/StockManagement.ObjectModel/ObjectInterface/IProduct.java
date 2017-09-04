/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.ObjectInterface;

import StockManagement.ObjectModel.ValueObject.Product;
import StockManagement.ObjectModel.ValueObject.Stock;
import StockManagement.ObjectModel.Utilities.StatusEnum;
import StockManagement.ObjectModel.ValueObject.Branch;
import StockManagement.ObjectModel.ValueObject.BranchProduct;
import StockManagement.ObjectModel.ValueObject.StockProduct;
import java.util.List;

/**
 *
 * @author mfaour
 */
public interface IProduct {
    
    public Product get(int prCode);
    public Product getByBarcode(String prBarcode);
    public List<Product> getByType(int prType);
    public List<Product> getAll(StatusEnum status);
    public List<Product> getBySupplier(int supCode);
    public List<Product> getByBrand(int brdCode);
    public List<Product> getByBranch(int brCode);
    
    public int add(Product product);
    public boolean addToStock(StockProduct stockproduct);
    public boolean addToStock(Product product,Stock stock,int qty);
    public boolean addToBranch(Product product,Branch branch,int qty);
    public boolean addToBranch(BranchProduct branchproduct);

    public boolean delete(Product product);
    public boolean delete(int prCode);
    public boolean update(Product product);
    
}
