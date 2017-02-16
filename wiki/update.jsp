<h1>${wikiPage.name}の編集</h1>
<link rel="stylesheet" type="text/css" href="./neptune.css">

<FORM ACTION="update">
	<INPUT TYPE="HIDDEN" NAME="cmd" VALUE="update">
	<INPUT TYPE="HIDDEN" NAME="name" VALUE="${wikiPage.name}">
	
	<TEXTAREA ROWS="15" COLS"60" NAME="content">${wikiPage.name}"</TEXTAREA>
	
	<INPUT TYPE="SUBMIT" VALUE="　更新　">
	<INPUT TYPE="SUBMIT" VALUE="　削除　" ONLICK="cmd.value='delete'">
	<INPUT TYPE="SUBMIT" VALUE="キャンセル">


</FORM>