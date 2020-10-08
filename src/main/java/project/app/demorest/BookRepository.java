package project.app.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class BookRepository {

	Connection conn = null;
	
	public BookRepository() {
		
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
		
	}
	
	public List<Book> getBooks(){
		List<Book> books = new ArrayList<Book>();
		String sql = "select * from books";

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setScore(rs.getFloat(4));
				books.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	public Book getBook(String title) {
		Book b = new Book();
		String sql = "select * from books where title='" + title + "'";

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setScore(rs.getFloat(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	public Book getBookId(int id) {
		Book b = new Book();
		String sql = "select * from books where idbooks=" + id;
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setScore(rs.getFloat("score"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	public void createBook(Book newBook) {
		
		String sql = "insert into books values (?,?,?,?)";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, newBook.getId());
			st.setString(2, newBook.getTitle());
			st.setString(3, newBook.getAuthor());
			st.setFloat(4, newBook.getScore());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Book newBook) {
		
		String sql = "update books set score=? where title=?";

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setFloat(1, newBook.getScore());
			st.setString(2, newBook.getTitle());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String title) {
		String sql = "delete from books where title=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, title);
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
