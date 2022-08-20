package com.app.entities;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

	@Entity
	@Table(name="country")
	public class Country extends BaseEntity{
	
		private String countryName;
		private String continent;
		private double population;
		@ManyToOne //users<----*country
		@JoinColumn(name= "users_id", nullable = false)
		private User user;
		
	}