package codec.helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDecoderHelper
{

    private static JSONParser parser = new JSONParser();

    public static String decodeString(String jsonString, String parameter) throws ParseException
    {
        JSONObject json = (JSONObject) parser.parse(jsonString);
        return (String) json.get(parameter);
    }

    public static JSONArray decodeArray(String jsonString, String parameter) throws ParseException
    {
        JSONObject json = (JSONObject) parser.parse(jsonString);
        return (JSONArray) json.get(parameter);
    }
}
