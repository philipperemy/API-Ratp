package persistence.dao;

import java.sql.SQLException;
import persistence.DatabaseAccess;
import constants.Constants.Id;

public class IdDao extends StdDaoObject
{
    private static final String T_ID = "t_id";

    @Override
    public void insert() throws SQLException
    {
        super.insert(T_ID);
    }

    public IdDao(Id id, DatabaseAccess da) throws SQLException
    {
        super(da);
        setName(id.getId());
        fillId(T_ID);
    }

}
