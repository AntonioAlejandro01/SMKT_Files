package com.antonioalejandro.smkt.files.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Recipe {

	private String id;
	private String title;
	private List<Ingredient> ingredients;
	private List<String> steps;
	private Integer time;

	@JsonCreator
	public Recipe(final String id, final String title, final List<Ingredient> ingredients, final List<String> steps,
			final Integer time) {
		super();
		this.id = id;
		this.title = title;
		this.ingredients = ingredients;
		this.steps = steps;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(final List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(final List<String> steps) {
		this.steps = steps;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(final Integer time) {
		this.time = time;
	}

}
