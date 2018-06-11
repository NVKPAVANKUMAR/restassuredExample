package ServiceAPI;

import Utility.PropertyParsingUtility;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;


public class AssignmentAPIs {


    public Object getAddress() throws IOException {
        Response resp = given().
                when().
                contentType(ContentType.JSON).
                get(String.format("https://preprod-boss.blackbuck.com/api/v1/card/fleet/address/%s", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString()));
        return resp.then().contentType(ContentType.JSON).extract().path("content[0]");
    }


    public Map<String, Object> getIoclCardAssignmentPayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "Delivery");
        map.put("address_id", PropertyParsingUtility.fecthProperityValues("address_id").toString());
        map.put("fleet_owner_id", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("truck_id", 24555);
        map.put("card_type", 1);
        map.put("card_id", 4397);
        map.put("address", getAddress());
        return map;
    }

    public Map<String, Object> getHpclCardAssignmentPayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "Delivery");
        map.put("address_id", PropertyParsingUtility.fecthProperityValues("address_id").toString());
        map.put("fleet_owner_id", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("truck_id", 24688);
        map.put("card_type", 2);
        map.put("card_id", 33661);
        map.put("address", getAddress());
        return map;
    }



    public Map<String, Object> getRelianceCardAssignmentPayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "Delivery");
        map.put("address_id", PropertyParsingUtility.fecthProperityValues("address_id").toString());
        map.put("fleet_owner_id", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("truck_id", 24557);
        map.put("card_type", 3);
        map.put("card_id", 52795);
        map.put("address", getAddress());
        return map;
    }




    public Map<String, Object> getTagAssignmentPayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status_id", "2");
        map.put("address_id", PropertyParsingUtility.fecthProperityValues("address_id").toString());
        map.put("fleet_id", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("truck_id", 24655);
        map.put("fastag_id", 209);
        return map;
    }


    public Map<String, Object> getGpsAssignmentPayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gps_req_id", 153);
        map.put("address_id", PropertyParsingUtility.fecthProperityValues("address_id").toString());
        map.put("fleet_id", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("vehicle_model", "Alto");
        map.put("vehicle_chassis_no", 123345);
        map.put("status_id", 2);
        map.put("update", true);
        return map;
    }
}
