package org.project.controller;

import org.project.bean.ResultStateBean;
import org.project.bean.StudentBean;
import org.project.dao.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterController (){ super(); }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String nMatricola=request.getParameter("nMatricola");
        String cognome = request.getParameter("cognome");
        String pianoId=request.getParameter("pianoId");
        Date dataNascita = new Date();
                //request.getParameter("dataDiNascita"));
        String email = request.getParameter("email");

        StudentBean studente = new StudentBean(Long.parseLong(nMatricola),nome, cognome, email, dataNascita,Long.parseLong(pianoId));

        RegisterDao registerDao = new RegisterDao();
   //   if(registerDao.authenticateStudent(studente)==true) {
   //   	//mandiamo alla jsp
   //   }
   //   else {
   //   	//ResultStateBean insert=new ResultStateBean();
   //   	registerDao.insertNewStudent();
   //   }
   //
    }

}
