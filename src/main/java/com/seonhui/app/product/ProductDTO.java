package com.seonhui.app.product;

public class ProductDTO {
	private String p_code;
	private String p_name;
	private double interest;
	private String script;
	private int index_Of_Lists;

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

	public int getIndex_Of_Lists() {
		return index_Of_Lists;
	}

	public void setIndex_Of_Lists(int index_Of_Lists) {
		this.index_Of_Lists = index_Of_Lists;
	}

}
