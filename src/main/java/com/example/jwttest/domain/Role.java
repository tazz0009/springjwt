package com.example.jwttest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Role {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
//	@SequenceGenerator(
//			name = "role_id_sequence",
//			sequenceName = "role_id_sequence"
//	)
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "role_id_sequence"
//	)
	private Long id;
	private String name;
}
