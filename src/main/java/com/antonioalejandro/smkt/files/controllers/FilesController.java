package com.antonioalejandro.smkt.files.controllers;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.antonioalejandro.smkt.files.pdf.Pdf;
import com.antonioalejandro.smkt.files.pdf.PdfMetadata;
import com.antonioalejandro.smkt.files.pojo.Product;
import com.antonioalejandro.smkt.files.pojo.Recipe;
import com.antonioalejandro.utils.excel.ExcelBook;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/files")
public class FilesController {
	@Autowired
	private Pdf pdfCreator;
	@Autowired
	@Qualifier("header")
	private Color ExcelColor;
	@Autowired
	@Qualifier("data")
	private Color ExcelColorData;
	// @Autowired
	// private EurekaClient eurekaClient;

	private static final Logger log = Logger.getLogger(FilesController.class.getName());

	@PostMapping(value = "/excel", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public ResponseEntity<byte[]> getExcel(@RequestBody final List<Product> products) {
		log.log(Level.INFO, "Call /excel");
		final ExcelBook<Product> excel = new ExcelBook<>("Productos");
		excel.setBlankSheet();
		excel.setHeaders(Product.getHeaders());
		excel.setData(products);
		excel.setHeaderColor(ExcelColor);
		excel.setDataColor(ExcelColorData);
		try {
			return new ResponseEntity<byte[]>(excel.prepareToSend(), HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> getPdf(@RequestBody final Recipe recipe) {
		log.log(Level.INFO, "Call /pdf");
		byte[] pdf;
		try {
			pdf = pdfCreator.processPdf(new PdfMetadata("Receta " + recipe.getTitle()), recipe);
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<byte[]>(pdf, HttpStatus.OK);
	}

	@PostMapping(value = "/pdf/all", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> getPdfAll(@RequestBody final Recipe[] recipes) {
		log.log(Level.INFO, "Call /pdf/all");

		byte[] pdf;
		try {
			pdf = pdfCreator.processPdf(new PdfMetadata("COOKBOOK"), recipes);
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<byte[]>(pdf, HttpStatus.OK);
	}
}
