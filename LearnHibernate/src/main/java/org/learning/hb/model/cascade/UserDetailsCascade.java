package org.learning.hb.model.cascade;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.learning.hb.model.Vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="user_details")
public class UserDetailsCascade {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int userId;

	@Column( name="user_name" )
	private String name;
	
	@Column( name="user_email" )
	private String email;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="vehicle_id")
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	
}
