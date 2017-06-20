package cn.edu.nsu.bean;

import java.util.Date;

public class Book {
   private int id;
   private String bookname;
   private String briefIntro;
   private String author;
   private String press;
   private Date presstime;
   private float price;
   private String isbn;
   private int bookcounts;
   private int borrowcounts;
   private int recommend;
   private int category;
   private int inStock;
//   private int c3code;
   private String introduction;
   private String cover;
   
   

public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}

 
   

//public int getC3code() {
//	return c3code;
//}
//public void setC3code(int c3code) {
//	this.c3code = c3code;
//}


public int getInStock() {
   if(getBookcounts()>=getBorrowcounts())
	inStock = getBookcounts() - getBorrowcounts();
   else
	   inStock=0;
	return inStock;
	
}
public void setInStock(int inStock) {
	this.inStock = inStock;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public String getBriefIntro() {
	briefIntro = introduction.substring(0, 30);
	briefIntro=briefIntro+" ...";
	return briefIntro;
}
public void setBriefIntro(String briefIntro) {
	this.briefIntro = briefIntro;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
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
public String getPress() {
	return press;
}
public void setPress(String press) {
	this.press = press;
}
public Date getPresstime() {
	return presstime;
}
public void setPresstime(Date presstime) {
	this.presstime = presstime;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public int getBookcounts() {
	return bookcounts;
}
public void setBookcounts(int bookcounts) {
	this.bookcounts = bookcounts;
}
public int getBorrowcounts() {
	return borrowcounts;
}
public void setBorrowcounts(int borrowcounts) {
	this.borrowcounts = borrowcounts;
}

public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}

public int getRecommend() {
	return recommend;
}
public void setRecommend(int recommend) {
	this.recommend = recommend;
}
}

