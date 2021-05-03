<%@ page import="com.test.jsp.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>test jsp</title></head>
<body>
<%--1 在Jsp文件中直接写Java代码，不会被识别为java代码，被识别成文本--%>
int num1 = 20;
<%--2 在jsp文件中，用标记把java代码用尖括号和百分号包起来，只有这样才能识别java代码，jsp中所有的执行标记都在一个作用域中--%>
<%
    final int n1 = 20;
    final int n2 = n1 + 30;%>
<%--3 在Jsp文件，通过输出标记尖括号百分号等号，通知Jsp将java值写入到响应体--%>
<span>测试jsp：<%=n2%></span>
<%--4 导包--%>
<% final Student s = new Student("小明", 15);%>
<p>
    姓名<%= s.getName() %>
</p>
<%--和html标签混合--%>
<% if (s.getAge() > 20) {%>
<p>年龄大于20</p>
<% } else {%>
<p>年龄小于20</p>
<%}%>
</body>
</html>
