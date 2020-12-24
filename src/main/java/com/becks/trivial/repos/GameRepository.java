package com.becks.trivial.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.becks.trivial.models.Game;
import com.becks.trivial.models.User;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	List<Game> findAll(); 
	
	List<Game> findByPlayer(User player); 
}
