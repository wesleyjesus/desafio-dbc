package in.reqres.Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import in.reqres.Dados.DadosUsuario;
import in.reqres.Utils.BaseApiTest;

public class UsuarioTest extends BaseApiTest {
    
    /**
     * Teste para cadastro de usuário, informando
     * name e job
     */
    @Test
    public void testCadastrarUsuario() {

        DadosUsuario usuario = new DadosUsuario("wesley", "qa-lead");
        
        given()   
            .body(usuario)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", is("wesley")) ;
    }

    /**
     * Teste para listar usuários, informando os parametros 
     * page e per_page
     */
    @Test
    public void testListarTodosUsuarios() {
        
        given()
            .formParam("page", 1)
            .formParam("per_page", 3)
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("data.first_name", hasItem("George")) ; // Verifica se o usuário George está na lista retornada
    }

    /**
     * Teste para listar usuários, informando o parametro 
     * id
     */
    @Test
    public void testListarUmUsuario() {
        
        given()
            .formParam("id", 1)
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("data.first_name", is("George")) ; // Verifica se o usuário com o id 1 é o George
    }

    /**
     * Teste para atualizar usuario, informando o parametro 
     * id para informar o usuário que será atualizado
     */
    @Test
    public void atualizarUsuario() {
        
        DadosUsuario usuario = new DadosUsuario("wesley", "qa lead");

        given()
            .header("id", 2)
            .body(usuario)
        .when()
            .put("/users/")
        .then()
            .statusCode(200)
            .body("updatedAt", is(not(nullValue()))); // Valida se o campo updatedAt não está nulo.
    }
    
    /**
     * Teste para excluir usuario, informando o parametro 
     * id para informar o usuário que será excluído
     */
    @Test
    public void excluirUsuario() {

        given()
            .header("id", 1)
        .when()
            .delete("/users")
        .then()
            .statusCode(204);
    }

}
