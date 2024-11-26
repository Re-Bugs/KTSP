package com.zeroone.ktsp.controller.pub;

import com.zeroone.ktsp.DTO.LoginDTO;
import com.zeroone.ktsp.DTO.RegisterDTO;
import com.zeroone.ktsp.domain.User;
import com.zeroone.ktsp.enumeration.UserLevel;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/learning_core")
    public String learningCore(Model model)
    {
        model.addAttribute("currentMenu", "description");
        return "main_pages/learning_core";
    }

    @GetMapping("/major_learner")
    public String majorLearner(Model model)
    {
        model.addAttribute("currentMenu", "description");
        return "main_pages/major_learner";
    }

    @GetMapping("/project_contest")
    public String challengeLearner(Model model)
    {
        model.addAttribute("currentMenu", "description");
        return "main_pages/project_contest";
    }

    @GetMapping("/introduction")
    public String introduction(Model model)
    {
        model.addAttribute("currentMenu", "introduction");
        return "community/introduction";
    }

    @GetMapping("/login")
    public String showLogin(Model model)
    {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login/login";
    }

    @GetMapping("/register")
    public String showRegister(Model model)
    {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "login/register";
    }

    @GetMapping("/mypage")
    public String showMypage(Model model, HttpSession session)
    {
        if(session != null)
        {
            User user = (User)session.getAttribute("user");
            String levelText = convertUserLevel(user.getLevel());

            model.addAttribute("user", user);
            model.addAttribute("levelText", levelText);
        }
        model.addAttribute("currentMenu", "mypage_main");
        return "my_page/mypage";
    }

    private String convertUserLevel(UserLevel level) {
        switch (level) {
            case freshman: return "1학년";
            case sophomore: return "2학년";
            case junior: return "3학년";
            case senior: return "4학년";
            default: return "기타";
        }
    }
}
