package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserList;

@Controller
@RequestMapping("users")
public class UsersController {

    private final UserList userList;

    @Autowired
    public UsersController(UserList userList) {
        this.userList = userList;
    }

    @GetMapping()
    public String printUsers(Model model) {
        model.addAttribute("users", userList.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String printUserById(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userList.getUserById(id));
        return "userbyid";
    }
}

