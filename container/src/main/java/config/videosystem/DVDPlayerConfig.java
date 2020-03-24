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
	
	
	@Bean
	public DVDPlayer dvdPlayer() {
		
		return new DVDPlayer(avengers());
	}
}
