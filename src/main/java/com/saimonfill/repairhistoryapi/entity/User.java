package com.saimonfill.repairhistoryapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;


@Entity
@Table(name="users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(unique = true)
	private String username;

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

	@PrePersist
	protected void onCreate() {
		if (createdAt == null) {
			createdAt = new Timestamp(System.currentTimeMillis());
		}
		if (createdBy == null) {
			createdBy = "system";
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
