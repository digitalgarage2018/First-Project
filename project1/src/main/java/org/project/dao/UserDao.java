package org.project.dao;

import org.project.bean.UserBean;

import static org.project.util.DBController.*;

import java.sql.SQLException;

public class UserDao {

	// === Costanti letterali per non sbagliarsi a scrivere !!! ============================

	static final String TABLE = "User";

	// -------------------------------------------------------------------------------------

//	static final String ID = "id"; per ora non la uso	
	static final String USERNAME = "username";
	static final String PASSWORD = "password";

	
	
	// == STATEMENT SQL ====================================================================

	private static final String SELECT_BY_USERNAME = "SELECT * FROM "+TABLE+" WHERE username=?";

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
	 * andrebbe aggiornato con un valore ID
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
				stmt.setString(1, userBean.getUsername());
				stmt.setString(2, userBean.getPassword());

				// --- Esegui l'azione sul database ed estrai il risultato (se atteso)
				//				rs = stmt.executeQuery(); //va bene o meglio executeUpdate?
				stmt.executeUpdate();

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			//--- gestione del rilascio delle risorse
			disconnectDB();
		}
		return;
	}
	
	
	// =====================================================================


	
	/*
	 * metodo per l'autenticazione, interroga il db e ritorna una stringa 
	 * con il risultato dell'interrogazione
	 */
	public String authenticateUser(UserBean userBean)
	{
		String ret="";
		try {

			if(connectDB(SELECT_BY_USERNAME)) {
				stmt.setString(1, userBean.getUsername());
				rs = stmt.executeQuery();

				if (rs.next()) {
					if(userBean.getUsername().equals(rs.getString(1)) && userBean.getPassword().equals(rs.getString(2))){
						ret= "success"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
					}else{
						ret= "failure";
					}
					disconnectDB();
					return ret;
				} else {
					disconnectDB();
					return "failure";
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			disconnectDB();
		}
		return "failure";
	}

}
