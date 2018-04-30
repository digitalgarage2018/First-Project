package org.project.service;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

import org.project.dao.EthereumDao;
import org.web3j.utils.Convert;
import java.math.BigInteger;

public class EthereumService {
	
	 
	
	
	
	public BigDecimal getEthValue() {
		 BigInteger wei = null;
		 BigDecimal wei2= null;
		 EthereumDao ethereumDao = new EthereumDao();	 
		 try{
			 wei = ethereumDao.getEth();
			 wei2= Convert.fromWei(wei.toString(), Convert.Unit.ETHER);
			 
		 } 
		 catch (InterruptedException e){
			 System.out.println("errore interr: "+e);
		 } catch (ExecutionException e){
			 System.out.println("errore exec: "+e);
		 }
		 /*catch (InterruptedException|ExecutionException e) {
         e.printStackTrace();
  			} */ 
		 finally {
	    	 
	     }
		return wei2;		 
	 }
	
}
