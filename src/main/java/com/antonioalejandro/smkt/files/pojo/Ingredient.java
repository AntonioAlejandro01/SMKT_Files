package com.antonioalejandro.smkt.files.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Ingredient {
	private String name;
	private String amount;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(final String amount) {
		this.amount = amount;
	}

	@JsonCreator
	public Ingredient(final String name, final String amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
}