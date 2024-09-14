package com.saimonfill.serviceflowapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

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

	@Column(unique = true, nullable = false, length = 36)
	private String uuid;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String authorities;

	@Column(nullable = false)
	private Timestamp createdAt;

	@Column(nullable = false)
	private String createdBy;

	private Timestamp updatedAt;

	private String updatedBy;

	@Column(nullable = false)
	private Boolean active;

	@OneToMany(mappedBy = "users")
	private List<UserCompany> userCompanies;

	@PrePersist
	protected void onCreate() {
		if (createdAt == null) {
			createdAt = new Timestamp(System.currentTimeMillis());
		}
		if (createdBy == null) {
			createdBy = "system";
		}
		if (uuid == null) {
			uuid = java.util.UUID.randomUUID().toString();
		}
		if (active == null) {
			active = Boolean.TRUE;
		}
	}
}
