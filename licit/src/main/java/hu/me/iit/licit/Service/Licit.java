package hu.me.iit.licit.Service;

public class Licit {
	private Integer licit;
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
	
	public Licit(Integer licit, Integer userId) {
		super();
		this.licit = licit;
		this.userId = userId;
	}
	public hu.me.iit.licit.Repository.Licit toEntity() {
		return new hu.me.iit.licit.Repository.Licit(licit, userId);
	}
}
