package config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration

public class DVDPlayerConfig {

	@Bean
	public Avengers avengers() {
		
		return new Avengers();
	}
	//@Bean
	public DVDPlayer dvdPlayer01() {
		
		return new DVDPlayer(avengers());
	}
	
	//@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		
		return new DVDPlayer(dvd);
	}
	
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		
		return dvdPlayer;
		
	}
	
	@Bean(name="player04")
	public DVDPlayer dvdPlayer04(DigitalVideoDisc dvd) {
		
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		
		return dvdPlayer;
		
	}
	
	
	
}
