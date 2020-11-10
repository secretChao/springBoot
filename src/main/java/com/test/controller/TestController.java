package com.test.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.service.UserService;
import com.test.vo.User;

@RestController
public class TestController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String index() throws IOException {
		String json = "{" + "\"status\": " + "\"ok\";" + "}";
		return json;
	}

	@GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String find(@PathVariable("id") String id) {
		String json;
		try {
			User user = userService.find(id);

			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(user);

		} catch (Exception e) {
			json = e.getMessage();
		}
		return json;
	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public String findAll() {
		String json;
		try {
			Iterable<User> users = userService.findAll();

			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(users);
		} catch (Exception e) {
			json = e.getMessage();
		}
		return json;
	}

//	@PostMapping(value = "/insert")
	@GetMapping(value = "/insert")
//	public String insert(@Valid @RequestBody User user) throws Exception {
	public String insert(@Valid @RequestParam String id, @Valid @RequestParam String name) throws Exception {
		String result;
		try {
			User user = new User();
			user.setId(id);
			user.setName(name);
			userService.insert(user);
			result = "success";
		} catch (Exception e) {
			result = e.getMessage();
		}

		return result;
	}

//	@PutMapping(value = "/update")
	@GetMapping(value = "/update/{id}/{name}")
//	public String update(@Valid @RequestBody User user) throws Exception {
	public String update(@Valid @PathVariable("id") String id, @Valid @PathVariable("name") String name)
			throws Exception {
		String result;
		try {
			User user = new User();
			user.setId(id);
			user.setName(name);
			userService.update(user);
			result = "success";
		} catch (Exception e) {
			result = e.getMessage();
		}

		return result;
	}

//	@DeleteMapping(value = "/delete/{id}")
	@GetMapping(value = "/delete/{id}")
	public String delete(@Valid @PathVariable("id") String id) throws Exception {
		String result;
		try {
			userService.delete(id);
			result = "success";
		} catch (Exception e) {
			result = e.getMessage();
		}

		return result;
	}
}
