package com.antonioalejandro.smkt.files.pdf;

import java.io.ByteArrayOutputStream;

import com.antonioalejandro.smkt.files.pojo.Ingredient;
import com.antonioalejandro.smkt.files.pojo.Recipe;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {
	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

	private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	// private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);

	public byte[] processPdf(final PdfMetadata metadata, final Recipe recipe) throws Exception {
		final Document document = new Document();
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, byteArrayOutputStream);
		document.open();
		addMetadata(metadata, document);
		document.add(createPage(recipe));
		document.close();
		return byteArrayOutputStream.toByteArray();
	}

	public byte[] processPdf(final PdfMetadata metadata, final Recipe[] recipes) throws Exception {
		final Document document = new Document();
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, byteArrayOutputStream);
		document.open();
		addMetadata(metadata, document);
		for (final Recipe recipe : recipes) {
			document.add(createPage(recipe));
		}
		document.close();
		return byteArrayOutputStream.toByteArray();
	}

	private Chapter createPage(final Recipe recipe) {
		final Chunk title = new Chunk(recipe.getTitle(), chapterFont);
		final Paragraph paragraph = new Paragraph(title);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		final Chapter page = new Chapter(paragraph, 1);

		page.setNumberDepth(0);
		page.add(new Paragraph("Time: " + recipe.getTime() + "h", subcategoryFont));
		page.add(new Paragraph("Ingredientes", categoryFont));
		page.add(createListIngredients(recipe));
		page.add(new Paragraph("Pasos", categoryFont));
		page.add(createListInSteps(recipe));
		return page;
	}

	private List createListIngredients(final Recipe recipe) {
		final List list = new List(List.UNORDERED);
		ListItem itemList;
		for (final Ingredient ingredient : recipe.getIngredients()) {
			itemList = new ListItem(ingredient.getName() + " - " + ingredient.getAmount());
			itemList.setAlignment(Element.ALIGN_JUSTIFIED);
			list.add(itemList);
		}
		return list;
	}

	private List createListInSteps(final Recipe recipe) {
		final List list = new List(List.ORDERED);
		ListItem itemList;
		for (final String step : recipe.getSteps()) {
			itemList = new ListItem(step, paragraphFont);
			itemList.setAlignment(Element.ALIGN_JUSTIFIED);
			list.add(itemList);
		}
		return list;
	}

	private void addMetadata(final PdfMetadata metadata, final Document document) {
		document.addTitle(metadata.getTitle());
		document.addAuthor(metadata.getAuthor());
		// keywords
		document.addSubject(metadata.getSubject());
		document.addCreator(metadata.getCreator());
	}
}
