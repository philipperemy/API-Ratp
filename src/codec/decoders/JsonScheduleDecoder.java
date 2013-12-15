package codec.decoders;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import codec.helpers.JsonDecoderHelper;
import codec.objects.CodecConstants;
import codec.objects.Schedules;
import codec.objects.TimeSchedule;
import constants.Constants;

public class JsonScheduleDecoder
{

    public static Schedules decode(String schedulesJsonString) throws ParseException
    {
        Schedules schedules = new Schedules();
        schedules.setDestination(Constants.Station.fromString(JsonDecoderHelper.decodeString(schedulesJsonString, CodecConstants.DESTINATION_KEY)));
        schedules.setLine(Constants.Line.fromString(JsonDecoderHelper.decodeString(schedulesJsonString, CodecConstants.LINE_KEY)));
        schedules.setStation(Constants.Station.fromString(JsonDecoderHelper.decodeString(schedulesJsonString, CodecConstants.STATION_KEY)));

        JSONArray timeSchedules = JsonDecoderHelper.decodeArray(schedulesJsonString, CodecConstants.HORAIRES_KEY);
        for (Object timeSchedule : timeSchedules)
        {
            if (timeSchedule instanceof JSONObject)
            {
                TimeSchedule ts = new TimeSchedule();

                String terminus = ((JSONObject) timeSchedule).get(CodecConstants.TERMINUS_KEY).toString();

                ts.setTerminus(Constants.Station.fromString(terminus));

                Object waitTimeObj = ((JSONObject) timeSchedule).get(CodecConstants.WAIT_TIME_KEY);
                if (waitTimeObj != null)
                {
                    // METRO
                    ts.setWaitTime(waitTimeObj.toString());
                }
                else
                {
                    // RER
                    ts.setWaitTime(((JSONObject) timeSchedule).get(CodecConstants.HORAIRES_KEY).toString());
                }

                Object idObj = ((JSONObject) timeSchedule).get(CodecConstants.ID_KEY);
                if (idObj != null)
                {
                    // RER
                    ts.setId(Constants.Id.fromString(idObj.toString()));
                }

                schedules.addTimeSchedule(ts);
            }
        }
        return schedules;

    }

}
