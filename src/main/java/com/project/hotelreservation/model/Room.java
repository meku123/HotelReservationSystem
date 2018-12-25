package com.project.hotelreservation.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	//@NotEmpty(message = "Catagory Required")
	private String category;
	//@NotEmpty(message = "Size Required")
	private Long size;
	//@NotEmpty(message = "Floor Required")
	private Long floor;
	//@NotEmpty(message = "Price Required")
	private float price;

	public Room() {
	}

	public Room(String category, Long size, Long floor, float price) {
		this.category = category;
		this.size = size;
		this.floor = floor;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getFloor() {
		return floor;
	}

	public void setFloor(Long floor) {
		this.floor = floor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
