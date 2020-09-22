package com.antonioalejandro.smkt.files.excel;

import java.util.Date;

import com.antonioalejandro.smkt.files.excel.enums.ExcelDataTypes;


public class ExcelData {

	private String valueString;
	private Long valueLong;
	private Double valueDouble;
	private Date valueDate;
	private ExcelBooleanData valueExcelBooleanData;
	private Integer valueInteger;

	public ExcelData(final String value) {
		this.valueString = value;
	}

	public ExcelData(final Long value) {
		this.valueLong = value;
	}

	public ExcelData(final Double value) {
		this.valueDouble = value;
	}

	public ExcelData(final Date value) {
		this.valueDate = value;
	}

	public ExcelData(final ExcelBooleanData value) {
		this.valueExcelBooleanData = value;
	}

	public ExcelData(final Integer value) {
		this.valueInteger = value;
	}

	/**
	 * Obtiene un Objecrt con el valor puede ser uno del enum ExcelDataTypes
	 *
	 * @return
	 */
	public Object getValue() {
		if (valueDouble != null) {
			return valueDouble;
		} else if (valueLong != null) {
			return valueLong;
		} else if (valueDate != null) {
			return valueDate;
		} else if (valueExcelBooleanData != null) {
			return valueExcelBooleanData;
		} else if (valueInteger != null) {
			return valueInteger;
		} else {
			return valueString;
		}
	}

	/**
	 * Devuelve el tipo de dato que contiene el objeto.Es un tipo de datos del enum
	 * ExcelDataType
	 *
	 * @return
	 */
	public ExcelDataTypes getType() {
		if (valueDouble != null) {
			return ExcelDataTypes.DOUBLE;
		} else if (valueLong != null) {
			return ExcelDataTypes.LONG;
		} else if (valueDate != null) {
			return ExcelDataTypes.DATE;
		} else if (valueExcelBooleanData != null) {
			return ExcelDataTypes.BOOLEAN;
		} else if (valueInteger != null) {
			return ExcelDataTypes.INTEGER;
		} else {
			return ExcelDataTypes.STRING;
		}
	}

}
