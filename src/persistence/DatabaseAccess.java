package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistence.dao.IdDao;
import persistence.dao.LineDao;
import persistence.dao.StationDao;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import constants.Constants;
import constants.Constants.Id;
import constants.Constants.Line;
import constants.Constants.Station;

public class DatabaseAccess
{
    private Connection connect   = null;
    private Statement  statement = null;
    private ResultSet  resultSet = null;

    public DatabaseAccess()
    {
        readDataBase();
        fill();
    }

    public void fill()
    {
        Id[] rerIds = Constants.Id.values();
        for (Id rerId : rerIds)
        {
            try
            {
                (new IdDao(rerId, this)).insert();
            }
            catch (SQLException e)
            {

            }
        }

        Station[] stations = Constants.Station.values();
        for (Station station : stations)
        {
            try
            {
                (new StationDao(station, this)).insert();
            }
            catch (SQLException e)
            {

            }
        }

        Line[] lines = Constants.Line.values();
        for (Line line : lines)
        {
            try
            {
                (new LineDao(line, this)).insert();
            }
            catch (SQLException e)
            {

            }
        }
    }

    private void readDataBase()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            setConnection(DriverManager.getConnection("jdbc:mysql://localhost/ratp?" + "user=root&password="));
        }
        catch (CommunicationsException ce)
        {
            ce.printStackTrace();
            System.exit(0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void close()
    {
        try
        {
            if (getResultSet() != null)
            {
                getResultSet().close();
            }

            if (getStatement() != null)
            {
                getStatement().close();
            }

            if (getConnection() != null)
            {
                getConnection().close();
            }
        }
        catch (Exception e)
        {

        }
    }

    public Connection getConnection()
    {
        return connect;
    }

    private void setConnection(Connection connect)
    {
        this.connect = connect;
    }

    public Statement getStatement()
    {
        return statement;
    }

    public ResultSet getResultSet()
    {
        return resultSet;
    }

}
