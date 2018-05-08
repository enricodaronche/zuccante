/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrico.daronche
 */
public class DButil {

	private static final Logger LOGGER = Logger.getLogger(DButil.class.getName());
	static final String NOME_CLASSE_DRIVER_DB = "org.sqlite.JDBC"; // deve essere presente nelle Libraries
	static final String DRIVER_DB = "jdbc:sqlite:";
	static final String PATH_DB = "C:\\Users\\Enrico\\Desktop\\Quinta\\Informatica\\WebServiceSocialZ\\";
	static final String NOME_DB = "SocialZ.db";
	static final String USER_DB = "";
	static final String PWD_DB = "";
	static final String URL_DB = DRIVER_DB + PATH_DB + NOME_DB;

	static Connection conn = null;

	public static Connection getConnection() { // Design Pattern SINGLETON 
		if (conn == null) {
			try {
				// Class.forName() implicitamente carica a run-time il driver
				// del database utilizzato
				Class.forName(NOME_CLASSE_DRIVER_DB);
				conn = DriverManager.getConnection(URL_DB, USER_DB, PWD_DB);
			} catch (ClassNotFoundException | SQLException ex) {
				LOGGER.log(Level.SEVERE, ex.toString(), ex);
			}
		}
		return conn;
	}

	public static ArrayList<String> getHobbies(){
		ArrayList<String>ris=new ArrayList<>();
		String query="SELECT Nome FROM HOBBY";
		try {
			PreparedStatement ps=getConnection().prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())ris.add(rs.getString("Nome"));
		} catch (SQLException ex) {
			Logger.getLogger(DButil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ris;
	}
	
	public static ArrayList<String> getPraticanti(String nomeHobby){
		ArrayList<String>ris=new ArrayList<>();
		String query="SELECT Email FROM UTENTE,PREFERENZA,HOBBY WHERE HOBBY.Nome=? AND Hobby.IdHobby=PREFERENZA.IdHobby AND PREFERENZA.IdUtente=UTENTE.IdUtente";
		try {
			PreparedStatement ps=getConnection().prepareStatement(query);
			ps.setString(1, nomeHobby);
			ResultSet rs=ps.executeQuery();
			while(rs.next())ris.add(rs.getString("Email"));
		} catch (SQLException ex) {
			Logger.getLogger(DButil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return ris;
	}

}
