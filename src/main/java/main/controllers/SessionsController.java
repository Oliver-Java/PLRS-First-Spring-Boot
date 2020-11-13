package main.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.models.Session;
import main.repositories.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@GetMapping
	public List<Session> list(){
		return sessionRepository.findAll();
	}
	@GetMapping
	@RequestMapping("{id}")
	public Session get(@PathVariable Long id){
		return sessionRepository.getOne(id);
	}
	@PostMapping
	public Session create(@RequestBody final Session session){
		return sessionRepository.saveAndFlush(session);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		// learn implement children/cascade delete as well.. bla bla
		 sessionRepository.deleteById(id);
	}
	@PutMapping("{id}")
	public Session update(@PathVariable Long id, @RequestBody Session session){
		// TO-DO validation! return 400
		Session alreadyExistingSession = sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, alreadyExistingSession, "session_id");
		return sessionRepository.saveAndFlush(alreadyExistingSession);
	}
	}



















