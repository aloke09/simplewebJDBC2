package com.example.simplewebJDBC2.repository;

import com.example.simplewebJDBC2.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Operation_using_JDBC
{
    static List<Product> p=new ArrayList<>();


//    public static boolean contains(int id) throws SQLException {
//        Connection con =DB_Connection.getCon();
//        PreparedStatement ps = con.prepareStatement("select * from product where productid=?");
//        ps.setInt(1,id);
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()) {
//            if (rs.getInt(1) == id) {
//                return true;
//            }
//        }
//        return false;
//    }
    public static List<Product> getAllProduct()
    {
        try
        {
            Connection con =DB_Connection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Product pro=new Product();
                pro.setProductId(rs.getInt(1));
                pro.setProductName(rs.getString(2));
                pro.setPrice(rs.getInt(3));
                p.add(pro);

                System.out.println(rs.getInt(1)+"   "+
                rs.getString(2)+"   "+
                rs.getInt(3));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return p;
    }

    public static Product getByID(int pID)
    {
        Product pobj=new Product();
        try
        {
            Connection con =DB_Connection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from product where productid=?");
            ps.setInt(1,pID);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(rs.getInt(1)==pID)
                {
                    pobj.setProductId(rs.getInt(1));
                    pobj.setProductName(rs.getString(2));
                    pobj.setPrice(rs.getInt(3));


                    System.out.println(rs.getInt(1)+"   "+
                            rs.getString(2)+"   "+
                            rs.getInt(3));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return pobj;
    }

    public static void InsertProduct(Product product)
    {
        try
        {
            Connection con =DB_Connection.getCon();
            PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?)");
            ps.setInt(1,product.getProductId());
            ps.setString(2,product.getProductName());
            ps.setInt(3,product.getPrice());
            int r = ps.executeUpdate();
            if(r>0)
            {
                System.out.println("product data inserted successfully!!!");
            }
            else
            {
                System.err.println("product data not inserted successfully!!!");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void updateByProductID(Product prod)
    {
        try
        {
            Connection con=DB_Connection.getCon();
            PreparedStatement ps = con.prepareStatement("update product set product_name=? ,product_price=? where productid=?");
            ps.setString(1,prod.getProductName());
            ps.setInt(2,prod.getPrice());
            ps.setInt(3,prod.getProductId());
            int r = ps.executeUpdate();
            if(r>0)
            {
                System.out.println("data updated successfully!!");
            }
            else {
                System.out.println("not updated");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteByProductID(int id)
    {
        try
        {
            Connection con= DB_Connection.getCon();
            PreparedStatement ps = con.prepareStatement("delete from product where productid=?");
            System.out.println("ASDF");
            ps.setInt(1,id);
            int r = ps.executeUpdate();
            System.out.println(r);
            if(r>0)
            {
                System.out.println("data deleted successfully!!");
            }
            else
            {
                System.out.println("data not deleted");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
