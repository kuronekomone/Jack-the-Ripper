package sw;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetBeanMapping {
	public Object createFromResultSet(ResultSet rs)
	throws SQLException;
}