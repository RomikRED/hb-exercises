package org.learning.hb.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="food")
public class Food {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToMany(mappedBy="favouriteFoods")
	private Collection<UserDetails> users = new ArrayList<UserDetails>();
	
	
}
