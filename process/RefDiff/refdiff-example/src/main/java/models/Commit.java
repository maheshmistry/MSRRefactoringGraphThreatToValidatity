package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Commit {

	@SerializedName("commitId")
	@Expose
	private String commitId;

	@SerializedName("devName")
	@Expose
	private String devName;

	@SerializedName("date")
	@Expose
	private String date;
	
	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}
	
	public String getCommitId() {
		return this.commitId;
	}
	
	public void setDevName(String devName) {
		this.devName = devName;
	}
	
	public String getDevName() {
		return this.devName;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return this.date;
	}
}
