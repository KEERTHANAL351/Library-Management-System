package librarymanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import librarymanagementsystem.model.Book;
import librarymanagementsystem.util.DBConnection;

public class BookDAO {
	 public void addBook(Book book) {
	        try {
	            Connection conn = DBConnection.getConnection();
	            String sql = "INSERT INTO books (title, author, publisher, available_copies) VALUES (?, ?, ?, ?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, book.getTitle());
	            ps.setString(2, book.getAuthor());
	            ps.setString(3, book.getPublisher());
	            ps.setInt(4, book.getAvailableCopies());
	            ps.executeUpdate();
	            conn.close();
	            System.out.println("Book added successfully!");
	        } catch (Exception e) {
	            System.out.println("Error adding book: " + e.getMessage());
	        }
	    }

	    public List<Book> getAllBooks() {
	        List<Book> list = new ArrayList<Book>();
	        try {
	            Connection conn = DBConnection.getConnection();
	            String sql = "SELECT * FROM books";
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery(sql);

	            while (rs.next()) {
	                Book b = new Book();
	                b.setId(rs.getInt("id"));
	                b.setTitle(rs.getString("title"));
	                b.setAuthor(rs.getString("author"));
	                b.setPublisher(rs.getString("publisher"));
	                b.setAvailableCopies(rs.getInt("available_copies"));
	                list.add(b);
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.out.println("Error fetching books: " + e.getMessage());
	        }
	        return list;
	    }

}
