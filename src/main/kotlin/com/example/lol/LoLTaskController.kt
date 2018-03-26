package com.example.lol

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("lol")
//class LoLTaskController(private val runeRepository: RuneRepository) {
class LoLTaskController(private val dataRepository: DataRepository) {
    @GetMapping("")
    fun index(model: Model): String {
//        val rune = listOf(
//                Rune("a", 1, "b", "c", "d", "e"),
//                Rune("aa", 2, "bb", "cc", "dd", "ee")
//        )

// APIが使用できなくなったらコメントアウト
//        val rune = runeRepository.getRune()
//        model.addAttribute("rune", rune)
        return "lol/index2"
    }

    @GetMapping("champ")
    fun champ(model: Model): String {
        val champ = dataRepository.getChampion()
        model.addAttribute("champ", champ)
        return "lol/champ2"
    }

    @GetMapping("rune")
    fun rune(model: Model): String {
        val rune = dataRepository.getRune()
        model.addAttribute("rune", rune)
        return "lol/rune"
    }

    @GetMapping("champ/{id}")
    fun selectChamp(@PathVariable("id") id: String,
                    model: Model): String {
        println("selectChamp")
        println(id)

//        val rune = dataRepository.getRune()
//        model.addAttribute("rune", rune)
        return "lol/index2"
    }
}