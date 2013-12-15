package persistence.dao;

import java.sql.SQLException;
import persistence.DatabaseAccess;
import constants.Constants.Line;

public class LineDao extends StdDaoObject
{
    private static final String T_LINE = "t_line";

    @Override
    public void insert() throws SQLException
    {
        super.insert(T_LINE);
    }

    public LineDao(Line line, DatabaseAccess da) throws SQLException
    {
        super(da);
        setName(line.getLine());
        fillId(T_LINE);
    }

}
