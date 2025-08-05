package com.dao;

import com.bean.Product;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDao {
    public Product getProductByCode(String code) throws Exception {
        Connection con = DBUtil.getConnection();
        String query = "SELECT * FROM product WHERE product_code = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, code);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Product(
                rs.getString("product_code"),
                rs.getString("product_name"),
                rs.getString("product_category"),
                rs.getDouble("product_price"),
                rs.getInt("product_quantity")
            );
        } else {
            throw new Exception("Product with code " + code + " not found.");
        }
    }
}
