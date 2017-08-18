package net.grc.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

	private String name;
	private String catchPhase;
	private String bs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatchPhase() {
		return catchPhase;
	}
	public void setCatchPhase(String catchPhase) {
		this.catchPhase = catchPhase;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", catchPhase=" + catchPhase + ", bs=" + bs + "]";
	}
	
	
	
}
