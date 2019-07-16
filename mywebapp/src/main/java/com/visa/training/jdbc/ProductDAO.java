package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
//CRUD methods
	
	public int save(Product p) throws SQLException {//perform an insert
		//getconnection
		
		int genId=0;
		//Statement s = c.createStatement();
		try (Connection c = JdbcUtil.getConnection()){
		//String sql ="INSERT INTO product "+ "VALUES "+"(" + Integer.toString(p.id)+","+ "'"+p.name+"'"+","+ Double.toString(p.price)+","+ Integer.toString(p.qoh)+")";
		String pSql = "insert into product(product_name,product_price,product_qoh) values(?,?,?)";
		//doing this because the person might not know the id number , so auto increment using this syntax
		
		
		
		PreparedStatement ps =c.prepareStatement(pSql, Statement.RETURN_GENERATED_KEYS);
		
		//ps.setInt(1, p.id);
		ps.setString(1,p.getName());
		ps.setDouble(2, p.getPrice());
		ps.setInt(3, p.getQoh());
		ps.executeUpdate();
		
		ResultSet res = ps.getGeneratedKeys();
		res.next();
		genId = res.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		//trRRRRRRRRRy
		//string sql.insert into product values
		//catch(Sql)
		return genId;
	}
	public Product findbyId(int id) throws SQLException {
		//fetch product by id
		Product p=null;// can make it optional
		
		try(Connection c = JdbcUtil.getConnection()) {
			
			PreparedStatement s = c.prepareStatement("select * from product where product_id=?");
			s.setInt(1,id);
			ResultSet res = s.executeQuery();
			if(res.next()) {
				p = mapRow(res);
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	private Product mapRow(ResultSet res) throws SQLException {
		Product p;
		p = new Product();
		p.setId(res.getInt(1));
		p.setName(res.getString(2));
		p.setPrice(res.getFloat(3));
		p.setQoh(res.getInt(4));
		return p;
	}
	
	public List<Product> findAll(){
		//read all
		List<Product> lsp = new ArrayList<>();
		try(Connection c = JdbcUtil.getConnection()){
			Statement s = c.createStatement();
			ResultSet res= s.executeQuery("select * from product");
			while(res.next()) {
				Product ad = mapRow(res);
				lsp.add(ad);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lsp;
	}
	public void remove(int id) {
		
		
		try(Connection c = JdbcUtil.getConnection()) {
			
			PreparedStatement s = c.prepareStatement("delete from product where product_id=?");
			s.setInt(1,id);
			s.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(Product t) {
		//update
			try(Connection c = JdbcUtil.getConnection()) {
			
			PreparedStatement s = c.prepareStatement("update product set product_name = ?,product_price = ? where product_id=?");
			s.setString(1,t.getName());
			s.setDouble(2,t.getPrice());
			s.setInt(3, t.getId());
			
			s.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
