package main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
