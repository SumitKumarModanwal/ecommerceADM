package com.cts.adminservice.entity;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	@Column(unique = true, nullable = false)
	private String isbn;
	@Column(nullable = false)
	private String bookName;
	@Column(nullable = false)
	private String author;
	@Column(nullable = false)
	private String publication;
	@Column(nullable = false)
	private String description;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;
	@Column(nullable = false)
	private Integer price;
	@Column(nullable = false)
	private Integer stock;
	@Lob
	private Blob image;
	
	public Book() {}
	
	
	public Book(Long bookId, String iSBN, String bookName, String author, String publication, String description,
			Category category, Integer price, Integer stock, Blob image) {
		super();
		this.bookId = bookId;
		isbn = isbn;
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.description = description;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}


	public Long getBookId() {
		return bookId;
	}


	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublication() {
		return publication;
	}


	public void setPublication(String publication) {
		this.publication = publication;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public Blob getImage() {
		return image;
	}


	public void setImage(Blob image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", ISBN=" + isbn + ", bookName=" + bookName + ", author=" + author
				+ ", publication=" + publication + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", stock=" + stock + ", image=" + image + "]";
	}
	
	
	
}
