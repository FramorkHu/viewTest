<%@ page contentType="text/html; charset=gb2312" language="java" import="java.io.*" errorPage="error.jsp" %>
<html>
<head>
    <title>自定义的错误页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
</head>
<body marginwidth="0" leftmargin="0" bgcolor="ffffff">
<table width="90%">
    <tbody>
    <tr>
        <td colspan="2" width="98%">
            发生错误,错误信息如下
            <hr>
        </td>
    </tr>
    <tr>
        <td width="20%"></td>
        <td></td>
    </tr>
    <tr>
        <td>
            错误码：
        </td>
        <td><%=request.getAttribute("javax.servlet.error.status_code")%> <br>
        </td>
    </tr>
    <tr>
        <td>
            界面：
        </td>
        <td><%=request.getAttribute("javax.servlet.error.request_uri")%> <br>
        </td>
    </tr>
    <tr>
        <td> 信息：
        <td><%=request.getAttribute("javax.servlet.error.message")%> <br>
        </td>
    </tr>
    <tr>
        <td>异常：
        <td><%=request.getAttribute("javax.servlet.error.exception_type")%> <br>
        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <br>
            <br>
            <% StackTraceElement[] stackElmts = ((Exception) request.getAttribute("javax.servlet.error.exception")).getStackTrace();
                for (StackTraceElement elmt : stackElmts) {
                    PrintWriter pw = new java.io.PrintWriter(out);
                    pw.append(elmt.toString());
                    pw.append("<br/>");
                }%>
        </td>
    </tr>

    </TBODY>
</TABLE>
</body>
</html> 