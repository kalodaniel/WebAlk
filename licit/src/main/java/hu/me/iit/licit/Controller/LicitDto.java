package hu.me.iit.licit.Controller;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import hu.me.iit.licit.Service.Licit;

public class LicitDto {
	@NotNull
	@Min(1)
	private Integer licit;
	@NotNull
	@Min(1)
	private Integer userId;
	
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

	public LicitDto(@Min(1) Integer licit, @Min(1) Integer userId) {
		super();
		this.licit = licit;
		this.userId = userId;
	}



	public Licit toLicit() {
		return new Licit(licit,userId);
	}
}
