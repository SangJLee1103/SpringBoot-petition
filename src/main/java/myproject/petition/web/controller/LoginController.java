package myproject.petition.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myproject.petition.domain.login.LoginService;
import myproject.petition.domain.member.Member;
import myproject.petition.web.SessionConst;
import myproject.petition.web.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("login")
    private String loginForm(@ModelAttribute("loginForm")LoginForm form){
        return "login/loginForm";
    }

    @PostMapping("login")
    private String login(@Validated @ModelAttribute LoginForm form, BindingResult result,
                         @RequestParam(defaultValue = "/") String redirectURL,
                         HttpServletRequest request, Model model){


        if (result.hasErrors()) {
            return "login/loginForm";
        }

        Member loginMember = loginService.checkLogin(form.getLoginId(), form.getPassword());

        if (loginMember == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "login/loginForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        model.addAttribute("loginMember", loginMember);
        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logoutV3(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();//세션안에 데이터 전부 날아감
        }
        return "redirect:/";
    }
}
