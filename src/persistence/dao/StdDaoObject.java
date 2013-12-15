package persistence.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistence.DatabaseAccess;

public abstract class StdDaoObject
{
    private BigInteger     id = BigInteger.ZERO;
    private String         name;
    private DatabaseAccess databaseAccess;

    protected StdDaoObject(DatabaseAccess databaseAccess)
    {
        setDatabaseAccess(databaseAccess);
    }

    public BigInteger getId()
    {
        return id;
    }

    public void setId(BigInteger id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public abstract void insert() throws SQLException;

    protected void insert(String tableName) throws SQLException
    {
        String query = "INSERT INTO `ratp`.`" + tableName + "` (`id`, `name`) VALUES (NULL, '" + getName() + "')";
        getDatabaseAccess().getConnection().createStatement().execute(query);
    }

    protected void fillId(String tableName) throws SQLException
    {
        String query = "SELECT * FROM `ratp`.`" + tableName + "` WHERE name = '" + name + "'";

        ResultSet resultSet = getDatabaseAccess().getConnection().createStatement().executeQuery(query);

        while (resultSet.next())
        {
            setId(new BigInteger(resultSet.getString("id")));
        }

    }

    protected DatabaseAccess getDatabaseAccess()
    {
        return databaseAccess;
    }

    private void setDatabaseAccess(DatabaseAccess databaseAccess)
    {
        this.databaseAccess = databaseAccess;
    }
}
