package io.matoshri.jpa.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MOBILE_DB")
public class Mobile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ElementCollection
    @CollectionTable(name = "emp_mob_mapping", 
      joinColumns = {@JoinColumn(name = "emp_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "mobile")
	private Map<String, String> mobiles = new HashMap<String, String>();
	
	@OneToOne(mappedBy = "mobiles")
	private Employee employee;

}
