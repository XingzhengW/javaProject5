<%@ page import="java.util.List" %>
<%@ page import="com.xzwang.javaWeb.Student" %><%--
  Created by IntelliJ IDEA.
  User: Xingzheng Wang
  Date: 4/18/2019
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<%
    List<Student> stus = (List<Student>)request.getAttribute("students");
%>

<table border="1" cellpadding="10" cellspacing="0">

    <tr>
        <th>FlowId</th>
        <th>Type</th>
        <th>IdCard</th>
        <th>ExamCard</th>
        <th>StudentName</th>
        <th>Location</th>
        <th>Grade</th>
        <th>Delete</th>
    </tr>

    <%
        for(Student student: stus){
    %>
    <tr>
        <td><%= student.getFlowId() %></td>
        <td><%= student.getType() %></td>
        <td><%= student.getIdCard() %></td>
        <td><%= student.getExamCard() %></td>
        <td><%= student.getStudentName() %></td>
        <td><%= student.getLocation() %></td>
        <td><%= student.getGrade() %></td>
        <td><a href="deleteStudent?flowId=<%=student.getFlowId() %>">Delete</a></td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
