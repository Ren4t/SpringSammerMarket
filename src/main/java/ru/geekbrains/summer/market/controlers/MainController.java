package ru.geekbrains.summer.market.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MainController {

    @GetMapping("/nav")
    public String showNavPage() {
        return "nav";
    }

//    @GetMapping("/showMeDemo")
//    @ResponseBody
//    public String demoMethod() {
//        return "Demo";
//    }
//
//
//
//    @GetMapping("/add")
//    public String addTwoNumAndShowResult(Model model,
//                                         @RequestParam(name = "a") int a,
//                                         @RequestParam(name = "b") int b,
//                                         @RequestParam(name = "c") int c )
//    {
//        int result = a + b + c;
//        model.addAttribute("a",a);
//        model.addAttribute("b",b);
//        model.addAttribute("c",c);
//        model.addAttribute("addResult",result);
//        return "result";
//    }
//
//    @GetMapping("/users/{id}/profile")
//    public String showUserProfile(Model model, @PathVariable(name = "id") Long id) {
//        User user = new User(id, "Bob", 30);
//        model.addAttribute("user",user);
//        return "profile";
//    }
//
//    @GetMapping("/users")
//    public String showAllUsers(Model model) {
//        List<User> users = new ArrayList<>(Arrays.asList(
//                new User(1L, "Bob",30),
//                new User(2L, "Jack",35),
//                new User(3L, "Max",32)
//        ));
//        model.addAttribute("users",users);
//        return "users";
//    }
//
//    @GetMapping("/show_add_form")
//    public String showAddForm() {
//
//        return "add_form";
//    }
//
//    @GetMapping("/create_user_form")
//    public String showCreateUserForm() {
//        return "create_user";
//    }
//
//    @PostMapping("/create_new_user")
//    public String createNewUser(Long id,String name,int age) {
//        User user = new User(id, name, age);
//        System.out.println(user);
//        return "redirect:/page";
//    }

}
