<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js">
 
</head>  
<body>  
        <div><tiles:insertAttribute name="header" /></div>  
        <div><tiles:insertAttribute name="body" /></div>  
        <div style="clear:both"><tiles:insertAttribute name="footer" /></div>  
  
</body>  
</html>