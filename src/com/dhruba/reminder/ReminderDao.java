package com.dhruba.reminder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ReminderDao {

	private NamedParameterJdbcTemplate param;

	@Autowired
	public void setParam(BasicDataSource param) {
		this.param = new NamedParameterJdbcTemplate(param);
	}

	public int setReminder(Reminder reminder) {
		String sql = "Insert into reminder(isEnabled)values(:isEnabled)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("isEnabled", reminder.getCheck());
		return param.update(sql, source);
	}

	public List<Reminder> getReminder() {
		return param.query("select * from reminder", new RowMapper<Reminder>() {
			@Override
			public Reminder mapRow(ResultSet rs, int rowNum) throws SQLException {
				Reminder reminder = new Reminder();
				reminder.setCheck(rs.getBoolean("isEnabled"));
				return reminder;
			}
		});
	}
}
