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
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer addressId;

	@Column(unique = true, nullable = false, length = 36)
	private String uuid;

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

	private String complement;

	@Column(nullable = false)
	private Timestamp createdAt;

	@Column(nullable = false)
	private String createdBy;

	private Timestamp updatedAt;

	private String updatedBy;

	@Column(nullable = false)
	private Boolean active;

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
		if (uuid == null) {
			uuid = java.util.UUID.randomUUID().toString();
		}
		if (active == null) {
			active = Boolean.TRUE;
		}
	}
}
