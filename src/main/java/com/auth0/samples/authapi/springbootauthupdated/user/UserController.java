package com.auth0.samples.authapi.springbootauthupdated.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping("/users")
public class UserController {

	private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * 
     * diese Funktion gibt eine Liste aller ApplicationUsers zur�ck
     * @return liste aller user
     */
    @GetMapping
    public List<ApplicationUser> getUsers() {
        return applicationUserRepository.findAll();
    }
    
    /**
     * gibt eine ApplicationUser zur�ck welcher der Id besitzt
     * 
     * @param id
     * @return gibt einen ApplicationUser zur�ck
     */
    @GetMapping("/{id}")
	public ApplicationUser getUser(@PathVariable Long id) {
		return applicationUserRepository.findById(id).get();
	}
    /**
     * mit dieser funktion kann man einen ApplicationUser erstellen
     * 
     * @param user
     */
    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
    
	/**
	 * mit dieser Funktion kann man die Daten eines ApplicationUsers �ndern
	 * @param id
	 * @param user
	 */

	@PutMapping("/{id}")
	public void editUser(@PathVariable long id, @RequestBody ApplicationUser user) {
		ApplicationUser existingUser = applicationUserRepository.findById(id).get();
		Assert.notNull(existingUser, "Task not found");
		existingUser.setUsername(user.getUsername());
		applicationUserRepository.save(existingUser);
	}

	/**
	 * mit dieser Funktion kann man einen ApplikationUser l�schen
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {
		ApplicationUser userToDel = applicationUserRepository.findById(id).get();
		applicationUserRepository.delete(userToDel);
	}

}
