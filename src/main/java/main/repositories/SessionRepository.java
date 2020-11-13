package main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
