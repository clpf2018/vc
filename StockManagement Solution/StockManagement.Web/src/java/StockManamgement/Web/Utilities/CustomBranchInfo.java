/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Utilities;

import StockManagement.ObjectModel.ValueObject.Branch;
import StockManagement.ObjectModel.ValueObject.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mfaour
 */
public class CustomBranchInfo {
    private Branch branch;
    private List<Role> includedRoles;
    private List<Role> excludedRoles;
    
    public CustomBranchInfo(Branch branch,List<Role> includedRoles,List<Role> excludedRoles)
    {
        this.branch = branch;
        this.excludedRoles = excludedRoles;
        this.includedRoles = includedRoles;
    }

    /**
     * @return the branch
     */
    public Branch getBranch() {
        return branch;
    }

    /**
     * @return the includedRoles
     */
    public List<Role> getIncludedRoles() {
        if ( includedRoles == null)
            includedRoles = new ArrayList<>();
        return includedRoles;
    }

    /**
     * @return the excludedRoles
     */
    public List<Role> getExcludedRoles() {
        if ( excludedRoles == null)
            excludedRoles = new ArrayList<>();
        return excludedRoles;
    }
    
    
}
