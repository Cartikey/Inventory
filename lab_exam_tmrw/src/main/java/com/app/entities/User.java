package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	private String Name;
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "country_id", nullable = false)
//	private Country country;
}
