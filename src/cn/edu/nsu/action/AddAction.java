package cn.edu.nsu.action;

import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport {
	private String bookname;
	private String author;
	private int bookcounts;
	private String category;
	private String introduction;
	private String image;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookcounts() {
		return bookcounts;
	}
	public void setBookcounts(int bookcounts) {
		this.bookcounts = bookcounts;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
