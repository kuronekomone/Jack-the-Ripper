<link rel="stylesheet" type="text/css" href="./neptune.css">
<H1>ƒy[ƒW‚Ìˆê——</H1>
<B>
<c:forEach var="wikiPage" items="${list}">
	<c:url value="/refer" var="url">
		<c:param name="name" value="${wikiPage.name}" />
	</c:url>
	<EL><A HREF="${url}">${wikiPage.name}</A><BR>
</c:forEach>
</B>
	
	
