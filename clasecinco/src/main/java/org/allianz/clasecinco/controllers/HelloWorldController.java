package org.allianz.clasecinco.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

	@RequestMapping(value = "/api/hello", method = RequestMethod.GET)
	public String Hello() {
		return "<h1>Hello World 2</h1>";
	}
}
