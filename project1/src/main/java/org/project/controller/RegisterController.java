package org.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.StudentBean;
import org.project.dao.RegisterDao;

public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static Long newBadgeNumber;

    public RegisterController() {
        super();
    }
    
    @Override
    public void init() throws ServletException
    {
        newBadgeNumber = RegisterDao.getMaxBadgeNumber() + 1;
        
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String personalEmail = request.getParameter("personalEmail");
        String password = request.getParameter("password");

        Date dateOfBirthFormat = new Date();
        String dateOfBirth = request.getParameter("dateOfBirth");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            dateOfBirthFormat = sdf.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StudentBean student = new StudentBean(0, name, surname, personalEmail, "", dateOfBirthFormat);

        RegisterDao registerDao = new RegisterDao();

        RequestDispatcher rd = null;

        if (registerDao.authenticateStudent(student)) {
            // inserire avviso per giustificare il login
            rd = request.getRequestDispatcher("/WEB-INF/index.jsp");

        } else {
            String istitutionalEmail = generateIstEmail(name, surname);

            long studentID;
            synchronized (newBadgeNumber) {
                studentID = newBadgeNumber++;
            }
            student.setBadgeNumber(studentID);

            student.setIstitutionalEmail(istitutionalEmail);

            boolean inserito = registerDao.insertNewStudent(student);

            if(!inserito) {
                registerDao.insertLogin(student,password);
                rd = request.getRequestDispatcher("/WEB-INF/view/success.jsp");
                request.setAttribute("newStudent", student);
            }
        }

        rd.forward(request, response);

    }

    private String generateIstEmail(String nome, String cognome) {
        String sm = "";
        if (nome.length() < 3) {
            sm = nome + "." + cognome + "@studenti.unimarina.it";
        } else {
            sm = nome.substring(0, 2) + "." + cognome + "@studenti.unimarina.it";
        }
        return sm;
    }
}
