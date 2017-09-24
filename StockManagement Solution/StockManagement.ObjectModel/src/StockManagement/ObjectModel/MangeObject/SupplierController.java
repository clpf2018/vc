/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.ISupplier;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Elie
 */
public class SupplierController implements ISupplier {

    private SessionFactory _sessionFactory;
    private Session _session;

    public SupplierController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.getCurrentSession();
    }

    @Override
    public Supplier get(int supCode) {
        Object objSupplier = _session.get(Action.class, supCode);
        if (null == objSupplier) {
            return null;
        }
        return (Supplier) objSupplier;
    }

    @Override
    public List<Supplier> getAll() {
        List<Supplier> suppliers = _session.createQuery("From Supplier").list();
        if (null == suppliers || suppliers.isEmpty()) {
            return null;
        }
        return suppliers;
    }

    @Override
    public List<Product> getProducts(int supCode) {
        List<Product> products = _session.createQuery("From Product where SupCode = " + supCode).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        return products;
    }

    @Override
    public int add(Supplier supplier) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.save(supplier);
            tx.commit();
            return supplier.getSupCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean update(Supplier supplier) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.update(supplier);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(Supplier supplier) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.delete(supplier);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(int supCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Supplier where SupCode= " + supCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public int addProduct(Product product) {
        if (null == product
                || null == product.getSupplier()) {
            return -1;
        }
        ProductController controller = new ProductController();
        return controller.add(product);
    }

    @Override
    public int addProduct(int supCode, Product product) {
        Supplier supp = get(supCode);
        if (null == supp) {
            return -1;
        }
        product.setSupplier(supp);
        ProductController controller = new ProductController();
        return controller.add(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        ProductController controller = new ProductController();
        return controller.delete(product);
    }

    @Override
    public boolean deleteProduct(int prCode) {
        ProductController controller = new ProductController();
        return controller.delete(prCode);
    }

    @Override
    public boolean updateProduct(Product product) {
        ProductController controller = new ProductController();
        return controller.update(product);
    }

}

