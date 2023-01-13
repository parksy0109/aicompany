package github.parksy0109.aicompany

import github.parksy0109.aicompany.model.companies
import github.parksy0109.aicompany.model.getCategoryCountData
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

    @GetMapping("/category")
    fun category(model: Model): String {
        model.addAttribute("category", getCategoryCountData())
        return "category"
    }

    @GetMapping("/imageslider")
    fun imageSlider(model: Model): String {
        model.addAttribute("category", getCategoryCountData())
        return "imageslider"
    }

}