package fullstack.finalProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addCategoryPage")
    public String addCategoryPage() {
        return "addCategoryPage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/category1/{id}")
    public String categoryPage(@PathVariable(name = "id") final Long id) {
        return "productPage";
    }
}
