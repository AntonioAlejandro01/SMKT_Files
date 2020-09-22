package com.antonioalejandro.smkt.files.pdf;

import java.util.ArrayList;
import java.util.List;

public class PdfMetadata {

	private String title;
	private String subject;
	private List<String> keywords;
	private String creator;
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(final List<String> keywords) {
		this.keywords = keywords;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(final String creator) {
		this.creator = creator;
	}

	public PdfMetadata(final String title) {
		super();
		this.title = title;
		this.subject = "FOOD";
		this.keywords = new ArrayList<String>();
		this.creator = "haas.ms.files-server";
		this.author = "com.antonioalejandro.haas.filesserver.pdf";
	}

}
