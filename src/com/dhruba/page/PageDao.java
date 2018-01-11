package com.dhruba.page;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PageDao {

	private NamedParameterJdbcTemplate param;

	@Autowired
	public void setParam(BasicDataSource param) {
		this.param = new NamedParameterJdbcTemplate(param);
	}

	public int savePage(Page page) {
		int result = 0;
		int count = countPage(page);
		if (count < 1) {
			try {
				String sql = "Insert into page (page_name, user_id, isReminded) values(:pageName,:userID,:isReminded)";
				MapSqlParameterSource source = new MapSqlParameterSource();
				source.addValue("pageName", page.getPagename());
				source.addValue("userID", page.getUser().getUserid());
				source.addValue("isReminded", page.getReminder().getCheck());
				result = param.update(sql, source);
			} catch (DataAccessException e) {
				
			}

			return result;
		} else
			return 0;

	}

	public int countPage(Page page) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("pagename", page.getPagename());
		source.addValue("isReminded", page.getReminder().getCheck());
		String sql = "select count(*) from page where page_name=:pagename and isReminded=:isReminded";
		return param.queryForObject(sql, source, Integer.class);
	}

	public Page getPageDetailByName(Page page) {

		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("pagename", page.getPagename());
		source.addValue("isReminded", page.getReminder().getCheck());
		return (Page) param.queryForObject(
				"Select page_id,page_name from page where page_name=:pagename and isReminded=:isReminded", source,
				new RowMapper<Page>() {
					@Override
					public Page mapRow(ResultSet rs, int rowNum) throws SQLException {
						Page page = new Page();
						page.setPageid(rs.getInt("page_id"));
						page.setPagename(rs.getString("page_name"));
						return page;
					}
				});
	}

}
