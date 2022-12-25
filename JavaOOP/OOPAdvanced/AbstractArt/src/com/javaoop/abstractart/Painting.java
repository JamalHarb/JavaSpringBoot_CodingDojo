package com.javaoop.abstractart;

public class Painting extends Art {
	private String paintType;

	@Override
	public void viewArt() {
		System.out.println("Paint type is " + paintType);
		
	}

	public Painting(String paintType) {
		super();
		this.paintType = paintType;
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

}
