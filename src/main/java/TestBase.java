import com.github.javafaker.Faker;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;


import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public RequestSpecification REQUEST;
    public Faker FAKER = new Faker();

    public TestBase() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

            //Rest Assured config
            RestAssured.baseURI = props.getProperty("api.uri");
            RestAssured.port = Integer.valueOf(props.getProperty("api.port"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //basic request setting
        REQUEST = RestAssured.given().contentType(ContentType.JSON);
    }
}
