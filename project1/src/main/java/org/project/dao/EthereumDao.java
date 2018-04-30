package org.project.dao;


import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class EthereumDao {


    public static BigDecimal getEth() throws ExecutionException, InterruptedException {
        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/7p5VH9KwAQa4dGwllyZ0"));  // defaults to http://localhost:8545/

        // send asynchronous requests to get balance
        EthGetBalance ethGetBalance = web3
                .ethGetBalance("0x281055Afc982d96fAB65b3a49cAc8b878184Cb16", DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();


        BigDecimal wei2= Convert.fromWei(ethGetBalance.getBalance().toString(), Convert.Unit.ETHER);
        /* System.out.println(wei);*/

        return wei2;


    }



}



