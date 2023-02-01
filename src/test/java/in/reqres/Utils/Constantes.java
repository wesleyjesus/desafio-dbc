package in.reqres.Utils;

import io.restassured.http.ContentType;

/**
 * Interface criada contendo as informações padrões utilizadas pelos testes
 */
public interface Constantes {
    
    String BASE_URL = "https://reqres.in/";
    String BASE_PATH = "/api";
    Integer PORT = 443;

    ContentType CONTENT_TYPE = ContentType.JSON;

}
