package github.parksy0109.aicompany

import github.parksy0109.aicompany.model.companies
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class Controller {

    @GetMapping("/introduction/{name}")
    fun introduction(model: Model, @PathVariable name: String): String {
        companies[name]?.let {
            model.addAttribute("company", it)
        }

        return "introduction"
    }

}