<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ page import="WikiPage.java.*" %>

  <link rel="stylesheet" type="text/css" href="./neptune.css">

<body>
<H1>${wikiPage.name}</H1>
<h2>
${wikiPage.formatedContent}<br>
</h2>
<img src="${path}" width="300" height="220" border="0" />
</body>

<br>
<HR>
<C>
<A HREF="update.jsp">このページを更新</A>
</C>