package com.saimonfill.repairhistoryapi.entity;

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
	private boolean active = true;

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
	}
}
