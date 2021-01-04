/*
 * @Author AntonioAlejandro01
 * 
 * @link http://antonioalejandro.com
 * @link https://github.com/AntonioAlejandro01/SMKT_Users
 * 
 */
package com.antonioalejandro.smkt.files.controllers;

import java.awt.Color;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antonioalejandro.smkt.files.pdf.Pdf;
import com.antonioalejandro.smkt.files.pdf.PdfMetadata;
import com.antonioalejandro.smkt.files.pojo.Product;
import com.antonioalejandro.smkt.files.pojo.Recipe;
import com.antonioalejandro.utils.excel.ExcelBook;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/files")
public class FilesController {

	/** The pdf creator. */
	@Autowired
	private Pdf pdfCreator;

	/** The excel color. */
	@Autowired
	@Qualifier("header")
	private Color excelColor;

	/** The excel color data. */
	@Autowired
	@Qualifier("data")
	private Color excelColorData;

	/**
	 * Gets the excel.
	 *
	 * @param products the products
	 * @return the excel
	 */
	@PostMapping(value = "/excel", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public ResponseEntity<byte[]> getExcel(@RequestBody final List<Product> products) {
		log.info("Call /excel");
		final ExcelBook<Product> excel = new ExcelBook<>("Products");
		excel.setBlankSheet();
		excel.setHeaders(Product.getHeaders());
		excel.setData(products);
		excel.setHeaderColor(excelColor);
		excel.setDataColor(excelColorData);
		try {
			return new ResponseEntity<>(excel.prepareToSend(), HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Gets the pdf.
	 *
	 * @param recipe the recipe
	 * @return the pdf
	 */
	@PostMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> getPdf(@RequestBody final Recipe recipe) {
		log.info("Call /pdf  --> id:{}", recipe.getId());
		try {
			byte[] pdf = pdfCreator.processPdf(new PdfMetadata("Recipe " + recipe.getTitle()), recipe);
			return new ResponseEntity<>(pdf, HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the pdf all.
	 *
	 * @param recipes the recipes
	 * @return the pdf all
	 */
	@PostMapping(value = "/pdf/all", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> getPdfAll(@RequestBody final Recipe[] recipes) {
		log.info("Call /pdf/all");
		try {
			byte[] pdf = pdfCreator.processPdf(new PdfMetadata("COOKBOOK"), recipes);
			return new ResponseEntity<>(pdf, HttpStatus.OK);
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
