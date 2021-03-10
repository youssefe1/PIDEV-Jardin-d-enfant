package com.esprit.spring.entities;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Pk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long usId;
	private Long evId;
	private String name;
	
	
	
	public Long getUsId() {
		return usId;
	}
	public void setUsId(Long usId) {
		this.usId = usId;
	}
	public Long getEvId() {
		return evId;
	}
	public void setEvId(Long evId) {
		this.evId = evId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	

}

