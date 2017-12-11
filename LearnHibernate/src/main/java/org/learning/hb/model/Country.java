package org.learning.hb.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Country {

	@Column(name="country_name")
	private String name;
	
	@Column(name="country_language")
	private String language;
}
