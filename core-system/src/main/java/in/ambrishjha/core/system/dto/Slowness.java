package in.ambrishjha.core.system.dto;

import lombok.Data;


public class Slowness {

    private Long slowness;

	public Long getSlowness() {
		return slowness;
	}

	public void setSlowness(Long slowness) {
		this.slowness = slowness;
	}

	public Slowness(Long slowness) {
		super();
		this.slowness = slowness;
	}
    
    
}
