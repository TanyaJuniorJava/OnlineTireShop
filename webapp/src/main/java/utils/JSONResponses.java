package utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

/**
 * Created by cube on 20.08.2016.
 */
public final class JSONResponses {
    public static final JSONStreamAware ERROR_INCORRECT_REQUEST;

    static {
        JSONObject response = new JSONObject();
        response.put("errorCode", 1);
        response.put("errorDescription", "Incorrect request");
        ERROR_INCORRECT_REQUEST = JSON.prepare(response);
    }
}
