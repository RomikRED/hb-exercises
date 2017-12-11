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
public class Friend {
	
	@Column(name="friend_name")
	private String name;
	@Column(name="friend_age")
	private short age; 
}
