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
public interface ICompany {

    public Company get(int compCode);
    
    public List<Company> getAll();
    
    public int add(Company company);

    public boolean update(Company company);

    public boolean delete(Company company);

    public boolean delete(int compCode);

    public int addStock(Stock stock);
    
    public Stock getStock(int compCode);

    public int addStock(int compCode, Stock stock);
    
    public boolean deleteStock(Stock stock);
    
    public boolean deleteStock(int stkCode);
    
    public boolean updateStock(Stock stock);

    public int addBranch(Branch branch);

    public int addBranch(int compCode, Branch branch);

    public boolean deleteBranch(Branch branch);

    public boolean deleteBranch(int brCode);
    
    public boolean updateBranch(Branch branch);

    public List<Branch> getBranches(Company company);

    public List<Branch> getBranches(int compCode);
}
