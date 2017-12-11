package org.learning.hb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="interests")
public class Interests {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String interest;
	
}
