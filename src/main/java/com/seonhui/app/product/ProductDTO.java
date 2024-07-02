package com.seonhui.app.product;

public class ProductDTO {
	private String p_code;
	private String p_name;
	private double interest;
	private String script;
	private int indexOfLists;

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public int getIndexOfLists() {
		return indexOfLists;
	}

	public void setIndexOfLists(int indexOfLists) {
		this.indexOfLists = indexOfLists;
	}

}
