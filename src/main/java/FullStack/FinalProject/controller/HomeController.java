package FullStack.FinalProject.controller;

import FullStack.FinalProject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import FullStack.FinalProject.services.UserService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping(value = "/")
    public String indexPage() {
        return "index";
    }

    @GetMapping(value = "/sign_in_page")
    public String signInPage() {
        return "signInPage";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage() {
        return "profile";
    }

    @GetMapping(value = "/403_page")
    public String accessDenied() {
        return "accessDenied";
    }

    @GetMapping(value = "/sign_up_page")
    public String signUpPage() {
        return "signUpPage";
    }

    @PostMapping(value = "/to_sign_up")
    public String toSignUp(
            @RequestParam(name = "user_email") String email,
            @RequestParam(name = "user_password") String password,
            @RequestParam(name = "user_repeat_password") String repeatPassword,
            @RequestParam(name = "user_full_name") String fullName) {

        if (password.equals(repeatPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setFullName(fullName);
            User newUser = null;
            try {
                newUser = userService.addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (newUser != null) {
                return "redirect:/sign_up_page?success";
            } else {
                return "redirect:/sign_up_page?emailerror";
            }
        } else {
            return "redirect:/sign_up_page?passworderror";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/change_password_page")
    public String changePasswordPage() {
        return "changePassword";
    }


    @PostMapping(value = "/to_change_password")
    public String changePassword(
            @RequestParam(name = "user_old_password") String oldPassword,
            @RequestParam(name = "user_new_password") String newPassword,
            @RequestParam(name = "user_new_repeat_password") String newRepeatPassword) {

        if (newPassword.equals(newRepeatPassword)) {
            User user = userService.changePassword(oldPassword, newPassword);
            if (user != null) {
                return "redirect:/change_password_page?success";
            } else {
                return "redirect:/change_password_page?oldpassworderror";
            }
        } else {
            return "redirect:/change_password_page?passwordmismatch";
        }
    }


}
