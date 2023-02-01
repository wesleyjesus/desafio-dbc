package in.reqres.Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import in.reqres.Dados.DadosLogin;
import in.reqres.Utils.BaseApiTest;
import io.restassured.http.ContentType;

/**
 * OlaMundoTest
 */
public class LoginTest extends BaseApiTest {


    @Test
    public void testRealizarLoginComSucesso() {


        DadosLogin login = new DadosLogin("eve.holt@reqres.in", "testes123456");
        /**
         * Pré-condições para execução do teste.
         * Dados email e password válidos.
         */
        given()
            .body(login)
        .when()
            .post("/login")
        .then()
            .statusCode(200)
            .body("token", is(not(nullValue())));
    }


    @Test
    public void testRealizarLoginComFalha() {
        
        DadosLogin login = new DadosLogin("eve.holt@reqres", "testes123456");
        /**
         * Pré-condições para execução do teste.
         * Informar email inválido
         */
        given()
            .body(login)
        .when()
            .post("/login")
        .then()
            .statusCode(400)
            .body("error", is("user not found"));
    }

    /**
     * 
     */
    @Test
    public void testRealizarLoginSemInformarPassword() {
        
        DadosLogin login = new DadosLogin("eve.holt@reqres", "");
        /**
         * Pré-condição para execução do teste.
         * Não informar o campo password
         */
        given()
            .body(login)
        .when()
            .post("/login")
        .then()
            .statusCode(400)
            .body("error", is("Missing password"));
    }

    /**
     * Pré-condição para execução do teste.
     * Não informar o campo email 
     */
    @Test
    public void testRealizarLoginSemInformarEmail() {
        
        DadosLogin login = new DadosLogin("", "testes123456");

        given()
            .body(login)
            .contentType(ContentType.JSON)
        .when()
            .post("/login")
        .then()
            .statusCode(400)
            .body("error", is("Missing email or username"));
    }

}