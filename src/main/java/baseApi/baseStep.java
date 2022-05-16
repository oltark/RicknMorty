package baseApi;


import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class baseStep {

public static String jsonId;

    public static void getInfoFromBase() throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("https://rickandmortyapi.com/api/character/2"))));
        Response gettingInfo = given()
                .header("Content-type", "application/json")
                .header("charset","UTF-8")
                .body(body.toString())
                .baseUri("Some URL")
                .when()
                .get("Some Character")
                .then()
                .extract()
                .response();
        jsonId = new JSONObject(gettingInfo.getBody().asString()).getJSONObject("session").get("value").toString();
        System.out.println(jsonId);

    }

}
