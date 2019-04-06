package gr.anagnosg.schoolservices.models;

import javax.validation.constraints.Size;

public class Skill {

	int id;
	@Size(min=2,max=100)
	String descr;
	String sdescr;
	public Skill(){}
	public Skill(int id){this.id = id;}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getSdescr() {
		return sdescr;
	}
	public void setSdescr(String sdescr) {
		this.sdescr = sdescr;
	}
	
}
