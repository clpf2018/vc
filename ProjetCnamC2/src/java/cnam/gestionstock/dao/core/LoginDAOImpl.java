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
public class LoginDAOImpl implements LoginDAO{

    @Override
    public int validateLogin(LoginBean login) {
       int userId =-1;
       
       String userName = login.getUser().getUserName();
       String password = login.getUser().getPassword();
       //here we should check if the username and password are correct in the db and return the user Id
       userId = 1;
       return userId;
       
    }
    
    @Override
    public MenuBean[] getUserMenus(int userId) {
        
    MenuBean[] menus =  new MenuBean[4];//use the size of the returned object from the DB instead
    // get Menus from DB where userId = userId
    // there should be a list or a collection or vector .... containing the menus 
    /*for (int i=0;i<size;i++) or iterator
    {
       menus[i].setMenuCode(list.getmenucode);
       menus[i].setMenuName(list.getmenunme);
       menus[i].setMenuType(list.getmenutype);

    }*/
    MenuBean menu = new MenuBean();
    menu.setMenuCode(1);
    menu.setMenuName("ITEM");
    menu.setMenuType("P");
    menus[0]=menu;
    
    menu = new MenuBean();
    menu.setMenuCode(2);
    menu.setMenuName("Item List");
    menu.setMenuType("C");
    menus[1]=menu;
    
    menu = new MenuBean();
    menu.setMenuCode(3);
    menu.setMenuName("Add Item");
    menu.setMenuType("C");
    menus[2]=menu;
    
    menu = new MenuBean();
    menu.setMenuCode(4);
    menu.setMenuName("Client");
    menu.setMenuType("PC");
    menus[3]=menu;
    
    return menus;
    }
    
}
