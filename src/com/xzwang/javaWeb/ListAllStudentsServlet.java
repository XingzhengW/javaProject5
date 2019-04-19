package com.xzwang.javaWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: Xingzheng Wang
 * @Date: 4/18/2019 9:56 AM
 * @Description: com.xzwang.javaWeb
 * @Version: 1.0
 */
public class ListAllStudentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.getAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }

}