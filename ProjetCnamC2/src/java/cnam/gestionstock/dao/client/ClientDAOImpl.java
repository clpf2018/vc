/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam.gestionstock.dao.client;

import cnam.gestionstock.bean.client.ClientBean;

/**
 *
 * @author Elie
 */
public class ClientDAOImpl implements ClientDAO{
    public ClientBean getClient()
    {
        ClientBean clientBean = new ClientBean();
        clientBean.setCltName("Phoenix");
        return clientBean;
    }
    
}
