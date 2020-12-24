package com.becks.trivial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becks.trivial.models.Game;
import com.becks.trivial.repos.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepo; 
	
	//create and update
	public Game saveGame(Game game) {
		return gameRepo.save(game); 
	}
	
	//read
	
	//findAll
	
	public List<Game> allGames(){
		return gameRepo.findAll(); 
	}
	
	//findOne
	public Game findGameById(Long id) {
		Optional<Game> game = gameRepo.findById(id); 
		
		if(game.isPresent()) {
			return game.get(); 
		} else {
			return null; 
		}
	}
	
	//delete
	
	public void deleteGame(Long id) {
		gameRepo.deleteById(id);
	}
}
