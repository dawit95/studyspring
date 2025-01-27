package studyspring.hellospring

import java.util.Arrays

class Sort {
    fun playSort() {
        val scores = Arrays.asList("z", "x", "spring", "kotlin")
        scores.sortWith { o1, o2 -> o1.length - o2.length }

        scores.forEach(::println)
    }
}