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
public interface IBranch {

    public Branch get(int brCode);

    public int add(Branch branch);

    public int add(int compCode, Branch branch);

    public boolean delete(Branch branch);

    public boolean delete(int brCode);

    public boolean update(Branch branch);

    public boolean assignRole(RoleBranch roleBranch);
    
    public boolean removeRole(RoleBranch roleBranch);
    
    public boolean removeRole(int brCode, int roCode);

    public boolean assignRole(int brCode, int roCode);

    public List<Role> getRoles(Branch branch);

    public List<Role> getRoles(int brCode);
    
    public List<Role> getExcludedRoles(int brCode);

}
