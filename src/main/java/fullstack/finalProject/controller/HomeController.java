package fullstack.finalProject.controller;

import fullstack.finalProject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fullstack.finalProject.services.UserService;

import java.util.Objects;

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
        @RequestParam(name = "user_email") final String email,
        @RequestParam(name = "user_password") final String password,
        @RequestParam(name = "user_repeat_password") final String repeatPassword,
        @RequestParam(name = "user_full_name") final String fullName
    ) {
        if (password.equals(repeatPassword)) {
            final User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setFullName(fullName);
            User newUser = null;
            try {
                newUser = userService.addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (Objects.nonNull(newUser)) {
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
        @RequestParam(name = "user_old_password") final String oldPassword,
        @RequestParam(name = "user_new_password") final String newPassword,
        @RequestParam(name = "user_new_repeat_password") final String newRepeatPassword
    ) {
        final User user = userService.changePassword(oldPassword, newPassword);

        if (newPassword.equals(newRepeatPassword)) {
            if (Objects.nonNull(user)) {
                return "redirect:/change_password_page?success";
            } else {
                return "redirect:/change_password_page?oldpassworderror";
            }
        } else {
            return "redirect:/change_password_page?passwordmismatch";
        }
    }

}
