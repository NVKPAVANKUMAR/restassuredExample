package BalanceAPIs;

import ServiceAPI.BalanceAPI;
import Utility.PropertyParsingUtility;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;


public class test_Balance_API {

    private BalanceAPI balanceAPI = new BalanceAPI();
    private String BaseUrl = PropertyParsingUtility.fecthProperityValues("Base_url").toString();

    //HPCL card Balance
    @Test
    public String hpcl_CardBalance() {
        Map<String, String> hpclBalacePayload = balanceAPI.getHpclCardBalancePayload();
        Response resp = given().
                body(hpclBalacePayload).
                when().
                contentType(ContentType.JSON).
                post(BaseUrl + "/api/v1/fleetApp/getHPCLCardBalance");
        try {
            String balance = resp.then().contentType(ContentType.JSON).extract().path("content.value");
            return balance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //IOCL card Balance
    @Test
    public String iocl_CardBalance() {
        Map<String, String> ioclBalacePayload = balanceAPI.getIoclCardBalancePayload();
        Response resp = given().
                body(ioclBalacePayload).
                when().
                contentType(ContentType.JSON).
                post(BaseUrl + "/api/v1/fleetApp/getIoclCardBalance");
        try {
            String balance = resp.then().contentType(ContentType.JSON).extract().path("content.value");
            return balance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //Reliance card Balance
    @Test
    public String reliance_CardBalance() {
        Map<String, String> relianceBalacePayload = balanceAPI.getRelianceCardBalancePayload();
        Response resp = given().
                body(relianceBalacePayload).
                when().
                contentType(ContentType.JSON).
                post(BaseUrl + "/api/v1/fleetApp/getRelianceCardBalance");
        try {
            String balance = resp.then().contentType(ContentType.JSON).extract().path("content.value");
            return balance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Fastag Balance
    @Test
    public float get_Fastag_Balance() {
        Response resp = given().
                when().
                get(String.format(BaseUrl + "/api/v2/fleetApp/fastagBalance/%s/%s",
                        PropertyParsingUtility.fecthProperityValues("fleet_owner_id"),
                        PropertyParsingUtility.fecthProperityValues("fasatgTestTagId")));
        try {
            float fasTag_balance = resp.then().contentType(ContentType.JSON).extract().path("content.balance");
            return fasTag_balance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
