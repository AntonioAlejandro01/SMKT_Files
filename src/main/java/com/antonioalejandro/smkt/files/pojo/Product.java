/*
 * @Author AntonioAlejandro01
 * 
 * @link http://antonioalejandro.com
 * @link https://github.com/AntonioAlejandro01/SMKT_Users
 * 
 */
package com.antonioalejandro.smkt.files.pojo;

import java.util.Arrays;
import java.util.List;

import com.antonioalejandro.utils.excel.ExcelData;
import com.antonioalejandro.utils.excel.interfaces.IExcelObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * The class Product
 *
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties({ "CATEGORIES", "fields", "headers" })
public class Product implements IExcelObject {

	/** The Constant CATEGORIES. */
	private static final String[] CATEGORIES = new String[] { "Comida", "Menaje", "Limpieza", "Utensilios de limpieza",
			"Otros" };

	/** The id. */
	@JsonProperty
	private String id;

	/** The name. */
	@JsonProperty
	private String name;

	/** The category. */
	@JsonProperty
	private Integer category;

	/** The code key. */
	@JsonProperty
	private String codeKey;

	/** The price. */
	@JsonProperty
	private Double price;

	/** The amount. */
	@JsonProperty
	private Integer amount;

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public static List<String> getHeaders() {
		return Arrays.asList("ID", "Nombre", "Categoría", "Código", "Precio", "Cantidad", "Total");
	}

	/**
	 * Obtain fields.
	 *
	 * @return the list
	 */
	@Override
	public List<ExcelData> obtainFields() {
		return Arrays.asList(new ExcelData(id), new ExcelData(name), new ExcelData(CATEGORIES[category]),
				new ExcelData(codeKey), new ExcelData(price), new ExcelData(amount), new ExcelData(price * amount));
	}

}
