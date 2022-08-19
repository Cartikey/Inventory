package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@Getter
@Setter
@ToString(exclude = "dept")
public class Employee extends BaseEntity{
	@Column(length = 30)
	private String name;
	@Column(length = 100)
	private String address="Pune";
	private double salary;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate joinDate;
	//uni dir asso between Dept 1<-----* Emp
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id",nullable = false)
	private Department dept;

}
