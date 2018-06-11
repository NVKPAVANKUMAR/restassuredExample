package ServiceAPI;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;
import Utility.PropertyParsingUtility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class BalanceAPI {

    public Map<String, String> getHpclCardBalancePayload(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("cardNumber",PropertyParsingUtility.fecthProperityValues("hpclTestCard").toString());
        map.put("fleetCardId", PropertyParsingUtility.fecthProperityValues("hpclFleetCardId").toString());
        return map;
    }


    public Map<String, String> getIoclCardBalancePayload(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("cardNumber",PropertyParsingUtility.fecthProperityValues("ioclTestCard").toString());
        map.put("fleetCardId", PropertyParsingUtility.fecthProperityValues("ioclTestCardId").toString());
        return map;
    }


    public Map<String, String> getRelianceCardBalancePayload(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("cardNumber",PropertyParsingUtility.fecthProperityValues("relianceTestCard").toString());
        map.put("fleetId",PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("fleetCardId", PropertyParsingUtility.fecthProperityValues("relianceFleetCardId").toString());
        return map;
    }


    public Map<String, String> getFastagBalancePayload(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("cardNumber",PropertyParsingUtility.fecthProperityValues("relianceTestCard").toString());
        map.put("fleetId",PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("fleetCardId", PropertyParsingUtility.fecthProperityValues("relianceFleetCardId").toString());
        return map;
    }
}
