/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam.gestionstock.dao.core;

import cnam.gestionstock.bean.core.LoginBean;
import cnam.gestionstock.bean.core.MenuBean;

/**
 *
 * @author Elie
 */
public interface LoginDAO {
    
    public int validateLogin(LoginBean login);

    public MenuBean[] getUserMenus(int userId);
    
}
