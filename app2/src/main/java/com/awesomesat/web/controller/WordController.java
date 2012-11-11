package com.awesomesat.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awesomesat.app.domain.Word;
import com.awesomesat.app.parser.ListParser;
import com.awesomesat.app.service.WordService;

@Controller
public class WordController {

	@Autowired
	private WordService wordService;

	@RequestMapping(value = "/")
	public String index() {
		return "redirect:list/short";
	}

	@RequestMapping(value = "/list/{type}")
	public String list(@PathVariable("type") String type, Model model) {
		List<Word> words = wordService.list();
		model.addAttribute("words", words);
		String template = "detail".equals(type) ? "detailList" : "shortList";
		return template;
	}

	@RequestMapping(value = "/word/{id}")
	public String word(@PathVariable("id") Long id, Model model) {
		Word word = wordService.find(id);
		model.addAttribute("word", word);
		return "wordDetail";
	}

	@RequestMapping(value = "/save")
	public String save() {
		List<Word> words = ListParser.parseWords();
		for (Word w : words) {
			wordService.save(w);
		}
		return "redirect:list/short";
	}
}
