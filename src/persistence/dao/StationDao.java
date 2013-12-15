package persistence.dao;

import java.sql.SQLException;
import persistence.DatabaseAccess;
import constants.Constants.Station;

public class StationDao extends StdDaoObject
{
    private static final String T_STATION = "t_station";

    @Override
    public void insert() throws SQLException
    {
        super.insert(T_STATION);
    }

    public StationDao(Station station, DatabaseAccess da) throws SQLException
    {
        super(da);
        setName(station.getStation());
        fillId(T_STATION);
    }

}
