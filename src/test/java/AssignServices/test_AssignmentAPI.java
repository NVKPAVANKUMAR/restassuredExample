package AssignServices;

import ServiceAPI.AssignmentAPIs;
import Utility.PropertyParsingUtility;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class test_AssignmentAPI {


    private String BaseUrl = PropertyParsingUtility.fecthProperityValues("Base_url").toString();
    private AssignmentAPIs assignmentAPIs = new AssignmentAPIs();

    //Update Fleet card(HPCL)
    @Test
    public void hpclCardAssignment() throws IOException {
        Map<String, Object> cardAssignmentPayload = assignmentAPIs.getHpclCardAssignmentPayload();
        Response resp = given().
                body(cardAssignmentPayload).
                when().
                contentType(ContentType.JSON).
                put(String.format(BaseUrl + "/api/v1/card/cms/%s",
                        PropertyParsingUtility.fecthProperityValues("fleet_owner_id")));
        //  resp.prettyPrint();
        //  System.out.println("card Assignment API Response code : " + resp.statusCode());
    }

    //Update Fleet card(IOCl)
    @Test
    public void ioclCardAssignment() throws IOException {
        Map<String, Object> cardAssignmentPayload = assignmentAPIs.getHpclCardAssignmentPayload();
        Response resp = given().
                body(cardAssignmentPayload).
                when().
                contentType(ContentType.JSON).
                put(String.format(BaseUrl + "/api/v1/card/cms/%s",
                        PropertyParsingUtility.fecthProperityValues("fleet_owner_id")));
        //  resp.prettyPrint();
        //  System.out.println("card Assignment API Response code : " + resp.statusCode());
    }

    //Update Fleet card(Reliance)
    @Test
    public void relianceCardAssignment() throws IOException {
        Map<String, Object> cardAssignmentPayload = assignmentAPIs.getHpclCardAssignmentPayload();
        Response resp = given().
                body(cardAssignmentPayload).
                when().
                contentType(ContentType.JSON).
                put(String.format(BaseUrl + "/api/v1/card/cms/%s",
                        PropertyParsingUtility.fecthProperityValues("fleet_owner_id")));
        //  resp.prettyPrint();
        //  System.out.println("card Assignment API Response code : " + resp.statusCode());
    }

    //Update Fleet Fastag
    @Test
    public void tagAssignment() throws IOException {
        Map<String, Object> tagAssignmentPayload = assignmentAPIs.getTagAssignmentPayload();
        Response resp = given().
                body(tagAssignmentPayload).
                when().
                contentType(ContentType.JSON).
                put(BaseUrl + "/api/v1/cms/fastag");
        resp.prettyPrint();
        System.out.println("TAG Assignment API Response code : " + resp.statusCode());
    }

    //Update Fleet Fastag
    @Test
    public void gpsAssignment() throws IOException {
        Map<String, Object> gpsAssignmentPayload = assignmentAPIs.getGpsAssignmentPayload();
        Response resp = given().
                body(gpsAssignmentPayload).
                when().
                contentType(ContentType.JSON).
                put(BaseUrl + "/api/v1/cms/gps");
        resp.prettyPrint();
        System.out.println("GPS Assignment API Response code : " + resp.statusCode());
    }


}



