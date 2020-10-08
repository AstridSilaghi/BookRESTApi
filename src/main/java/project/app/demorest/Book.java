package project.app.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private int id;
	private String title;
	private String author;
	private float score;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "id = " + id + " title = " +  title + " author = " + author + "score = " + score;
		
	}
}
