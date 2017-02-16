package wiki;

import java.sql.Timestamp;

public class WikiPage{
	private String name;
	private String content;
	private Timestamp updateTime;
	private String path;
	
	public String getFormatedContent(){
		WikiFormater formater = new WikiFormater();
		return formater.formatText(content);
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Timestamp getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
	public String getPath(){
		return path;
	}
	public void setPath(String path){
		this.path = path;
		System.out.println("wppath1="+path);
	}
}