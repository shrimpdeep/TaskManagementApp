package com.auth0.samples.authapi.springbootauthupdated;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth0.samples.authapi.springbootauthupdated.event.Event;
import com.auth0.samples.authapi.springbootauthupdated.event.EventRepository;
import com.auth0.samples.authapi.springbootauthupdated.rolle.Rolle;
import com.auth0.samples.authapi.springbootauthupdated.rolle.RolleRepository;
import com.auth0.samples.authapi.springbootauthupdated.task.Task;
import com.auth0.samples.authapi.springbootauthupdated.task.TaskRepository;
import com.auth0.samples.authapi.springbootauthupdated.user.ApplicationUser;
import com.auth0.samples.authapi.springbootauthupdated.user.ApplicationUserRepository;

@SpringBootApplication
public class SpringbootAuthUpdatedApplication {

	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAuthUpdatedApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner taskdemo(TaskRepository taskRepository, RolleRepository rolleRepository,
			ApplicationUserRepository userRepository, EventRepository eventRepository) {
		return (args) -> {
			
			Task t1 = new Task("Tram nehmen");
			Task t2 = new Task("Doku machen");
			Task t3 = new Task("Abgeben");
			

			taskRepository.save(t1);
			taskRepository.save(t2);
			taskRepository.save(t3);
			
			 
			
			Rolle rolle1 = new Rolle("admin");
			Rolle rolle2 = new Rolle("user");
			Rolle rolle3 = new Rolle("Moderator");
			
			rolleRepository.save(rolle1);
			rolleRepository.save(rolle2);
			rolleRepository.save(rolle3);

					
			
			ApplicationUser user1 = new ApplicationUser("Sam", "779782");
			ApplicationUser user2 = new ApplicationUser("Jacob", "456");
			ApplicationUser user3 = new ApplicationUser("Manuel", "412");

			user1.setRolleFs(rolle1);
			user2.setRolleFs(rolle2);
			user2.setRolleFs(rolle3);


			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);


			Event event1 = new Event("Party2", LocalDateTime.now(), LocalDateTime.now(), rolle2);
			Event event2 = new Event("Party3", LocalDateTime.now(), LocalDateTime.now(), rolle1);
			Event event3 = new Event("Modiparty", LocalDateTime.now(), LocalDateTime.now(), rolle3);

			eventRepository.save(event1);
			eventRepository.save(event2);
			eventRepository.save(event3);

		};
		
	}
	
	
}
