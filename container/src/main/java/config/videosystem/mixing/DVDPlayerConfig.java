package config.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.BlankDisc;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
@Import({DVDConfig.class})
public class DVDPlayerConfig {


	
	@Bean DVDPlayer dvdPlayer(@Qualifier("avengersInfinityWar")DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
}
