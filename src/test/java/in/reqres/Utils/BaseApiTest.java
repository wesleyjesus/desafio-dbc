package in.reqres.Utils;


import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class BaseApiTest implements Constantes {

    /**
     * Classe de setup que roda antes de cada teste, contendo a implementação
     * dos dados padrões para execução dos testes.
     */
    @BeforeClass
    public static void setup(){
        /**
         * Configurar caminho comum de acesso a API REQRES
         */
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
        RestAssured.port = PORT;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    
}
