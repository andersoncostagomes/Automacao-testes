package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetBookingRequest {

    @Step("Verificar se API está online")
    public Response ping(){
        return given()
                .when()
                .get("ping");
    }

    @Step("Buscar todas as reservas")
    public Response allBookings(){
        return given()
                .when()
                .get("booking");
    }

    @Step("Buscar reserva específica")
    public Response specificBooking(){
        return given()
                .when()
                .get("booking/10");

    }

    @Step("Listar IDs de reservas utilizando o filtro firstname")
    public Response firstnameBooking(){
        return given()
                .when()
                .queryParam("firstname", "Mark")
                .get("booking/");

    }

    @Step("Listar IDs de reservas utilizando o filtro lastname")
    public Response lastnameBooking(){
        return given()
                .when()
                .queryParam("lastname", "Brown")
                .get("booking/");

    }

    @Step("Listar IDs de reservas utilizando o filtro checkin")
    public Response checkinBooking(){
        return given()
                .when()
                .queryParam("checkin", "2020-01-01")
                .get("booking/");

    }

    @Step("Listar IDs de reservas utilizando o filtro checkout")
    public Response checkoutBooking(){
        return given()
                .when()
                .queryParam("checkout", "2020-01-01")
                .get("booking/");

    }

    @Step("Listar IDs de reservas utilizando o filtros checkin e checkout")
    public Response checkinAndCheckoutBooking(){
        return given()
                .when()
                .queryParam("checkin", "2019-10-10")
                .queryParam("checkout", "2020-01-01")
                .get("booking/");

    }

    @Step("Listar IDs de reservas utilizando o filtros name, checkin e checkout")
    public Response nameCheckinAndCheckoutBooking(){
        return given()
                .when()
                .queryParam("firstname", "Mark")
                .queryParam("lastname", "Brown")
                .queryParam("checkin", "2017-01-10")
                .queryParam("checkout", "2017-08-01")
                .get("booking/");

    }

    @Step("Visualizar erro de servidor 500 quando enviar filtro mal formatado")
    public Response bookingWrongFilter(){
        return given()
                .when()
                .queryParam("checkout", "20170801")
                .get("booking/");
    }

}
