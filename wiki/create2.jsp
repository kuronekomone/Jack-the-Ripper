<enctype="multipart/form-data" mathod="post">
<link rel="stylesheet" type="text/css" href="./neptune.css">

<h1>${param.name}の作成</h1>

<form action="create" enctype="multipart/form-data">
	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="create">
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${param.name}">
	
	<TEXTAREA ROWS="15" COLS"60" NAME="content"></TEXTAREA>
	<BR>
	
	<INPUT TYPE="SUBMIT" VALUE="　作成　">
	<INPUT TYPE="BUTTON" VALUE="キャンセル"ONCLICK="location.href='refer'">

	<br>
	<A>
	画像ファイル
	<input type="file" name="path">
	</A>
	

</FORM>