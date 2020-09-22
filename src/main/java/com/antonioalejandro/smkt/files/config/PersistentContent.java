package com.antonioalejandro.smkt.files.config;

import java.awt.Color;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.antonioalejandro.smkt.files.pdf.Pdf;



@Configuration
public class PersistentContent {

	@Bean
	public Pdf getPdf() {
		return new Pdf();
	}

	@Bean("header")
	public Color getHeaderExcelColor() {
		return new Color(237, 112, 20);
	}

	@Bean("data")
	public Color getDataExcelColor() {
		return new Color(240, 218, 201);
	}
}
