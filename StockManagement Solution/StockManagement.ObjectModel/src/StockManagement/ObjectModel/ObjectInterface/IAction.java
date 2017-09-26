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
public interface IAction {

    public Action get(int actCode);

    public List<Action> getAll();

    public List<Action> getByRole(int roCode);

    public int add(Action action);

    public boolean update(Action action);

    public boolean delete(Action action);

    public boolean delete(int actCode);
}
