
// Importations
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import java.util.Scanner;
import java.io.Reader;

public class ConnectBDD {

	// Variables permettant la connexion
	static String URL = "jdbc:mysql://localhost:3306/jdbc";
	static String USER = "root";
	static String PASSWORD = "";

	public static void Select(String column, String tabName) {
		Connection conn = null;
		try {
			// Charge la classe du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Créee la connexion
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connexion a la BDD reussie !");
			try {
				// Requete SQL
				String Select = "SELECT usr_id, "+column+" FROM "+tabName+";";
				ResultSet rst;
				java.sql.Statement stmt = conn.createStatement();
				rst = stmt.executeQuery(Select);
				System.out.println("Execution de la requete !");
				while(rst.next()) {
					System.out.println(rst.getString("usr_id") + " " +
							rst.getString("usr_firstname") + " " +
							rst.getString("usr_lastname"));
				}
				// Ferme la connexion
				rst.close();
				stmt.close();
			}
			catch(Exception e) {
				System.out.println(e);
				System.err.println("Erreur de requete !");
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.err.println("Erreur de connexion a la BDD");
		}
	}
	
	public static void Create() {
		Connection conn = null;
		try {
			// Charge la classe du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Créer la connexion
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connexion a la BDD reussie !");
			try {
				String Create = "CREATE TABLE t_created(id INT, name VARCHAR(20));";
				int rst;
				java.sql.Statement stmt = conn.createStatement();
				rst = stmt.executeUpdate(Create);
				System.out.println("Execution de la requete !");

				// Ferme les connexions
				stmt.close();
			} catch (Exception e) {
				System.out.println(e);
				System.err.println("Erreur de requete !");
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Erreur de connexion a la BDD !");
		}
	}

	public static void Insert(String pwd, String firstname, String lastname) {
		Connection conn = null;
		try {
			// Charge la classe du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Créer la connexion
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connexion a la BDD reussie !");
			try {
				String Insert = "INSERT INTO t_users(usr_password, usr_firstname, usr_lastname)"
						+ "VALUE(PASSWORD('"+pwd+"'),"
						+ "'" +firstname+"',"
						+ "'" +lastname+"');";
				int rst;
				java.sql.Statement stmt = conn.createStatement();
				rst = stmt.executeUpdate(Insert);
				System.out.println("Execution de la requete !");

				// Ferme les connexions
				stmt.close();
			} catch (Exception e) {
				System.out.println(e);
				System.err.println("Erreur de requete !");
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Erreur de connexion a la BDD !");
		}
	}
	
	public static void Drop(String tabName) {
		Connection conn = null;
		
		try {
			// Charge la classe du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Créer la connexion
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connexion a la BDD reussie !");
			try {
				// Requete SQL
				String Drop = "DROP TABLE "+tabName+";";
				int rst;
				java.sql.Statement stmt = conn.createStatement();
				rst = stmt.executeUpdate(Drop);
				System.out.println("Execution de la requete !");
				System.out.println("La table " +tabName + " a ete supprime !");
				
				//Ferme la connexion
				stmt.close();
			}
			catch(Exception e) {
				System.out.println(e);
				System.err.println("Erreur de requete !");
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.err.println("Erreur de connexion a la BDD !");
		}
	}
	

	public static void main(String[] args) throws Exception {
		// ConnectBDD.Create();
		// ConnectBDD.Drop("t_created");
		ConnectBDD.Select("usr_firstname, usr_lastname", "t_users");
		//ConnectBDD.Insert("baguette", "Hello", "Bonjour");
	}
}
