package techorda.bitlab.FinalProjectOfFinal.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String customerPage() {
        return "customerPage";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "{id}")
    public String cartPage(@PathVariable(name = "id") Long id) {
        return "customerCategoryPage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/customerOrders")
    public String customerOrdersPage() {
        return "customerOrderPage";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/userOrders")
    public String userOrdersPage() {
        return "userOrdersPage";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/userOrderDetailsPage")
    public String userOrderDetailsPage() {
        return "userOrderDetailsPage";
    }


}
