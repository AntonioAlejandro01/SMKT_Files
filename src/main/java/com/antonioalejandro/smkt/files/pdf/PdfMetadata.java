package com.antonioalejandro.smkt.files.pdf;

import java.util.ArrayList;
import java.util.List;

import com.antonioalejandro.smkt.files.utils.Constants;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PdfMetadata {

	private String title;
	private String subject;
	private List<String> keywords;
	private String creator;
	private String author;

	public PdfMetadata(final String title) {
		super();
		this.title = title;
		this.subject = Constants.PDF_METADATA_SUBJECT;
		this.keywords = new ArrayList<>();
		this.creator = Constants.PDF_METADATA_CREATOR;
		this.author = Constants.PDF_METADATA_AUTHOR;
	}

}
