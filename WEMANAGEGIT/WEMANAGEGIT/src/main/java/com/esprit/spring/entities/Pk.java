package com.esprit.spring.entities;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Pk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long usId;
	private Long evId;
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evId == null) ? 0 : evId.hashCode());
		result = prime * result + ((usId == null) ? 0 : usId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pk other = (Pk) obj;
		if (evId == null) {
			if (other.usId != null)
				return false;
		} else if (!evId.equals(other.usId))
			return false;
		if (usId == null) {
			if (other.usId != null)
				return false;
		} else if (!usId.equals(other.usId))
			return false;
		return true;
	}

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
	
	
	
	
	
	

}

