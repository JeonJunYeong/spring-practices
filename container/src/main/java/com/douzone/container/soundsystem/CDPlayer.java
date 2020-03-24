package com.douzone.container.soundsystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	
	// Wiring01: 바이너리 주입(CGLib) 
	// @Inject (자바 표준 DI 어노테이션)
	@Autowired //(스프링 wiring 어노테이션)
	@Qualifier("HighSchoolRapper") 
	private CompactDisc cd;
	
	//@Autowired
	public CDPlayer() {
		
	}
	
	// Wiring02: 생성자 주입
	// @Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd=cd;
	}
	
	
	// Wiring03: setter 사용
	// @Autowired
	public void setCompactDisc( CompactDisc cd) {
		this.cd=cd;
	}
	
	// Wiring04: 일반 메소드 사용
	// @Autowired
	public void insertCompactDisc( CompactDisc cd) {
		this.cd=cd;
	}
	
	public void play() {
		cd.play();
	}

	
}
