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
import StockManagement.ObjectModel.ValueObject.Brand;
import StockManagement.ObjectModel.ValueObject.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
        Product original = (Product) objProduct;
        Product copy = new Product();
        copy.setCostPrice(original.getCostPrice());
        copy.setPrBarCode(original.getPrBarCode());
        copy.setPrCode(original.getPrCode());
        copy.setPrFamily(original.getPrFamily());
        copy.setPrName(original.getPrName());
        copy.setPrSeason(original.getPrSeason());
        copy.setPrStatus(original.isPrStatus());
        copy.setPrType(original.getPrType());
        copy.setSellingPrice(original.getSellingPrice());

        return copy;
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
        List<Product> products = _session.createQuery("From Product where supCode = " + supCode).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        List<Product> newList = new ArrayList();
        for (int i = 0; i < products.size(); i++) {
            Product original = products.get(i);
            Product copy = new Product();
            copy.setCostPrice(original.getCostPrice());
            copy.setPrBarCode(original.getPrBarCode());
            copy.setPrCode(original.getPrCode());
            copy.setPrFamily(original.getPrFamily());
            copy.setPrName(original.getPrName());
            copy.setPrSeason(original.getPrSeason());
            copy.setPrStatus(original.isPrStatus());
            copy.setPrType(original.getPrType());
            copy.setSellingPrice(original.getSellingPrice());
            newList.add(copy);
        }
        return newList;

    }

    @Override
    public List<StockProduct> getStockProductByStock(int stkCode) {
        List<StockProduct> products = _session.createQuery("from StockProduct where stkCode = " + stkCode).list();
        if (null == products || products.isEmpty()) {
            return null;
        }

        for (int i = 0; i < products.size(); i++) {
            StockProduct sp = new StockProduct();
            sp.setStkPrQty(products.get(i).getStkPrQty());
        }
        return products;
    }

    @Override
    public List<Product> getByStock(int stkCode) {
        List<Product> products = _session.createQuery("select P from Product P,StockProduct SP where P.prCode= SP.product.prCode and SP.stock.stkCode = " + stkCode).list();
        if (null == products || products.isEmpty()) {
            return null;
        }
        List<Product> newList = new ArrayList();
        for (int i = 0; i < products.size(); i++) {
            Product original = products.get(i);
            Product copy = new Product();
            copy.setCostPrice(original.getCostPrice());
            copy.setPrBarCode(original.getPrBarCode());
            copy.setPrCode(original.getPrCode());
            copy.setPrFamily(original.getPrFamily());
            copy.setPrName(original.getPrName());
            copy.setPrSeason(original.getPrSeason());
            copy.setPrStatus(original.isPrStatus());
            copy.setPrType(original.getPrType());
            copy.setSellingPrice(original.getSellingPrice());
            Set spObject = original.getStockProducts();
            StockProduct sp = null;
            if (spObject != null && !spObject.isEmpty()) {
                sp = (StockProduct) spObject.iterator().next();
            }
            if (sp != null) {
                copy.setPrQty(sp.getStkPrQty());
            }

            Supplier supObject = original.getSupplier();
            if (supObject != null) {
                copy.setSupplierName(supObject.getSupName());
            }

            newList.add(copy);
        }
        return newList;
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
    public boolean addToStock(StockProduct stockproduct) {
        try {
            if (null == stockproduct
                    || null == stockproduct.getStock()
                    || null == stockproduct.getProduct()) {
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
            if (null == branchProduct
                    || null == branchProduct.getBranch()
                    || null == branchProduct.getProduct()) {
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
            _session.createQuery("delete from Product where prCode= " + prCode).executeUpdate();
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

    @Override
    public List<Brand> getAllBrands() {
        BrandController controller = new BrandController();
        return controller.getAll();
    }

    @Override
    public Stock getStock(int stkCode) {
        List<Stock> stocks = _session.createQuery("From Stock where stkCode = " + stkCode).list();
        if (null == stocks || stocks.isEmpty()) {
            return null;
        }
        Stock original = stocks.get(0);
        Stock copy = new Stock();
        copy.setStkAddress(original.getStkAddress());
        copy.setStkCode(original.getStkCode());
        copy.setStkName(original.getStkName());
        copy.setStkTel(original.getStkTel());
        return copy;
    }

}
