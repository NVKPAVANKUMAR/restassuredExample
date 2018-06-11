package WalletBalanceAPI;

import Utility.PropertyParsingUtility;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class test_WalletBalanceAPI {

    private String BaseUrl = PropertyParsingUtility.fecthProperityValues("Base_url").toString();

    //Get Wallet
    public float get_Wallet() {
        Response resp = given().param("user_id", PropertyParsingUtility.fecthProperityValues("fleet_user_id").toString()).
                when().
                get(BaseUrl + "/api/v1/fleetApp/balance/");
        Float balance = resp.then().contentType(ContentType.JSON).extract().path("content.value");
        return balance;
    }
}
