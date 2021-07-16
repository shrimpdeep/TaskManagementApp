package com.auth0.samples.authapi.springbootauthupdated.event;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author: Shramdeep Chamlagai
 * @date: 15.07.2021
 * 
 */


public interface EventRepository extends JpaRepository<Event, Long> {
}