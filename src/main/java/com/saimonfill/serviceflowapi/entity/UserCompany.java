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
public class UserCompany {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer userCompanyId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users users;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(nullable = false)
	private Timestamp createdAt;

	@Column(nullable = false)
	private String createdBy;

	private Timestamp updatedAt;

	private String updatedBy;

	@Column(nullable = false)
	private Boolean active;

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
