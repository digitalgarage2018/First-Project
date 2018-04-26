package org.project.dao;

import org.project.bean.WalletBean;

import static org.project.util.DBController.*;

import java.sql.SQLException;

public class WalletDao {

	// === Costanti letterali per non sbagliarsi a scrivere !!! ============================

	static final String TABLE = "Wallet";

	// -------------------------------------------------------------------------------------

	//	static final String ID = "id"; per ora non la uso	
	static final String ID_USER = "id_user";
	static final String CREDIT = "credit";



	// == STATEMENT SQL ====================================================================

	//query di ricerca
	static String SELECT_BY_ID = 
			"SELECT * " +
					"FROM " + TABLE + " " +
					"WHERE " + ID_USER + " = ? "
					;

	//query di insierimento
	// INSERT INTO table (...) VALUES ( ?,?, ... );
	private	static final String INSERT = 
			"INSERT " +
					"INTO " + TABLE + " ( " + 
					ID_USER +","+
					CREDIT +""+
					") " +
					"VALUES (?,?) "
					;//insert



	// == Metodi CRUD ====================================================================


	/*
	 * se passato un corretto user crea una nuova tupla
	 * di user nel db
	 */
	public void createWallet(WalletBean wallet)
	{
		// --- 1. Dichiarazione della variabile per il risultato ---

		// --- 2. Controlli preliminari sui dati in ingresso ---
		if ( wallet == null )  {
			System.out.println("create(): failed to insert a null entry");
			return;
		}


		try {
			// --- 3. connessione gia aperta da DB controller
			// --- 4. Tentativo di accesso al db e impostazione del risultato ---
			if(connectDB(INSERT)) {
				// --- Pulizia e impostazione dei parametri (se ve ne sono)
				stmt.clearParameters();
				stmt.setInt(1, wallet.getIdUser());
				stmt.setDouble(2, wallet.getCredit());
				
				// --- Esegui l'azione sul database ed estrai il risultato (se atteso)
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

	// ==================================================================================


	
	public WalletBean readByIdUser(int idUser){
		// --- 1. Dichiarazione della variabile per il risultato ---
		WalletBean result=null;

		// --- 2. Controlli preliminari sui dati in ingresso ---
		if ( idUser < 0 )  {
			System.out.println("read(): invalid arguments");
			return null;
		}

		try {
			// --- 3. connessione gia aperta da DB controller
			// --- 4. Tentativo di accesso al db e impostazione del risultato ---
			if(connectDB(SELECT_BY_ID)) {
				// --- Pulizia e impostazione dei parametri (se ve ne sono)
				stmt.clearParameters();
				stmt.setInt(1, idUser);

				// --- Esegui l'azione sul database ed estrai il risultato (se atteso)
				rs = stmt.executeQuery();
				// --- Cicla sul risultato (se presente) pe accedere ai valori di ogni sua tupla
				// if in quanto mi aspetto username chiave per ora
				if (rs.next()) {

					WalletBean entry = new WalletBean(
							rs.getInt(ID_USER),
							rs.getDouble(CREDIT)
							);
					
					result = entry;
					
					disconnectDB();
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
