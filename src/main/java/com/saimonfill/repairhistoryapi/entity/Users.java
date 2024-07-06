package com.saimonfill.repairhistoryapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String uuid;

	@NotNull
	@Column(unique = true)
	private String name;

	@NotNull
	@Column(unique = true)
	private String email;

	@NotNull
	private String passwordHash;

	@NotNull
	private Timestamp createdAt;

	@NotNull
	private String createdBy;

	private Timestamp updatedAt;

	private String updatedBy;

	@PrePersist
	protected void onCreate() {
		if (createdAt == null) {
			createdAt = new Timestamp(System.currentTimeMillis());
		}
		if (createdBy == null) {
			createdBy = "system";
		}
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
	}

//	public void setPassword(String password) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		this.passwordHash = passwordEncoder.encode(password);
//	}
//
//	public boolean checkPassword(String password) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		return passwordEncoder.matches(password, this.passwordHash);
//	}
}
