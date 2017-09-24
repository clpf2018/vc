/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IBrand;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author MikeRmaily
 */
public class BrandController implements IBrand {

    private SessionFactory _sessionFactory;
    private Session _session;

    public BrandController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }

    @Override
    public Brand get(Integer brCode) {
        Object objBranch = _session.get(Brand.class, brCode);
        if (null == objBranch) {
            return null;
        }
        return (Brand) objBranch;
    }

    @Override
    public List<Brand> getAll() {
        List<Brand> brands = _session.createQuery("From Brand").list();
        if (null == brands || brands.isEmpty()) {
            return null;
        }
        return brands;
    }
    
    @Override
    public int add(Brand brand) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.save(brand);
            tx.commit();
            return brand.getBrdCode();
        } catch (Exception e) {
            throw (e);
        } 
    }

    @Override
    public boolean update(Brand brand) {
         try {
            Transaction tx = _session.beginTransaction();
            _session.update(brand);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        } 
    }
    @Override
    public boolean delete(int brandCode) {
           try {
            Transaction tx = _session.beginTransaction();
           _session.createQuery("delete from Brand where BrdCode= " + brandCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        } 
    }
   

    @Override
    public List<Product> getProducts(Integer brdCode) {
        List<Product> products = _session.createQuery("From Product where BrdCode = "+brdCode).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        return products;
    }
   

    @Override
    public int addProduct(Product product) {
        if ( null == product.getBrand() )
            return -1;
        ProductController controller = new ProductController();
        return controller.add(product);
    }

    public int addProduct(Integer brdCode, Product product) {
        Brand brd = get(brdCode);
        if ( null == brd)
            return -1;
       product.setBrand(brd);
        ProductController controller = new ProductController();
        return controller.add(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
      ProductController controller = new ProductController();
        return controller.delete(product);
    }

    public boolean deleteProduct(Integer prCode) { 
        ProductController controller = new ProductController();
        return controller.delete(prCode);
    }

    @Override
    public boolean updateProduct(Product product) {
       ProductController controller = new ProductController();
        return controller.update(product);
    }

    
    
}
