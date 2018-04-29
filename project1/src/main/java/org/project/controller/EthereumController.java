package org.project.controller;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpServlet;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import org.project.dao.EthereumDao;


public class EthereumController extends HttpServlet{
    // connect to node<

    BigInteger wei;

    public BigInteger getWei() {
        return wei;
    }

    public void setWei(BigInteger wei) {
        this.wei = wei;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            /* Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/7p5VH9KwAQa4dGwllyZ0"));  // defaults to http://localhost:8545/

            // send asynchronous requests to get balance
            EthGetBalance ethGetBalance = web3
                    .ethGetBalance("0x281055Afc982d96fAB65b3a49cAc8b878184Cb16", DefaultBlockParameterName.LATEST)
                    .sendAsync()
                    .get();

            this.wei = ethGetBalance.getBalance();*/


            wei = EthereumDao.getEth();
            System.out.println(wei);

            request.setAttribute("wei", wei); // Will be available as ${products} in JSP
            request.getRequestDispatcher("/Wallet.jsp").forward(request, response);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {

        }
    }




}

