package wiki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikiFormater{
	public String formatText(String text){
		text = escapeHtmlTags(text);
		text = createHyperLink(text);
		text = addBrToEachLines(text);
		return text;
	}
	private String addBrToEachLines(String text){
		text = text.replaceAll("[\n]","<BR>\n");
		return text;
	} 
	private String escapeHtmlTags(String text){
		text = text.replaceAll("<","&lt");
		text = text.replaceAll(">","&gt");
		text = text.replaceAll("\t","  ");
		return text; 
	}
	private String createHyperLink(String text){
		Pattern pattern = Pattern.compile(
			"(mailto|http|https|ftp):\\/\\/([^\\s]+)");
		Matcher matcher = pattern.matcher(text);
		StringBuffer sb = new StringBuffer();
		
		while (matcher.find()){
			String group = matcher.group();
			String repText = "<A HREF=\"" + group + "\">"
			+ group + "</A>";
			
			matcher.appendReplacement(sb,repText);
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
}