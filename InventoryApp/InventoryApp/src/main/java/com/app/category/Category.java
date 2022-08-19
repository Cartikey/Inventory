package com.app.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
	
	@Column(length=50, nullable=false, unique=true)
private String name;
	
	
	
	
public Category() {
		super();
		
	}

public Category(Integer id) {
	super();
	this.id = id;
	
}

public Category( String name) {
	super();
	
	this.name = name;
}
public Integer getId() {
	return id;
}
public String getName() {
	return name;
}
public void setId(Integer id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}


}
