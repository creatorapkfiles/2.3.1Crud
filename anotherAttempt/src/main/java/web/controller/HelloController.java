package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class HelloController {

	private final UserService userService;
	@Autowired
	public HelloController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String showAll(ModelMap model) {
		model.addAttribute("user", userService.showAll());
		return "index";
	}

	@GetMapping("/new")	public  String newUser(Model model) {
		model.addAttribute("user", new User());
		return "new";
	}
	@PostMapping(value = "/new")
	public String create(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/";
	}

	@GetMapping("/edit")
	public String updateUser(@RequestParam("id") Long id , Model model) {
		model.addAttribute("user", userService.getUser(id));
		return "edit";
	}

	@PostMapping(value = "/edit")
	public String update(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String removeUser(@RequestParam("id") Long id ) {
		userService.delete(id);
		return "redirect:/";
	}
}