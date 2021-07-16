package com.auth0.samples.authapi.springbootauthupdated.event;

import java.util.List;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author: Shramdeep Chamlagai
 * @date: 15.07.2021
 * 
 */


@RestController
@RequestMapping("/events")
public class EventController {

	private EventRepository eventRepository;

	public EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

/**
 * erstellt einen neuen Event
 * @param event
 */
	@PostMapping
	public void addEvent(@RequestBody Event event) {
		eventRepository.save(event);
	}

	/**
	 * Gibt eine Liste aller Events zurück
	 * @return eine Event Liste
	 */
	@GetMapping
	public List<Event> getEvents() {
		return eventRepository.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return gibt eine Event zurück mit der id
	 */
	@GetMapping("/{id}")
	public Event getEvent(@PathVariable Long id) {
		return eventRepository.findById(id).get();
	}


	/**
	 * ändert die Daten einer Event um mit die Daten des param event
	 * die änderung wird in der Datenbank gespeichert. 
	 * @param id
	 * @param event
	 */
	@PutMapping("/{id}")
	public void editEvent(@PathVariable long id, @RequestBody Event event) {
		Event existingEvent = eventRepository.findById(id).get();
		Assert.notNull(existingEvent, "Task not found");
		existingEvent.setBezeichnung(event.getBezeichnung());
		eventRepository.save(existingEvent);
	}

	/**
	 * Entfernt einen Event aus der Datenbank
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable long id) {
		Event eventToDel = eventRepository.findById(id).get();
		eventRepository.delete(eventToDel);
	}

}
