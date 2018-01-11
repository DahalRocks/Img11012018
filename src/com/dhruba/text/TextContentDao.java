package com.dhruba.text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.dhruba.user.User;

@Component
@Scope("session")
public class TextContentDao {
	private NamedParameterJdbcTemplate param;

	@Autowired
	public void setParam(BasicDataSource param) {
		this.param = new NamedParameterJdbcTemplate(param);
	}

	public int saveTextContent(TextContent textContent) {
		int result = 0;
		try {
			String sql = "Insert into textcontent (content_title,content, division, reminder) values(:contenttitle,:content,:division,:reminder)";
			MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("contenttitle", textContent.getContenttitle());
			source.addValue("content", textContent.getContent());
			source.addValue("division", textContent.getDivision());
			source.addValue("reminder", textContent.getReminder());
			result = param.update(sql, source);
		} catch (DataAccessException e) {

		}

		return result;
	}

	public int updateTextContent(TextContent textContent) {
		int result = 0;
		try {
			String sql = "Update textcontent set content_title=:contenttitle, content=:content where division=:division";
			MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("contenttitle", textContent.getContenttitle());
			source.addValue("content", textContent.getContent());
			source.addValue("division", textContent.getDivision());
			result = param.update(sql, source);

		} catch (DataAccessException e) {

		}
		return result;
	}

	public int selectTextContentForDivision(TextContent textContent) {
		int result = 0;

		try {
			String sql = "SELECT count(*) FROM textcontent where division=:division and reminder=:reminder";
			MapSqlParameterSource source = new MapSqlParameterSource();
			source.addValue("contenttitle", textContent.getContenttitle());
			source.addValue("content", textContent.getContent());
			source.addValue("division", textContent.getDivision());
			source.addValue("reminder", textContent.getReminder());
			
			result = param.queryForObject(sql, source, Integer.class);

		} catch (DataAccessException e) {

		}
		return result;
	}

	public List<TextContent> getTextContentList(User user) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("reminder", user.getReminded());
					
		List<TextContent> lstContent = param.query("select * from textcontent where reminder=:reminder",source,new RowMapper<TextContent>() {
			@Override
			public TextContent mapRow(ResultSet rs, int rowNum) throws SQLException {
				TextContent text = new TextContent();
				text.setTextcontendid(rs.getInt("textcontent_id"));
				text.setContent(rs.getString("content"));
				text.setContenttitle(rs.getString("content_title"));
				text.setDivision(rs.getInt("division"));
				return text;
			}
		});
		return lstContent;
	}
}
