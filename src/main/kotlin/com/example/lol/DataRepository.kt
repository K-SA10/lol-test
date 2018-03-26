package com.example.lol

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Repository
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

@Repository
class DataRepository {
    fun getRune(): Rune {
        // RESTでデータ取得
        val url = "https://jp1.api.riotgames.com/lol/static-data/v3/champions?locale=ja_JP&tags=image&dataById=false&api_key=RGAPI-a502e1f3-fb65-4f69-b44e-0efebe54f36e"
//        val restTemplate: RestTemplate = RestTemplate()
//        println(restTemplate.exchange(url, HttpMethod.GET, null, String::class.java))
//        val champ: Champion = restTemplate.getForObject(url, Champion::class.java)
//        println(champ)
//        println(restTemplate.getForObject(url, Champion::class.java))

        // JSONファイルからデータ取得
        val filePath = "C:\\Users\\SNOW\\Desktop\\lol\\lol\\src\\main\\resources\\static\\json\\rune.json"
        val file = File(filePath)
        val input = FileInputStream(file)
        val stream = InputStreamReader(input, "SJIS")
        val buffer = BufferedReader(stream)

        println("json output start")
        var jsonFile = buffer.readText()
        println(jsonFile)
        val mapper3 = jacksonObjectMapper()
        val rune = mapper3.readValue<Rune>(jsonFile)
        println("json output end")
        input.close()
        stream.close()
        buffer.close()

        return rune
    }

    fun getChampion(): Champion {
        // RESTでデータ取得
        val url = "https://jp1.api.riotgames.com/lol/static-data/v3/champions?locale=ja_JP&tags=image&dataById=false&api_key=RGAPI-a502e1f3-fb65-4f69-b44e-0efebe54f36e"
//        val restTemplate: RestTemplate = RestTemplate()
//        println(restTemplate.exchange(url, HttpMethod.GET, null, String::class.java))
//        val champ: Champion = restTemplate.getForObject(url, Champion::class.java)
//        println(champ)
//        println(restTemplate.getForObject(url, Champion::class.java))

        // JSONファイルからデータ取得
        val filePath = "C:\\Users\\SNOW\\Desktop\\lol\\lol\\src\\main\\resources\\static\\json\\champ.json"
        val file = File(filePath)
        val input = FileInputStream(file)
        val stream = InputStreamReader(input, "SJIS")
        val buffer = BufferedReader(stream)

        println("json output start")
        var jsonFile = buffer.readText()
        println(jsonFile)
        val mapper3 = jacksonObjectMapper()
        val champ = mapper3.readValue<Champion>(jsonFile)
        println("json output end")
        input.close()
        stream.close()
        buffer.close()

        return champ
    }
}