package com.douzone.container.videosystem;

public class Avengers implements DigitalVideoDisc {

	private String title = "Avengers";
	private String studio = "MARVLE";
	
	
	@Override
	public void play() {
		System.out.println("Play Movie "+ studio + "'s "+ title);
	}

}
