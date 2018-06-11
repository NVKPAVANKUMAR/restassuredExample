package AddTruckAPIs;

import Utility.PropertyParsingUtility;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

public class test_AddTruck_API {


    String BaseUrl = PropertyParsingUtility.fecthProperityValues("Base_url").toString();

    //Create Truck(CMS)
    @Test
    public void addTruckCMS() {
        Response resp = given().
                multiPart("id_proof", new File("/home/pavan/Downloads/id_2.jpg")).
                multiPart("rc_proof", new File("/home/pavan/Downloads/id_2.jpg")).
                multiPart("rc_proof", new File("/home/pavan/Downloads/id_2.jpg")).
                formParam(String.format("truck_no", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString())).
                when().
                post(BaseUrl + "/api/v1/cms/addTruck/5043");
        if (resp.statusCode() == 200) {
            System.out.println(resp.then().extract().path("message"));
        } else {
            System.out.println("Adding truck failed");
            addTruckCMS();
        }

    }

    //Create Truck(APP)
    @Test
    public void addTruckAPP() throws IOException {
        Response resp = given().
                body(String.format("{ \"fleet_id\": %s," + "\"rc_doc\": [" + " [\"42015_fleet_owner_rc_IMG-20180604-WA0008.jpg\"] " + " ]," + " \"pp_doc\": [\"42015_fleet_owner_per_id_IMG-20180604-WA0001.jpg\"]," + " \"pp_id\": 0," + " \"cp_id\": 1}",
                        PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString())).
                when().
                contentType(ContentType.JSON).
                post(BaseUrl + "/api/v1//fleetApp/create_truck");
        if (resp.statusCode() == 200) {
            System.out.println(resp.then().extract().path("message"));
        } else {
            System.out.println("Adding truck failed");
            addTruckAPP();
        }
    }
}









