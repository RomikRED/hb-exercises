package org.learning.hb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="vehicle")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int vehicleId;
	
	private String brand;
	
	private String model;

	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails owner; 

	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private UserDetails insuranceBroker;
	
	public Vehicle(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}
}
