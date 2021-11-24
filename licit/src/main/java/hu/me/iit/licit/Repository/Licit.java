package hu.me.iit.licit.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Licit {
	@GeneratedValue
	@Id
	private Long id;
	private Integer licit;
	private Integer userId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getLicit() {
		return licit;
	}
	public void setLicit(Integer licit) {
		this.licit = licit;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Licit(Integer licit, Integer userId) {
		this.licit = licit;
		this.userId = userId;
	}
	
	public Licit() {
		
	}
	
	
}
