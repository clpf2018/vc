/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.Utilities;
import java.sql.*;
/**
 *
 * @author mfaour
 */
public class SqlHelper {
   private final static String JDBC_USER = "mfaour";
   private final static String JDBC_PASSWD = "MfPho0@d";
   private final static String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";
   private final static String JDBC_URL = "jdbc:mysql://35.189.250.88:3306/gestiondesbiens?zeroDateTimeBehavior=convertToNull";
   
   public SqlHelper() throws SQLException
   {
       Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
       CallableStatement stmt = connection.prepareCall("ddd");
         Statement statement = connection.createStatement();
         
   }
}
