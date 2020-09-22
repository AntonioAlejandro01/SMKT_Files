package com.antonioalejandro.smkt.files.pojo;

import java.util.Arrays;
import java.util.List;

import com.antonioalejandro.smkt.files.excel.ExcelData;
import com.antonioalejandro.smkt.files.excel.interfaces.IExcelObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "CATEGORIES", "fields", "headers" })
public class Product implements IExcelObject {

	private final static String[] CATEGORIES = new String[] { "Comida", "Menaje", "Limpieza", "Utensilios de limpieza",
			"Otros" };
	private String id;
	private String name;
	private Integer category;
	private String codeKey;
	private Double price;
	private Integer amount;

	@JsonCreator
	public Product(final String id, final String name, final Integer category, final String codeKey, final Double price,
			final Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.codeKey = codeKey;
		this.price = price;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(final Integer category) {
		this.category = category;
	}

	public String getCodeKey() {
		return codeKey;
	}

	public void setCodeKey(final String codeKey) {
		this.codeKey = codeKey;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(final Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}

	public static List<String> getHeaders() {
		return Arrays.asList("ID", "Nombre", "Categoría", "Código", "Precio", "Cantidad", "Total");
	}

	@Override
	public List<ExcelData> getFields() {
		return Arrays.asList(new ExcelData(id), new ExcelData(name), new ExcelData(CATEGORIES[category]),
				new ExcelData(codeKey), new ExcelData(price), new ExcelData(amount), new ExcelData(price * amount));
	}

}
