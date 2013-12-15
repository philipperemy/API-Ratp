package persistence.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import codec.objects.Schedules;
import codec.objects.TimeSchedule;
import constants.Constants.Id;
import constants.Constants.Line;
import constants.Constants.Station;
import persistence.DatabaseAccess;

public class ScheduleDao
{
    private BigInteger     id;
    private LineDao        line;
    private StationDao     station;
    private StationDao     destination;
    private IdDao          rerId;
    private String         waitTime;
    private DatabaseAccess databaseAccess;

    public ScheduleDao(Id _rerId, Line _line, Station _station, Station _destination, TimeSchedule _timeSchedule, DatabaseAccess _da) throws SQLException
    {
        setDatabaseAccess(_da);
        setDestination(new StationDao(_destination, _da));
        setLine(new LineDao(_line, _da));
        setStation(new StationDao(_station, _da));
        setWaitTime(_timeSchedule.getWaitTime());
        setRerId(new IdDao(_rerId, _da));
    }

    public ScheduleDao(Schedules _schedules, DatabaseAccess _da) throws SQLException
    {
        setDatabaseAccess(_da);
        setDestination(new StationDao(_schedules.getDestination(), _da));
        setLine(new LineDao(_schedules.getLine(), _da));
        for (TimeSchedule timeSchedule : _schedules.getTimeSchedules())
        {
            setStation(new StationDao(timeSchedule.getTerminus(), _da));
            setWaitTime(timeSchedule.getWaitTime());
            setRerId(new IdDao(timeSchedule.getId(), _da));
        }
    }

    public BigInteger getId()
    {
        return id;
    }

    public void setId(BigInteger id)
    {
        this.id = id;
    }

    public StationDao getStation()
    {
        return station;
    }

    public void setStation(StationDao station)
    {
        this.station = station;
    }

    public IdDao getRerId()
    {
        return rerId;
    }

    public void setRerId(IdDao rerId)
    {
        this.rerId = rerId;
    }

    public String getTimeSchedule()
    {
        return getWaitTime();
    }

    public void setTimeSchedule(String timeSchedule)
    {
        this.setWaitTime(timeSchedule);
    }

    public void insert() throws SQLException
    {
        int stationId = getStation().getId().intValue();
        int rerId = getRerId().getId().intValue();
        int stationDestId = getDestination().getId().intValue();
        int lineId = getLine().getId().intValue();
        if (stationId != 0 && rerId != 0 && stationDestId != 0 && lineId != 0)
        {
            String query = "INSERT INTO `ratp`.`t_schedule` (`id`,`f_key_line`,`f_key_station`,`f_key_station_dest`,`f_key_id`, `time`, `timestamp`) VALUES (NULL, '" + lineId + "', '" + stationId + "', '" + stationDestId + "','" + rerId
                + "', '" + getTimeSchedule() + "', CURRENT_TIMESTAMP)";
            getDatabaseAccess().getConnection().createStatement().execute(query);
        }
    }

    public StationDao getDestination()
    {
        return destination;
    }

    public void setDestination(StationDao destination)
    {
        this.destination = destination;
    }

    private String getWaitTime()
    {
        return waitTime;
    }

    private void setWaitTime(String waitTime)
    {
        this.waitTime = waitTime;
    }

    private DatabaseAccess getDatabaseAccess()
    {
        return databaseAccess;
    }

    private void setDatabaseAccess(DatabaseAccess databaseAccess)
    {
        this.databaseAccess = databaseAccess;
    }

    private LineDao getLine()
    {
        return line;
    }

    private void setLine(LineDao line)
    {
        this.line = line;
    }

}
