package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserList;
import web.model.User;

@Controller
@RequestMapping("/users")
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
    public String printUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userList.getUserById(id));
        return "userbyid";
    }

    @GetMapping("/new")
    public String saveUser(Model model){
        model.addAttribute("user", new User());
        return "newuser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userList.save(user);
        return "redirect:/users";
    }
}

//<label for="lastName"></label>
//<input type="text" th:field="*{lastName}" id="lastName"/>
//<label for="age"></label>
//<input type="text" th:field="*{age}" id="age"/>

//<p th:text="${user.getLastName()}"></p>
//<p th:text="${user.getAge()}"></p>
