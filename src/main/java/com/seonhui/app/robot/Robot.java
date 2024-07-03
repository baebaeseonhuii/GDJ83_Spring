package com.seonhui.app.robot;

//@Component // new Robot()
public class Robot {

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// @Autowired // setRightArm
	// @Qualifier("ra")
	private Arm rightArm;

	public Arm getRightArm() {
		return rightArm;
	}

	public void setRightArm(Arm rightArm) {
		this.rightArm = rightArm;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}

	// @Qualifier("la")
	// @Autowired
	private Arm leftArm;

}
