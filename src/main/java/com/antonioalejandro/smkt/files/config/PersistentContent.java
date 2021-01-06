/*
 * @Author AntonioAlejandro01
 * 
 * @link http://antonioalejandro.com
 * @link https://github.com/AntonioAlejandro01/SMKT_Users
 * 
 */
package com.antonioalejandro.smkt.files.config;

import java.awt.Color;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.antonioalejandro.smkt.files.pdf.Pdf;



/**
 * The Class PersistentContent.
 */
@Configuration
public class PersistentContent {

	/**
	 * Gets the pdf.
	 *
	 * @return the pdf
	 */
	@Bean
	public Pdf getPdf() {
		return new Pdf();
	}

	/**
	 * Gets the header excel color.
	 *
	 * @return the header excel color
	 */
	@Bean("header")
	public Color getHeaderExcelColor() {
		return new Color(237, 112, 20);
	}

	/**
	 * Gets the data excel color.
	 *
	 * @return the data excel color
	 */
	@Bean("data")
	public Color getDataExcelColor() {
		return new Color(240, 218, 201);
	}
}
