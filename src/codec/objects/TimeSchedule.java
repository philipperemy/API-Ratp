package codec.objects;

import constants.Constants.Id;
import constants.Constants.Station;

public class TimeSchedule
{

    private Station terminus;

    private String  waitTime;

    private Id      id;

    public TimeSchedule()
    {
    }

    public TimeSchedule(Station terminus, String waitTime)
    {
        setTerminus(terminus);
        setWaitTime(waitTime);
    }

    public Station getTerminus()
    {
        return terminus;
    }

    public void setTerminus(Station terminus)
    {
        this.terminus = terminus;
    }

    public String getWaitTime()
    {
        return waitTime;
    }

    public void setWaitTime(String waitTime)
    {
        this.waitTime = waitTime;
    }

    @Override
    public String toString()
    {
        return "{terminus = " + terminus + ", wait time = " + waitTime + "}";
    }

    public Id getId()
    {
        return id;
    }

    public void setId(Id id)
    {
        this.id = id;
    }
}
