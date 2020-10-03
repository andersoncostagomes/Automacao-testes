package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {

    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Step("Alterar uma reserva com token")
    public Response alterarReservaComToken(int id, JSONObject payload){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", postAuthRequest.getToken())
                .when()
                .body(payload.toString())
                .put("booking/" + id);
    }

//    @Step("Alterar uma reserva usando o Basic auth")
//    public Response alterarReservaComBasicAuth(int id, JSONObject payload){
//        return given()
//                .auth().basic("Username", "admin")
//                .auth().basic("Password", "password123")
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
//                .when()
//                .body(payload.toString())
//                .put("booking/" + id);
//    }

    @Step("Tentar alterar uma reserva quando o token não for enviado")
    public Response alterarReservaSemToken(int id, JSONObject payload){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .body(payload.toString())
                .put("booking/" + id);
    }

    @Step("Tentar alterar uma reserva quando o token enviado for inválido")
    public Response alterarReservaComTokenInvalido(int id, JSONObject payload){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "12345")
                .when()
                .body(payload.toString())
                .put("booking/" + id);
    }
}
