package com.seonhui.app.robot;

//@Component("ra")
public class RightArm implements Arm {

	public void info() {
		System.out.println("오른팔입니다.");
	}

	// annotation&IOC are for 객체생성, 의존성주입
	// annotation 들은 싱글톤들임 -> 객체를 딱 하나만 만듦-> Spring pool(Spring container가 생명주기를
	// 관리)에 모아놓고 있다가 @Autowired 했을 때 찾아서 주입
	// 인터페이스를 상속받은 객체들이 같은 타입이면 멤버변수명과 객체이름이 같으면 됨
}
