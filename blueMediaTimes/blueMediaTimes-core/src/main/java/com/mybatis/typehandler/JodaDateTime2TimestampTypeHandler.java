package com.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

/**
 * Created by huyan on 15/5/5.
 */
public class JodaDateTime2TimestampTypeHandler extends BaseTypeHandler<DateTime> {
    public JodaDateTime2TimestampTypeHandler() {
    }

    public void setNonNullParameter(PreparedStatement ps, int i, DateTime parameter, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i, new Timestamp(parameter.getMillis()));
    }

    public DateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        DateTime dateTime = null;
        Timestamp timestamp = rs.getTimestamp(columnName);
        if(timestamp != null) {
            dateTime = new DateTime(timestamp.getTime());
        }

        return dateTime;
    }

    public DateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        DateTime dateTime = null;
        Timestamp timestamp = cs.getTimestamp(columnIndex);
        if(timestamp != null) {
            dateTime = new DateTime(timestamp.getTime());
        }

        return dateTime;
    }

    public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        DateTime dateTime = null;
        Timestamp timestamp = rs.getTimestamp(columnIndex);
        if(timestamp != null) {
            dateTime = new DateTime(timestamp.getTime());
        }

        return dateTime;
    }
}