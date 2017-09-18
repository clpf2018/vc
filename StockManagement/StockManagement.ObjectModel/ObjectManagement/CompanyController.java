/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.ICompany;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Firas
 */
public class CompanyController implements ICompany {

    private final SessionFactory _sessionFactory;
    private final Session _session;

    public CompanyController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }

    @Override
    public Company get(int compCode) {
        Object objCompany = _session.get(Company.class, compCode);
        if (null == objCompany) {
            return null;
        }
        return (Company) objCompany;
    }

    @Override
    public List<Company> getAll() {
        List<Company> companies = _session.createQuery("From Company").list();
        if (null == companies || companies.isEmpty()) {
            return null;
        }
        return companies;
    }

    @Override
    public int add(Company company) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.save(company);
            tx.commit();
            return company.getCompCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean update(Company company) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.update(company);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(Company company) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.delete("from Company where CompCode= " + company.getCompCode()); 
            //_session.delete(company);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(int compCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Company where CompCode= " + compCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public int addStock(Stock stock) {
        try {
            if (null == stock ) {
                return -1;
            }
            Transaction tx = _session.beginTransaction();
            _session.save(stock);
            tx.commit();
            return stock.getStkCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public int addStock(int compCode, Stock stock) {
        try {
            if (compCode <= 0 || null == stock) {
                return -1;
            }
            Company company = get(compCode);
            if (null == company) {
                return -1;
            }
            stock.setCompany(company);
            Transaction tx = _session.beginTransaction();
            _session.save(stock);
            tx.commit();
            return stock.getStkCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean deleteStock(Stock stock) {
      try {
            Transaction tx = _session.beginTransaction();
            _session.delete(stock);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean deleteStock(int stkCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Stock where StkCode= " + stkCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean updateStock(Stock stock) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.update(stock);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public int addBranch(Branch branch) {
        if (branch.getCompany() == null) {
            return -1;
        }
        BranchController controller = new BranchController();
        return controller.add(branch);
    }

    @Override
    public int addBranch(int compCode, Branch branch) {
        Company company = get(compCode);
        if (null == company) {
            return -1;
        }
        branch.setCompany(company);
        BranchController controller = new BranchController();
        return controller.add(branch);
    }

    @Override
    public boolean deleteBranch(Branch branch) {
        BranchController controller = new BranchController();
        return controller.delete(branch);
    }

    @Override
    public boolean deleteBranch(int brCode) {
        BranchController controller = new BranchController();
        return controller.delete(brCode);
    }

    @Override
    public boolean updateBranch(Branch branch) {
        BranchController controller = new BranchController();
        return controller.update(branch);
    }

    @Override
    public List<Branch> getBranches(Company company) {
        if (null == company) {
            return null;
        }
        List<Branch> branches = _session.createQuery("From Branch where CompCode = " + company.getCompCode()).list();
        if (null == branches || branches.isEmpty()) {
            return null;
        }
        return branches;
    }

    @Override
    public List<Branch> getBranches(int compCode) {
        if (compCode <= 0) {
            return null;
        }
        List<Branch> branches = _session.createQuery("From Branch where CompCode = " + compCode).list();
        if (null == branches || branches.isEmpty()) {
            return null;
        }
        return branches;
    }

    @Override
    public Stock getStock(int compCode) {
       List<Stock> stocks = _session.createQuery("From Stock where CompCode = "+compCode).list();
        if (null == stocks || stocks.isEmpty()) {
            return null;
        }
        return stocks.get(0);
    }

}
