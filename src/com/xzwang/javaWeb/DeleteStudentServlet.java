package com.xzwang.javaWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Xingzheng Wang
 * @Date: 4/19/2019 9:51 AM
 * @Description: com.xzwang.javaWeb
 * @Version: 1.0
 */
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flowId = request.getParameter("flowId");
        StudentDao studentDao = new StudentDao();
        studentDao.deleteByFlowId(Integer.parseInt(flowId));
        request.getRequestDispatcher("/success.jsp").forward(request, response);
    }
}
