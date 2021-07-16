package com.auth0.samples.authapi.springbootauthupdated.rolle;

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
@RequestMapping("/rolles")
public class RolleController {
	
	private RolleRepository rolleRepository;

	public RolleController(RolleRepository rolleRepository) {
		this.rolleRepository = rolleRepository;
	}

	/**
	 * erstellt eine neue Rolle mit der hilfe des parameter eingabe
	 * @param rolle
	 */
	@PostMapping
	public void addRolle(@RequestBody Rolle rolle) {
		rolleRepository.save(rolle);
	}

	/**
	 * gib eine Liste aller Rollen zurück
	 * @return Liste aller Rollen zurück
	 */
	@GetMapping
	public List<Rolle> getRolles() {
		return rolleRepository.findAll();
	}
	
	
	/**
	 * gibt eine Rolle zurück 
	 * 
	 * @param id
	 * @return gibt eine Rolle zurück welche die param id hat
	 */
	@GetMapping("/{id}")
	public Rolle getRolle(@PathVariable Long id) {
		return rolleRepository.findById(id).get();
	}

	/**
	 * ändert die Daten der Rolle welcher die id param id besitzt und spiechert diese in der Datenbank
	 * @param id
	 * @param rolle
	 */
	@PutMapping("/{id}")
	public void editRolle(@PathVariable long id, @RequestBody Rolle rolle) {
		Rolle existingRolle = rolleRepository.findById(id).get();
		Assert.notNull(existingRolle, "Task not found");
		existingRolle.setBezeichnung(rolle.getBezeichnung());
		rolleRepository.save(existingRolle);
	}
	
	/**
	 * 
	 * löscht eine Rolle welcher der id besitzt. 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteRolle(@PathVariable long id) {
		Rolle rolleToDel = rolleRepository.findById(id).get();
		rolleRepository.delete(rolleToDel);
	}

}
