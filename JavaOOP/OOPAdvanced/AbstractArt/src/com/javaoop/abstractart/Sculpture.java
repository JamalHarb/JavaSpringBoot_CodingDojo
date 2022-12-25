package com.javaoop.abstractart;

public class Sculpture extends Art {
	private String material;

	@Override
	public void viewArt() {
		System.out.println("Material is " + material);
		
	}

	public Sculpture(String material) {
		super();
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
