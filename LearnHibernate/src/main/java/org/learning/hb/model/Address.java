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
public class Address {
	
	@Column(name="country")
	private Country country;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;

	@Column(name="postcode")
	private int postcode;
	
}
