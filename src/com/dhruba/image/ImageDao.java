package com.dhruba.image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.transform.Source;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.dhruba.page.Page;

@Component
@Scope("session")
public class ImageDao {
	private NamedParameterJdbcTemplate param;

	@Autowired
	public void setParam(BasicDataSource param) {
		this.param = new NamedParameterJdbcTemplate(param);
	}

	public int saveImage(Image image) {
		String sql = "Insert into imagecontent (url, title, caption, alttext,description,division,page_id) values(:url,:title,:caption,:alttext,:description,:division,:pageID)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("url", image.getUrl());
		source.addValue("title", image.getTitle());
		source.addValue("caption", image.getCaption());
		source.addValue("alttext", image.getAlttext());
		source.addValue("description", image.getDescription());
		source.addValue("division", image.getDivision());
		source.addValue("pageID", image.getPage().getPageid());
		return param.update(sql, source);
	}

	public int saveImageByAdmin(AdminImage image) {
		String sql = "Insert into image (image_name, haveSubimage) values(:imageName,:haveSubimage)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("imageName", image.getImagename());
		source.addValue("haveSubimage", image.isHaveSubimage());
		return param.update(sql, source);

	}

	public AdminImage selectLastInsertImageId() {
		String sql = "SELECT * FROM image WHERE image_id=(SELECT max(image_id) FROM image)";
		List<AdminImage> lstAdminImage = param.query(sql, new RowMapper<AdminImage>() {
			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image = new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				return image;
			}
		});
		if (lstAdminImage.isEmpty()) {
			return null;
		} else if (lstAdminImage.size() == 1) {
			return lstAdminImage.get(0);
		} else {
			return lstAdminImage.get(0);
		}
	}

	public int saveRandomSubImage(AdminImage image) {
		String sql = "Insert into subimage(image_type,parent_id,subimage_name)values(:imageType,:parentId,:subimageName)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("imageType", image.getImagetype());
		source.addValue("parentId", image.getParentid());
		source.addValue("subimageName", image.getRandomimage());
		return param.update(sql, source);
	}
	
	public int saveSimilarSubImage(AdminImage image) {
		String sql = "Insert into subimage(image_type,parent_id,subimage_name)values(:imageType,:parentId,:subimageName)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("imageType", image.getImagetype());
		source.addValue("parentId", image.getParentid());
		source.addValue("subimageName", image.getSimilarimage());
		return param.update(sql, source);
	}

	public List<AdminImage> getImageList() {
		return param.query("select * from image", new RowMapper<AdminImage>() {
			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image = new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				return image;
			}
		});
	}

	public List<Image> getImageContentList(Page page) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("pageid", page.getPageid());
		return param.query("select image_id, division, url, alttext, title  from imagecontent where page_id=:pageid",
				source, new RowMapper<Image>() {
					@Override
					public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
						Image image = new Image();
						image.setImageid(rs.getInt("image_id"));
						image.setUrl(rs.getString("url"));
						image.setDivision(rs.getInt("division"));
						image.setAlttext(rs.getString("alttext"));
						image.setTitle(rs.getString("title"));
						return image;
					}
				});
	}

	public int countImage(Image image) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("pageid", image.getPage().getPageid());
		source.addValue("division", image.getDivision());
		String sql = "select count(*) from imagecontent where page_id=:pageid and division=:division";
		return param.queryForObject(sql, source, Integer.class);
	}

	public int updateImage(Image image) {
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("pageid", image.getPage().getPageid());
		source.addValue("division", image.getDivision());
		source.addValue("url", image.getUrl());
		source.addValue("caption", image.getCaption());
		source.addValue("title", image.getTitle());
		source.addValue("alttext", image.getAlttext());
		source.addValue("description", image.getDescription());
		String sql = "UPDATE imagecontent SET url=:url, alttext=:alttext, caption=:caption, title=:title, description=:description WHERE page_id=:pageid AND division=:division";
		return param.update(sql, source);

	}

}
