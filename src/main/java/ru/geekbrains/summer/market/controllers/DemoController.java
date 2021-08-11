//package ru.geekbrains.summer.market.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.geekbrains.summer.market.model.User;
//import ru.geekbrains.summer.market.services.UserService;
//
//import java.security.Principal;
//
//@RestController
//@RequiredArgsConstructor
//public class DemoController {
//    private final UserService userService;
//
//    @GetMapping("/home")
//    public String homePage(){
//        return "Home";
//    }
//
//    @GetMapping("/unsecured")
//    public String unsecuredPage(){
//        return "unsecured";
//    }
//
//    @GetMapping("/auth_page")
//    public String authPage(){
//        return "authenticated";
//    }
//
//    @GetMapping("/admin")
//    //@PreAuthorize("hasRole('ADMIN')")
//    public String adminPage(){
//        return "admin";
//    }
//
//    @GetMapping("/user_read_all_message")
//    public String readAllMessage(){
//        return "<html><h1>AllMessage</h1></html>";
//    }
//
//    @GetMapping("/user_info")
//    public String daoTestPage(Principal principal) {
//    User user = userService.findUserByUsername(principal.getName()).orElseThrow(()-> new RuntimeException("Unable to find us"));
//    return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail();
//    }
//}
