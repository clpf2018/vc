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
public interface IRole {
     public List<Role> getAll();

    public Role get(int roCode);
    
    public List<User> getUsers(Role role);

    public List<User> getUsers(int roCode);
    
     public List<Action> getActions(Role role);

    public List<Action> getActions(int roCode);
    
    public int add(Role role);

    public boolean update(Role role);

    public boolean delete(Role role);

    public boolean delete(int roCode);
    
    public int assignAction(RoleAction roleAction);
    
    public int assignAction(int roCode,int actCode);
    
    public boolean removeAction(RoleAction roleAction);
    
    public boolean assignUser(int roCode, int usrCode);
    
    public boolean assignUser(UserRole userrole);
    
    public boolean removeUser(int roCode, int usrCode);
    
    public boolean removeUser(UserRole userrole);
          
}
