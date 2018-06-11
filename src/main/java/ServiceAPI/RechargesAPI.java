package ServiceAPI;

import Utility.PropertyParsingUtility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RechargesAPI {

    public Map<String, Object> getRelaincePayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("amount", 1.0);
        map.put("cardNumber", PropertyParsingUtility.fecthProperityValues("relianceTestCard").toString());
        map.put("fleetId", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("fleetCardId", PropertyParsingUtility.fecthProperityValues("relianceFleetCardId").toString());
        return map;
    }

    public Map<String, Object> getHpclPayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("amount", 1.0);
        map.put("cardNumber", PropertyParsingUtility.fecthProperityValues("hpclTestCard").toString());
        map.put("fleetId", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("fleetCardId",PropertyParsingUtility.fecthProperityValues("hpclFleetCardId").toString() );
        return map;
    }


    public Map<String, Object> getIoclPayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("amount", 1.0);
        map.put("cardNumber", PropertyParsingUtility.fecthProperityValues("ioclTestCard").toString());
        map.put("fleetId", PropertyParsingUtility.fecthProperityValues("fleet_owner_id").toString());
        map.put("fleetCardId",PropertyParsingUtility.fecthProperityValues("ioclTestCardId").toString() );
        return map;
    }

    public Map<String, Object> getFastagPayload() throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("fastag_id", PropertyParsingUtility.fecthProperityValues("fasatgTestTagId").toString());
        map.put("amount", 1.0);
        return map;
    }


}

