package com.example.lol

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ContextResource
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.io.FileInputStream



@Repository
class RuneRepository {
//    fun getRune(): List<Rune> {

    fun getRune(): Champion {
        // RESTでデータ取得
        val url = "https://jp1.api.riotgames.com/lol/static-data/v3/champions?locale=ja_JP&tags=image&dataById=false&api_key=RGAPI-a502e1f3-fb65-4f69-b44e-0efebe54f36e"
//        val restTemplate: RestTemplate = RestTemplate()
//        println(restTemplate.exchange(url, HttpMethod.GET, null, String::class.java))
//        val champ: Champion = restTemplate.getForObject(url, Champion::class.java)
//        println(champ)
//        println(restTemplate.getForObject(url, Champion::class.java))

        // JSONファイルからデータ取得
        val filePath = "C:\\Users\\SNOW\\Desktop\\lol\\lol\\src\\main\\resources\\static\\json\\champ.json"
//        val file = File("/usr/local/test.csv")
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
//        val jsonFile = File("./json/champ.json").absoluteFile
//        val lines = jsonFile.readLines().filter(String::isNotBlank)
//                .toList()
//        println("json output start")
//        println(lines)
//        println("json output end")
//        val mapper3 = jacksonObjectMapper()
//        val champ = mapper3.readValue<Champion>(jsonFile)
//        println(champ)

//        with(obj.openConnection() as HttpURLConnection) {
//            requestMethod = "GET"
//
//            println("\nSending 'GET' request to URL : $url")
//            println("Rsponse Code : $responseCode")
//
//            BufferedReader(InputStreamReader(inputStream)).use {
//                val response = StringBuffer()
//
//                var inputLine = it.readLine()
//                while (inputLine != null) {
//                    inputLine = it.readLine()
//                    response.append(inputLine)
//                }
//                println(response.toString())
//            }
//        }
        val json = "{\n" +
                "    \"iconPath\": \"/lol-game-data/assets/v1/perk-images/Styles/Precision/DangerousGame.png\",\n" +
                "    \"id\": 9111,\n" +
                "    \"longDesc\": \"Takedowns restore 15% of your missing health and grant an additional 25 gold. <br><br><hr></hr><br><i>'The most dangerous game brings the greatest glory.' <br>—Noxian Reckoner</i>\",\n" +
                "    \"name\": \"Triumph\",\n" +
                "    \"shortDesc\": \"<lol-uikit-tooltipped-keyword key=\\\"LinkTooltip_Description_Takedown\\\">Takedowns</lol-uikit-tooltipped-keyword> restore 15% of your missing health and grant an additional 25 gold. \",\n" +
                "    \"tooltip\": \"Takedowns restore 15% of your missing health and grant an additional 25 gold. <br><hr><br>Total health restored: <scaledAD>@f1@</scaleAD><br>Total bonus gold granted: <scaledAD>@f2@</scaleAD>\"\n" +
                "  }"
        val mapper = jacksonObjectMapper()

        val rune = mapper.readValue<Rune>(json)

        val json2 = "{\n" +
                "    \"iconPath\": \"/lol-game-data/assets/v1/perk-images/Styles/Precision/DangerousGame.png\",\n" +
                "    \"id\": 9111,\n" +
                "    \"longDesc\": \"Takedowns restore 15% of your missing health and grant an additional 25 gold. <br><br><hr></hr><br><i>'The most dangerous game brings the greatest glory.' <br>—Noxian Reckoner</i>\",\n" +
                "    \"name\": \"Triumph\",\n" +
                "    \"shortDesc\": \"<lol-uikit-tooltipped-keyword key=\\\"LinkTooltip_Description_Takedown\\\">Takedowns</lol-uikit-tooltipped-keyword> restore 15% of your missing health and grant an additional 25 gold. \",\n" +
                "    \"tooltip\": \"Takedowns restore 15% of your missing health and grant an additional 25 gold. <br><hr><br>Total health restored: <scaledAD>@f1@</scaleAD><br>Total bonus gold granted: <scaledAD>@f2@</scaleAD>\"\n" +
                "  }"
        val mapper2 = jacksonObjectMapper()

        val rune2 = mapper.readValue<Rune>(json)


        val runes = listOf(rune, rune2)
//        return runes
        return champ
    }

}