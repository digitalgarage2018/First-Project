/*
 ============================================================================
 Name        : UserDao.java
 Author      : Alessio Onori
 Version     : 1.0
 Copyright   : Your copyright notice
 Description : Dao per il bean User
 ============================================================================
 */

package org.project.dao;

import org.project.bean.UserBean;

import static org.project.util.DBController.*;

import java.sql.SQLException;

public class UserDao {

	// === Costanti letterali per non sbagliarsi a scrivere !!! ============================

	static final String TABLE = "User";

	// -------------------------------------------------------------------------------------

	//	static final String ID = "id"; per ora non la uso	
	static final String ID = "id";
	static final String USERNAME = "username";
	static final String PASSWORD = "password";



	// == STATEMENT SQL ====================================================================

	//query di ricerca
	static String SELECT_BY_USER_PASS = 
			"SELECT * " +
					"FROM " + TABLE + " " +
					"WHERE " + USERNAME + " = ? "+
					"AND " + PASSWORD + " = ?"
					;

	//query di ricerca
	static String SELECT_BY_USERNAME = 
			"SELECT * " +
					"FROM " + TABLE + " " +
					"WHERE " + USERNAME + " = ? "
					;

	//query di insierimento
	// INSERT INTO table (...) VALUES ( ?,?, ... );
	private	static final String INSERT = 
			"INSERT " +
					"INTO " + TABLE + " ( " + 
					USERNAME +", "+
					PASSWORD +""+
					") " +
					"VALUES (?,?) "
					;//insert
	/*
	 * id è autogestito
	 */



	// == Metodi CRUD ====================================================================


	/*
	 * se passato un corretto user crea una nuova tupla
	 * di user nel db
	 */
	public void createUser(UserBean userBean)
	{
		// --- 1. Dichiarazione della variabile per il risultato ---

		// --- 2. Controlli preliminari sui dati in ingresso ---
		if ( userBean == null )  {
			System.out.println("create(): failed to insert a null entry");
			return;
		}


		try {
			// --- 3. connessione gia aperta da DB controller
			// --- 4. Tentativo di accesso al db e impostazione del risultato ---
			if(connectDB(INSERT)) {
				// --- Pulizia e impostazione dei parametri (se ve ne sono)
				stmt.clearParameters();
				//id impostato da auto increment
				stmt.setString(1, userBean.getUsername());
				stmt.setString(2, userBean.getPassword());

				// --- Esegui l'azione sul database ed estrai il risultato (se atteso)
				stmt.executeUpdate();

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			//--- gestione del rilascio delle risorse
			disconnectDB();
		}
		
		
		/*
		 * prima soluzione abbozzata: mi serve ottenere l'id appena auto generato
		 */
		try {
			// --- 3. connessione gia aperta da DB controller
			// --- 4. Tentativo di accesso al db e impostazione del risultato ---
			if(connectDB(SELECT_BY_USERNAME)) {
				// --- Pulizia e impostazione dei parametri (se ve ne sono)
				stmt.clearParameters();
				stmt.setString(1, userBean.getUsername());

				// --- Esegui l'azione sul database ed estrai il risultato (se atteso)
				rs = stmt.executeQuery();
				// --- Cicla sul risultato (se presente) pe accedere ai valori di ogni sua tupla
				// if in quanto mi aspetto username chiave per ora
				if (rs.next()) {
					userBean.setId(rs.getInt(ID));
				} 
				else {
					disconnectDB();
					return;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		
		return;
	}

	// ==================================================================================



	/*
	 * metodo per l'autenticazione, interroga il db e ritorna una stringa 
	 * con il risultato dell'interrogazione
	 */
	public UserBean authenticateUser(String username, String password){
		// --- 1. Dichiarazione della variabile per il risultato ---
		UserBean result=null;

		// --- 2. Controlli preliminari sui dati in ingresso ---
		if ( username.equals("") || password.equals("") )  {
			System.out.println("read(): invalid arguments");
			return null;
		}

		try {
			// --- 3. connessione gia aperta da DB controller
			// --- 4. Tentativo di accesso al db e impostazione del risultato ---
			if(connectDB(SELECT_BY_USERNAME)) {
				// --- Pulizia e impostazione dei parametri (se ve ne sono)
				stmt.clearParameters();
				stmt.setString(1, username);

				// --- Esegui l'azione sul database ed estrai il risultato (se atteso)
				rs = stmt.executeQuery();
				// --- Cicla sul risultato (se presente) pe accedere ai valori di ogni sua tupla
				// if in quanto mi aspetto username chiave per ora
				if (rs.next()) {
					/*
					 * meccanismo di autenticazione gia all atto dell interrogazione DB, non a carico del controller 
					 */
					if(username.equals(rs.getString(USERNAME)) && password.equals(rs.getString(PASSWORD))){
						//ret= "success"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
						result = new UserBean(
								rs.getInt(ID),
								rs.getString(USERNAME),
								rs.getString(PASSWORD)
								);	
					}
					
					disconnectDB();
					return result;
				} 
				else {
					disconnectDB();
					return null;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		
		return result;
	}

	
	
}
