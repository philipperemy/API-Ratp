package codec.objects;

import java.util.ArrayList;
import java.util.List;
import constants.Constants.Line;
import constants.Constants.Station;

public class Schedules
{
    private Station            destination;

    private Line               line;

    private Station            station;

    private List<TimeSchedule> timeSchedules = new ArrayList<>();

    public Station getDestination()
    {
        return destination;
    }

    public void setDestination(Station destination)
    {
        this.destination = destination;
    }

    public Line getLine()
    {
        return line;
    }

    public void setLine(Line line)
    {
        this.line = line;
    }

    public Station getStation()
    {
        return station;
    }

    public void setStation(Station station)
    {
        this.station = station;
    }

    public List<TimeSchedule> getTimeSchedules()
    {
        return timeSchedules;
    }

    public void addTimeSchedule(TimeSchedule timeSchedule)
    {
        this.timeSchedules.add(timeSchedule);
    }

    @Override
    public String toString()
    {
        StringBuilder sbBuilder = new StringBuilder();
        sbBuilder.append("destination = " + destination + ", ");
        sbBuilder.append("line = " + line + ", ");
        sbBuilder.append("station = " + station + ", ");
        for (TimeSchedule tSchedule : timeSchedules)
        {
            sbBuilder.append(tSchedule + ", ");
        }

        return sbBuilder.toString();
    }

}
