package FullStack.FinalProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/admin_panel")
    public String adminPanelPage() {
        return "adminPanelPage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/usersPage")
    public String AllUsersPage() {
        return "allUsersPage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addUserPage")
    public String addUserPageAdmin() {
        return "addUserPageAdmin";
    }


}
