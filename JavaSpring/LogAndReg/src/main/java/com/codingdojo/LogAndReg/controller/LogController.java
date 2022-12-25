package com.codingdojo.LogAndReg.controller;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.LogAndReg.models.LoginUser;
import com.codingdojo.LogAndReg.models.User;
import com.codingdojo.LogAndReg.repositores.UserRepository;
import com.codingdojo.LogAndReg.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

    
@Controller
public class LogController {
    
    @Autowired
    private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
//        	to add NewLogin for the second form in our jsp file , so there is no errors show . 
            model.addAttribute("newLogin", new LoginUser()); 
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) { 
            session.invalidate();
            return "redirect:/";

    }
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
        Long user_id = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id);
        model.addAttribute("thisUser", thisUser);
        return "home.jsp";
    }
        else {
            return "redirect:/";
        }
    }
    
    
}