package RechargeAPIs;

import BalanceAPIs.test_Balance_API;
import ServiceAPI.RechargesAPI;
import Utility.PropertyParsingUtility;
import WalletBalanceAPI.test_WalletBalanceAPI;
import com.jayway.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class test_Recharges_API {

    private RechargesAPI rechargesAPI = new RechargesAPI();
    private test_Balance_API balanceAPI = new test_Balance_API();
    private test_WalletBalanceAPI walletBalanceAPI = new test_WalletBalanceAPI();
    private String BaseUrl = PropertyParsingUtility.fecthProperityValues("Base_url").toString();

    //Reliance Recharge
    @Test
    public void reliance_CardRecharge() throws IOException {
        float walletBalance = walletBalanceAPI.get_Wallet();
        if (walletBalance > Integer.parseInt(PropertyParsingUtility.fecthProperityValues("rechargeAmount").toString())) {
            String initialBalance = balanceAPI.reliance_CardBalance();
            Map<String, Object> reliancePayload = rechargesAPI.getRelaincePayload();
            given().
                    body(reliancePayload).
                    when().
                    post(BaseUrl + "/api/v1/fleetApp/rechargeRelianceCard").then().assertThat().statusCode(200).and().
                    contentType(ContentType.JSON);
            String finalBalance = balanceAPI.reliance_CardBalance();
            Assert.assertEquals(initialBalance, finalBalance);
        } else {
            System.out.println("sufficient wallet balance not available to recharge");
        }
    }

    //HPCL Recharge
    @Test
    public void hpcl_CardRecharge() throws IOException {
        float walletBalance = walletBalanceAPI.get_Wallet();
        if (walletBalance > Integer.parseInt(PropertyParsingUtility.fecthProperityValues("rechargeAmount").toString())) {
            String initialBalance = balanceAPI.hpcl_CardBalance();
            Map<String, Object> hpclPayload = rechargesAPI.getHpclPayload();
            given().
                    body(hpclPayload).
                    when().
                    contentType(ContentType.JSON).
                    post(BaseUrl + "/api/v1/fleetApp/rechargeHPCLCard").then().assertThat().statusCode(200).and().
                    contentType(ContentType.JSON);
            String finalBalance = balanceAPI.hpcl_CardBalance();
            Assert.assertEquals(initialBalance, finalBalance);
        } else {
            System.out.println("sufficient wallet balance not available to recharge");
        }

    }

    //IOCL Recharge
    @Test
    public void iocl_CardRecharge() throws IOException {
        float walletBalance = walletBalanceAPI.get_Wallet();
        if (walletBalance > Integer.parseInt(PropertyParsingUtility.fecthProperityValues("rechargeAmount").toString())) {
            String initialBalance = balanceAPI.iocl_CardBalance();
            Map<String, Object> ioclPayload = rechargesAPI.getIoclPayload();
            given().
                    body(ioclPayload).
                    when().
                    post(BaseUrl + "/api/v1/fleetApp/rechargeCard").then().assertThat().statusCode(200).and().
                    contentType(ContentType.JSON);
            String finalBalance = balanceAPI.iocl_CardBalance();
            Assert.assertEquals(initialBalance, finalBalance);
        } else {
            System.out.println("sufficient wallet balance not available to recharge");
        }
    }

    //Fastag Recharge
    @Test
    public void fastag_Recharge() throws IOException {
        float walletBalance = walletBalanceAPI.get_Wallet();
        if (walletBalance > Integer.parseInt(PropertyParsingUtility.fecthProperityValues("rechargeAmount").toString())) {
            Map<String, Object> fastagPayload = rechargesAPI.getFastagPayload();
            float initialBalance = balanceAPI.get_Fastag_Balance();
            given().
                    body(fastagPayload).
                    when().
                    contentType(ContentType.JSON).
                    post(String.format(BaseUrl + "/api/v2/fleetApp/fastagRecharge/%s/%s",
                            PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString(),
                            PropertyParsingUtility.fecthProperityValues("fastagAttchedTruckId").toString())).then().assertThat().statusCode(200).and().
                    contentType(ContentType.JSON);
            float finalBalance = balanceAPI.get_Fastag_Balance();
            Assert.assertEquals(initialBalance, finalBalance);
        } else {
            System.out.println("sufficient wallet balance not available to recharge");
        }
    }


}
