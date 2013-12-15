package codec.objects;

import constants.Constants.Line;
import constants.Constants.Station;
import constants.Constants.Type;

public class Query
{
    public static String createQuery(Type type, Line line, Station station, Station destination)
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(CodecConstants.RATP_WEB_SERVICES_KEY);
        sBuilder.append(urlEncode(type.toString().toLowerCase()) + "/");
        sBuilder.append(urlEncode(line.toString()) + "/");
        sBuilder.append(urlEncode(station.toString()) + "/");
        sBuilder.append(urlEncode(destination.toString()));
        return sBuilder.toString();
    }

    private static String urlEncode(String str)
    {
        return str;
    }
}
