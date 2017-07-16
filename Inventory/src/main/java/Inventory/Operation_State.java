/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

/**
 *
 * @author joseph
 */
class Operation_State { //Draft,Waiting availability ,partially avaialble ,Available , done
    
//* Draft: not confirmed yet and will not be scheduled until confirmed
//* Waiting Another Operation: waiting for another move to proceed before it becomes automatically available (e.g. in Make-To-Order flows)
//* Waiting Availability: still waiting for the availability of products
//* Partially Available: some products are available and reserved
//* Ready to Transfer: products reserved, simply waiting for confirmation.
//* Transferred: has been processed, can't be modified or cancelled anymore
//* Cancelled: has been cancelled, can't be confirmed anymore

    private int ID;
    private String Name;
    
    
    
}
