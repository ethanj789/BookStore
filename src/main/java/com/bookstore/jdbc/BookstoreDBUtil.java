package com.bookstore.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BookstoreDBUtil {
	private DataSource dataSource;
	
	public BookstoreDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Book> getBooks() throws Exception {
		List<Book> rtn = new ArrayList<>();	
		
		Connection conn = null;
		ResultSet result = null;
		Statement statement = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from books";
			statement = conn.createStatement();
			result = statement.executeQuery(sql);
			
			while(result.next()) {
				Book add = new Book(result.getString("author"),result.getString("title"),result.getInt("id"),result.getDouble("price"));
				rtn.add(add);
			}
			return rtn;
		} finally {
			close(conn, result, statement);
		}		
	}

	private void close(Connection conn, ResultSet result, Statement statement) {
		// TODO Auto-generated method stub
		try {
			if (result != null) {
				result.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (statement!= null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into books (title, author, price) values (?,?,?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setDouble(3, book.getPrice());
			statement.execute();
		} finally {
			close(conn, null, statement);
		}		
	
	}

	public Book getBook(String id) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from books where id = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(id));
			result = statement.executeQuery();
			if (result.next()) {
				return new Book(result.getString("author"),result.getString("title"),result.getInt("id"),result.getDouble("price"));
			} else {
				return null;
			}
		} finally {
			close(conn, result, statement);
		}		

	}

	public void updateBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update books set title = ?, author = ?, price = ? where id = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setDouble(3, book.getPrice());
			statement.setDouble(4, book.getId());
			statement.execute();
		} finally {
			close(conn, null, statement);
		}		

	}

	public void deleteBook(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "delete from books where id = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} finally {
			close(conn, null, statement);
		}		

	}
	
	
	
}
