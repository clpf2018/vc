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
 * @author Khalil Bsaibes
 */
public interface IUser {
      public List<User> getAll();

    public User get(int usrCode);

    public List<User> getByBranch(int brCode);

    public List<Role> getRoles(User user);

    public List<Role> getRoles(int usrCode);

    public List<Action> getAllowedActions(int usrCode);

    public List<Action> getAllowedActions(UserBranch userBranch );
    
    public List<Action> getAllowedActions(User user);

    public User login(User user);
            
    public int add(User user);

    public boolean update(User user);

    public boolean delete(User user);

    public boolean delete(int usrCode);

    public boolean assignRole(UserRole userrole);

    public boolean assignToRole(int roCode, int usrCode);
    
    public boolean removeRole(UserRole userRole);
    
    public boolean removeRole(int roCode, int usrCode);
}
