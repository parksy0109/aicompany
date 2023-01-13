package github.parksy0109.aicompany

import github.parksy0109.aicompany.model.companies
import github.parksy0109.aicompany.model.getCategories
import github.parksy0109.aicompany.model.getCategoryCountData
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AicompanyApplicationTests {

    @Test
    @DisplayName("카테고리_불러오기")
    fun 카테고리_불러오기() {
        val categories = getCategories()
        println(categories)
    }

    @Test
    @DisplayName("그룹바이_테스트")
    fun 그룹바이_테스트() {
        val count = companies.map {
            it.value.category[0] to it.key
        }.toMap()
        val category = getCategoryCountData()

        for (entry in category) {
            println(count[entry.key])
        }
    }

}
