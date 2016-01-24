package com.szymonharabasz.miniforum;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.szymonharabasz.miniforum.service.UsersService;
import com.szymonharabasz.miniforum.viewmodel.AddUserFormBacking;

@Controller
@RequestMapping(value="/users")
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@RequestMapping("/all")
	String showAllUsers(Model model) {
		model.addAttribute("users", usersService.getAllUsers());
		return "showallusers";
	}
	
	@RequestMapping("/user/{id}")
	String showUserById(@PathVariable long id, Model model) {
		User user = usersService.getUserById(id);
		model.addAttribute(user);
		return "showuser";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	String showAddNewUserForm(Model model) {
		model.addAttribute(new AddUserFormBacking());
		return "adduserform";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	String addNewUser(AddUserFormBacking userToAdd, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "forward:adduserform";
		}
		long id = usersService.getFirstFreeId();
		usersService.saveUser(new User(id, userToAdd.getUsername(), userToAdd.getPassword(),
				userToAdd.getInfo(), new Date()));
		model.addAttribute("success", true);
		return "addusersresult";
	}
}
