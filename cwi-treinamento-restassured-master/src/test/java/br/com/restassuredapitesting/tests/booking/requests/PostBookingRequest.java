package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    @Step("Criar uma nova reserva")
    public Response postBooking(JSONObject payload){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .body(payload.toString())
                .post("booking/");
    }

    @Step("Criar uma nova reserva inválida")
    public Response invalidPostBooking(JSONObject payload){
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "12345")
                .when()
                .body(payload.toString())
                .post("booking/");
    }

}
