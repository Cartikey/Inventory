package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "departments")
@Getter
@Setter
@ToString
public class Department extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private DeptNames name;
	@Column(length = 20)
	private String location;
}
