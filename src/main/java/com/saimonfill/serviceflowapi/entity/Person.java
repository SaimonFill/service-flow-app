package com.saimonfill.serviceflowapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer personId;

	@Column(unique = true, nullable = false, length = 36)
	private String uuid;

	@Column(nullable = false)
	private String givenName;

	@Column(nullable = false)
	private String surName;

	@Column(nullable = false)
	private String phoneNumber;

	@Column(unique = true, nullable = false)
	private String taxPayerId;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(nullable = false)
	private Timestamp createdAt;

	@Column(nullable = false)
	private String createdBy;

	private Timestamp updatedAt;

	private String updatedBy;

	@Column(nullable = false)
	private Boolean active;

	@OneToOne(mappedBy = "person")
	private Company company;

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
	}
}
