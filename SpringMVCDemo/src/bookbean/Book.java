package bookbean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Book implements Serializable {

	private int bookId;
	private String title;
	private String author;
	private double price;

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public Book() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/dbName";
			String uname = "uName";
			String pwd = "uName";
			con = DriverManager.getConnection(dbURL,uname,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
		results();
	}

	public void results() {
		try {
			String sql = "SELECT book_name, isbn, price FROM BOOK WHERE BOOK_ID =?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, bookId);
			rs = pst.executeQuery();
			if (rs.next()) {
				title = rs.getString(1);
				System.out.println(title);
				author = rs.getString(2);
				System.out.println(author);
				price = rs.getDouble(3);
				System.out.println(price);
			}
			System.out.println("Else Condition");
			/*this.author = author;
			this.title = title;
			this.price = price;*/

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
