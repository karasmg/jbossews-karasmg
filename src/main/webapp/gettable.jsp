<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ page import="jbossews.model.*" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
</head>
<body>
<%String[][] sdf;%>
<%DaoFactory conn = new MySqlDaoFactory();%>
<%		Connection db = null;%>
<%		try {%>
	<%			db = conn.getConnection();%>
	<%		} catch (SQLException e) {%>
		<%			// TODO Auto-generated catch block%>
		<%			e.printStackTrace();%>
		<%		}%>
<%		UserDao Ud = conn.getUserDao(db);%>
<%		List<User> lst = new ArrayList<User>();%>
<%		try {%>
	<%			lst = Ud.getAll();%>
	<%		} catch (SQLException e) {%>
		<%			// TODO Auto-generated catch block%>
		<%			e.printStackTrace();%>
		<%		}%>
	<table>
	<%for(User m : lst){%>
	<tr>
	<td><%=m.getName()%></td>
	<td><%=m.getCountry()%></td>
	<td><%=m.getCity()%></td>
	<td><%=m.getAddress()%></td>
	</tr>
	<%	}%>
	
	</table>
</body>
</html>