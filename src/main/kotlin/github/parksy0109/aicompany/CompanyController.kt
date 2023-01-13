package github.parksy0109.aicompany

import github.parksy0109.aicompany.model.getCategoryCountData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CompanyController {

    @GetMapping("/companies/categories/count")
    fun getCountGroupingByCategories(): Map<String, Int> {
        return getCategoryCountData()
    }

}