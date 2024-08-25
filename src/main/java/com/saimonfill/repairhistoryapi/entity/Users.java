package com.saimonfill.repairhistoryapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer userId;

	@NotNull
	private String givenName;

	@NotNull
	private String surName;

	@NotNull
	@Column(unique = true)
	private String email;

	@NotNull
	private String password;

	@NotNull
	private String authorities;

	@NotNull
	private Timestamp createdAt;

	@NotNull
	private String createdBy;

	private Timestamp updatedAt;

	private String updatedBy;

	@NotNull
	private boolean active = true;

	@PrePersist
	protected void onCreate() {
		if (createdAt == null) {
			createdAt = new Timestamp(System.currentTimeMillis());
		}
		if (createdBy == null) {
			createdBy = "system";
		}
	}
}
