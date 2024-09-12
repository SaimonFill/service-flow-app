package com.saimonfill.repairhistoryapi.entity;

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
public class Company {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer companyId;

	@Column(unique = true, nullable = false, length = 36)
	private String uuid;

	@Column(unique = true, nullable = false)
	private String corporateName;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String taxPayerId;

	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;

	@Column(nullable = false)
	private String status;

	@Column(nullable = false)
	private Timestamp createdAt;

	@Column(nullable = false)
	private String createdBy;

	private Timestamp updatedAt;

	private String updatedBy;

	@Column(nullable = false)
	private Boolean active;

	@OneToMany(mappedBy = "company")
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
	}
}
