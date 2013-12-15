package main;

import persistence.DatabaseAccess;
import persistence.dao.ScheduleDao;
import codec.decoders.JsonScheduleDecoder;
import codec.objects.Schedules;
import connection.HttpRequestSender;

public class Task
{
    private static DatabaseAccess dao = new DatabaseAccess();
    private String                url;

    public Task(String url)
    {
        setUrl(url);
    }

    public void run() throws Exception
    {
        String response = HttpRequestSender.sendGet(getUrl());
        Schedules schedules = JsonScheduleDecoder.decode(response);
        ScheduleDao scheduleDao = new ScheduleDao(schedules, dao);
        scheduleDao.insert();
    }

    private String getUrl()
    {
        return url;
    }

    private void setUrl(String url)
    {
        this.url = url;
    }

}
