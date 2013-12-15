package test;

import java.util.List;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import codec.decoders.JsonScheduleDecoder;
import codec.objects.Schedules;
import codec.objects.TimeSchedule;
import constants.Constants.Id;
import constants.Constants.Line;
import constants.Constants.Station;

public class SchedulesTest
{

    @Test
    public void testSchedules() throws ParseException
    {
        Schedules schedules = JsonScheduleDecoder
            .decode("{   \"destination\": \"Ch\u00e2teau de Vincennes\", \"ligne\": \"1\",   \"station\": \"hotel de ville\",    \"horaires\":       [           {               \"terminus\":\"Ch\u00e2teau de Vincennes\",             \"attente\": \"2 mn\"           },          {               \"terminus\":\"Ch\u00e2teau de Vincennes\",             \"attente\": \"4 mn\"           },          {               \"terminus\":\"Ch\u00e2teau de Vincennes\",             \"attente\": \"6 mn\"           },          {               \"terminus\":\"Ch\u00e2teau de Vincennes\",             \"attente\": \"8 mn\"           }       ]}");

        Assert.assertEquals(Station.CHATEAU_DE_VINCENNES, schedules.getDestination());
        Assert.assertEquals(Line.LINE_1, schedules.getLine());
        Assert.assertEquals(Station.HOTEL_DE_VILLE, schedules.getStation());

        List<TimeSchedule> timeSchedules = schedules.getTimeSchedules();
        Assert.assertNotNull(timeSchedules);
        Assert.assertEquals(4, timeSchedules.size());

        Assert.assertEquals("2 mn", timeSchedules.get(0).getWaitTime());
        Assert.assertEquals(Station.CHATEAU_DE_VINCENNES, timeSchedules.get(0).getTerminus());

        Assert.assertEquals("4 mn", timeSchedules.get(1).getWaitTime());
        Assert.assertEquals(Station.CHATEAU_DE_VINCENNES, timeSchedules.get(1).getTerminus());

        Assert.assertEquals("6 mn", timeSchedules.get(2).getWaitTime());
        Assert.assertEquals(Station.CHATEAU_DE_VINCENNES, timeSchedules.get(2).getTerminus());

        Assert.assertEquals("8 mn", timeSchedules.get(3).getWaitTime());
        Assert.assertEquals(Station.CHATEAU_DE_VINCENNES, timeSchedules.get(3).getTerminus());
    }

    @Test
    public void testSchedules2() throws ParseException
    {
        Schedules schedules = JsonScheduleDecoder
            .decode("{  \"destination\": \"Charles-de-Gaulle Mitry-Claye\", \"ligne\": \"b\",   \"station\": \"arcueil cachan\",    \"horaires\":       [           {               \"id\": \"EFLA\",               \"terminus\": \"Aeroport Ch.De Gaulle 2\",              \"horaire\": \"Train sans arr\u00eat\"          },          {               \"id\": \"ICAR\",               \"terminus\": \"Mitry-Claye\",              \"horaire\": \"17:04\"          },          {               \"id\": \"EKLI\",               \"terminus\": \"Aeroport Ch.De Gaulle 2\",              \"horaire\": \"17:10\"          },          {               \"id\": \"EFLA\",               \"terminus\": \"Aeroport Ch.De Gaulle 2\",              \"horaire\": \"Train sans arr\u00eat\"          },          {               \"id\": \"ICAR\",               \"terminus\": \"Mitry-Claye\",              \"horaire\": \"17:19\"          },          {               \"id\": \"EKLI\",               \"terminus\": \"Aeroport Ch.De Gaulle 2\",              \"horaire\": \"17:25\"          }       ]}");

        Assert.assertEquals(Station.CHARLES_DE_GAULLE_MITRY_CLAYE, schedules.getDestination());
        Assert.assertEquals(Line.LINE_B, schedules.getLine());
        Assert.assertEquals(Station.ARCUEIL_CACHAN, schedules.getStation());

        List<TimeSchedule> timeSchedules = schedules.getTimeSchedules();
        Assert.assertNotNull(timeSchedules);
        Assert.assertEquals(6, timeSchedules.size());

        Assert.assertEquals("Train sans arrêt", timeSchedules.get(0).getWaitTime());
        Assert.assertEquals(Station.CHARLES_DE_GAULLE_2, timeSchedules.get(0).getTerminus());
        Assert.assertEquals(Id.EFLA, timeSchedules.get(0).getId());

        Assert.assertEquals("17:04", timeSchedules.get(1).getWaitTime());
        Assert.assertEquals(Station.MITRY_CLAYE, timeSchedules.get(1).getTerminus());
        Assert.assertEquals(Id.ICAR, timeSchedules.get(1).getId());

        Assert.assertEquals("17:10", timeSchedules.get(2).getWaitTime());
        Assert.assertEquals(Station.CHARLES_DE_GAULLE_2, timeSchedules.get(2).getTerminus());
        Assert.assertEquals(Id.EKLI, timeSchedules.get(2).getId());

        Assert.assertEquals("Train sans arrêt", timeSchedules.get(3).getWaitTime());
        Assert.assertEquals(Station.CHARLES_DE_GAULLE_2, timeSchedules.get(3).getTerminus());
        Assert.assertEquals(Id.EFLA, timeSchedules.get(3).getId());

        Assert.assertEquals("17:19", timeSchedules.get(4).getWaitTime());
        Assert.assertEquals(Station.MITRY_CLAYE, timeSchedules.get(4).getTerminus());
        Assert.assertEquals(Id.ICAR, timeSchedules.get(4).getId());

        Assert.assertEquals("17:25", timeSchedules.get(5).getWaitTime());
        Assert.assertEquals(Station.CHARLES_DE_GAULLE_2, timeSchedules.get(5).getTerminus());
        Assert.assertEquals(Id.EKLI, timeSchedules.get(5).getId());
    }

}
