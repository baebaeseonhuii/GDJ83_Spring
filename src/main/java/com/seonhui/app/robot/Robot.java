package com.seonhui.app.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // new Robot()
public class Robot {

	@Autowired // setRightArm
	@Qualifier("ra")
	private Arm ra;

	@Qualifier("la")
	@Autowired
	private Arm la;

	public Arm getRa() {
		return ra;
	}

	public void setRa(Arm ra) {
		this.ra = ra;
	}

	public Arm getLa() {
		return la;
	}

	public void setLa(Arm la) {
		this.la = la;
	}

}
