package com.becks.trivial.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.becks.trivial.models.Game;
import com.becks.trivial.models.Question;
import com.becks.trivial.models.Result;
import com.becks.trivial.models.User;
import com.becks.trivial.services.GameService;
import com.becks.trivial.services.UserService;

@Controller
public class MainController {
	
	private final RestTemplate restTemplate; 
	
	private final GameService gameServ; 
	
	private final UserService userServ; 
	
	public MainController(RestTemplate restTemplate, GameService gameServ, UserService userServ) {
		this.restTemplate = restTemplate; 
		this.gameServ = gameServ; 
		this.userServ = userServ; 
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		
		if(session.getAttribute("user_id") == null) {
			return "redirect:/"; 
		}
		
		Long userId = (Long) session.getAttribute("user_id"); 
		User currentUser = userServ.findUserById(userId); 
		model.addAttribute("user", currentUser); 
		return "dashboard.jsp"; 
	}
	
	@GetMapping("/game")
	public String gameTable(HttpSession session, Model model) {
		if(session.getAttribute("score") == null) {
			session.setAttribute("score", 0);
			session.setAttribute("count", 0);
			Game currGame = new Game(userServ.findUserById((Long) session.getAttribute("user_id"))); 
			session.setAttribute("currentGame", currGame);
		}
		
		if((int) session.getAttribute("score") == 100) {
			model.addAttribute("winner", true); 
			Game currGame = (Game) session.getAttribute("currentGame"); 
			currGame.setWin(true);
			session.setAttribute("currentGame", currGame);
		}
		
		if((int)session.getAttribute("count") == 15) {
			model.addAttribute("lose", true); 
			Game currGame = (Game) session.getAttribute("currentGame"); 
			currGame.setWin(false);
			session.setAttribute("currentGame", currGame);
		}
		
		model.addAttribute("user", userServ.findUserById((Long)session.getAttribute("user_id"))); 
		
		model.addAttribute("score", session.getAttribute("score")); 
		gameServ.saveGame((Game)session.getAttribute("currentGame")); 
		return "/games/game.jsp"; 
	}
	
	@GetMapping("/category/{category}")
	public String getQuestion(@PathVariable("category") String category, HttpSession session) {
		String uriPath = ""; 
		
		if(category.equals("science")) {
			uriPath += "https://opentdb.com/api.php?amount=1&category=17&difficulty=easy"; 
		} else if (category.equals("history")) {
			uriPath += "https://opentdb.com/api.php?amount=1&category=23&difficulty=easy"; 
		} else if (category.equals("celebrities")) {
			uriPath += "https://opentdb.com/api.php?amount=1&category=26&difficulty=easy"; 
		} else if (category.equals("politics")) {
			uriPath += "https://opentdb.com/api.php?amount=1&category=24&difficulty=easy"; 
		} else {
			uriPath += "https://opentdb.com/api.php?amount=1&category=9&difficulty=easy"; 
		}
		Question question = restTemplate.getForObject(uriPath, Question.class);
		Result result = question.getResults().iterator().next();
		session.setAttribute("currentQuestion", result);
		return "redirect:/question"; 
	}
	
	@GetMapping("/question")
	public String question(Model model, HttpSession session) {
		Result question = (Result) session.getAttribute("currentQuestion"); 
		List<String> answers = question.getIncorrect_answers(); 
		answers.add(question.getCorrect_answer()); 
		Collections.shuffle(answers, new Random());
		model.addAttribute("question", question.getQuestion()); 
		model.addAttribute("answers", answers); 
		model.addAttribute("user", userServ.findUserById((Long)session.getAttribute("user_id")));  
		return "/games/question.jsp"; 
	}
	
	@PostMapping("/processAnswer")
	public String process(@RequestParam("answer") String answer, HttpSession session, RedirectAttributes redirectAttributes) {
		Result question = (Result) session.getAttribute("currentQuestion"); 
		if(question.getCorrect_answer().equals(answer)) {
			redirectAttributes.addFlashAttribute("response", "You are correct! 10 points!");
			session.setAttribute("score", (int)session.getAttribute("score") + 10);
			Game currGame = (Game) session.getAttribute("currentGame"); 
			currGame.setCorrectCount(currGame.getCorrectCount()+1);
			session.setAttribute("currentGame", currGame);
		} else {
			redirectAttributes.addFlashAttribute("response", "Sorry! The correct answer was " + question.getCorrect_answer() + ".");
			Game currGame = (Game) session.getAttribute("currentGame"); 
			currGame.setIncorrectCount(currGame.getIncorrectCount()+1);
			session.setAttribute("currentGame", currGame);
		}
		
		session.setAttribute("count", (int)session.getAttribute("count") + 1);
		return "redirect:/game"; 
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/game"; 
	}
	
}
