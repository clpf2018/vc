/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ValueObject.Stock;
import StockManagement.ObjectModel.ValueObject.Product;
import StockManagement.ObjectModel.ValueObject.StockProduct;
import StockManagement.ObjectModel.ValueObject.Branch;
import StockManagement.ObjectModel.ValueObject.BranchProduct;
import StockManagement.ObjectModel.ObjectInterface.IProduct;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.Utilities.StatusEnum;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mfaour
 */
public class ProductController implements IProduct {

    private SessionFactory _sessionFactory;
    private Session _session;

    public ProductController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
         _session = _sessionFactory.openSession();
    }

    @Override
    public Product get(int prCode) {
        Object objProduct = _session.get(Product.class, prCode);
        if (null == objProduct) {
            return null;
        }
        return (Product) objProduct;
    }

    @Override
    public Product getByBarcode(String prBarcode) {
        List<Product> products = _session.createQuery("From Product where PrBarCode = " + prBarcode).list();

        if (null == products || products.isEmpty()) {
            return null;
        }
        return products.get(0);
    }

    @Override
    public List<Product> getByType(int prType) {
        List<Product> products = _session.createQuery("From Product where PrType = " + prType).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        return products;
    }

    @Override
    public List<Product> getAll(StatusEnum status) {
        String query = "From Product";
        if (status == StatusEnum.Active) {
            query += " where PrStatus =1";
        } else if (status == StatusEnum.Inactive) {
            query += " where PrStatus =0";
        }

        List<Product> products = _session.createQuery(query).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        return products;
    }

    @Override
    public List<Product> getBySupplier(int supCode) {
        List<Product> products = _session.createQuery("From Product where SupCode = " + supCode).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        return products;
    }

    @Override
    public List<Product> getByBrand(int brdCode) {
        List<Product> products = _session.createQuery("From Product where BrdCode = " + brdCode).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        return products;
    }

    @Override
    public List<Product> getByBranch(int brCode) {
        List<Product> products = _session.createQuery("Select Product.* From Product join BranchProduct "
                + "where Product.PrCode = BranchProduct.PrCode and BranchProduct.BrCode = " + brCode).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        return products;
    }

    @Override
    public int add(Product product) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.save(product);
            tx.commit();
            return product.getPrCode();
        } catch (Exception e) {
            throw (e);
        } finally {
            /* if (!_sessionFactory.isClosed()) {
                _sessionFactory.close();
            }*/
        }
    }

    @Override
    public boolean addToStock(Product product, Stock stock, int qty) {
        try {
            StockProduct stockProduct = new StockProduct();
            stockProduct.setProduct(product);
            stockProduct.setStock(stock);
            stockProduct.setStkPrQty(qty);

            Transaction tx = _session.beginTransaction();
            _session.save(stockProduct);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean addToStock(StockProduct stockproduct ) {
        try {
            if (null == stockproduct ||
                    null == stockproduct.getStock() ||
                    null == stockproduct.getProduct() ) {
                return false;
            }
            Transaction tx = _session.beginTransaction();
            _session.save(stockproduct);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean addToBranch(Product product, Branch branch, int qty) {
        try {

            BranchProduct productBranch = new BranchProduct();
            productBranch.setProduct(product);
            productBranch.setBranch(branch);
            productBranch.setQty(qty);

            Transaction tx = _session.beginTransaction();
            _session.save(productBranch);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean addToBranch(BranchProduct branchProduct) {
        try {
          if (null == branchProduct ||
                    null == branchProduct.getBranch()||
                    null == branchProduct.getProduct() ) {
                return false;
            }
            Transaction tx = _session.beginTransaction();
            _session.save(branchProduct);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(Product product) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.delete(product);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(int prCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Product where PrCode= " + prCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean update(Product product) {
         try {
            Transaction tx = _session.beginTransaction();
            _session.update(product);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

}
