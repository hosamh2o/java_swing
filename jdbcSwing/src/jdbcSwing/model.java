package jdbcSwing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class model {

	private dbconnection connObj = new dbconnection();
	private jdbcfram viewObj;
	private Statement stmt = null;
	PreparedStatement pstmt;
	private String sql = "";
	private ResultSet result = null;
	public void inserAll(String nom,String prenom,int age,String ville) throws SQLException {
	 pstmt = connObj.connect().prepareStatement("INSERT INTO etudiantb(nom, prenom, age, vill,) VALUES (?, ?, ?, ?)");

		pstmt.setString(1, nom);
		pstmt.setString(2, prenom);
		pstmt.setInt(3, age);
		pstmt.setString(4, ville);
		
		pstmt.executeUpdate();
		
	}

	public Vector<Vector<String>> selectAll() throws SQLException {
		Vector<Vector<String>> doublevector = new Vector<Vector<String>>();
		stmt = connObj.connect().createStatement();
		result=stmt.executeQuery("SELECT * FROM etudiantb");
		while(result.next())
		{
		Vector<String> singlevector = new Vector<String>();
		singlevector.add(result.getString("id")); 
		singlevector.add(result.getString("nom")); 
		singlevector.add(result.getString("prenom")); 
		singlevector.add(result.getString("age")); 
		singlevector.add(result.getString("ville")); 
		
		doublevector.add(singlevector);

		}

		return doublevector;
	}

//	public double getDiscountTotal() {
//		return discountTotal;
//	}
//
//	void calculDiscount(double total) {
//		this.discountTotal = total * 0.9;
//		this.discount = total - discountTotal;
//
//	}

	
}
