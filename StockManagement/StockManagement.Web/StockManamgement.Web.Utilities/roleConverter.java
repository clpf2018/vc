/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Utilities;

import StockManagement.ObjectModel.ValueObject.Role;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

/**
 *
 * @author mfaour
 */
@FacesConverter(value = "roleConverter")
public class roleConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        DualListModel<Role> model = (DualListModel<Role>) ((PickList) uic).getValue();
        for (Role role : model.getSource()) {
            if (role.getRoName().equals(value)) {
                return role;
            }
        }
        for (Role role : model.getTarget()) {
            if (role.getRoName().equals(value)) {
                return role;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        return ((Role) value).getRoName();
    }

}
