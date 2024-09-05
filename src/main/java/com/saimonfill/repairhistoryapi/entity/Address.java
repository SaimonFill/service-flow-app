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
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer addressId;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String zipCode;

	@Column(nullable = false)
	private Timestamp createdAt;

	@Column(nullable = false)
	private String createdBy;

	private Timestamp updatedAt;

	private String updatedBy;

	@Column(nullable = false)
	private boolean active = true;

	@OneToOne(mappedBy = "address")
	private Person person;

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
