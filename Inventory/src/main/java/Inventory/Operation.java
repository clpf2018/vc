/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author joseph
 */
class Operation {
    
    private int ID;
    private Person peron;
    private Address Source;
    private Address Destination;
    private Date Scheduled_Date;
    private Operation_type Opt;
    private ArrayList<Product> products_demand;
    private Operation_State State;
    private String Reference_Sequence;
    
    
}
