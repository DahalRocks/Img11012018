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
import com.dhruba.user.User;

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
		String sql = "Insert into image (image_name, haveSubimage, parentimage_description, image_type) values(:imageName,:haveSubimage,:parentimageDescription,:imageType)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("imageName", image.getImagename());
		source.addValue("haveSubimage", image.isHaveSubimage());
		source.addValue("parentimageDescription", image.getParentimagedescription());
		source.addValue("imageType", image.getParentimagetype());
		return param.update(sql, source);

	}

	public AdminImage selectLastInsertImageId() {
		String sql = "SELECT image_id,image_name FROM image WHERE image_id=(SELECT max(image_id) FROM image)";
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
		String sql = "Insert into subimage(image_type,parent_id,subimage_name,subimage_description)values(:imageType,:parentId,:subimageName,:subimageDescription)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("imageType", image.getImagetype());
		source.addValue("parentId", image.getParentid());
		source.addValue("subimageName", image.getRandomimage());
		source.addValue("subimageDescription", image.getRandomimagedescription());
		return param.update(sql, source);
	}
	
	
	public int deleteParentImage(AdminImage image) {
		String sql = "Delete from image where image_id=:imageId";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("imageId", image.getImageid());
		return param.update(sql, source);
	}
	
	public int deleteSubImage(AdminImage image) {
		String sql = "Delete from subimage where parent_id=:imageId";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("imageId", image.getImageid());
		return param.update(sql, source);
	}
	
	public int updateRandomImage(AdminImage image){
		String sql="Update subimage set subimage_name=:subImageName where subimage_id=:subImageId";
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("subImageName", image.getSubimagename());
		source.addValue("subImageId", image.getSubimageid());
		return param.update(sql, source);
	}
	
	public int updateSimilarImage(AdminImage image){
		String sql="Update subimage set subimage_name=:subImageName where subimage_id=:subImageId";
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("subImageName", image.getSubimagename());
		source.addValue("subImageId", image.getSubimageid());
		return param.update(sql, source);
	}
	
	public int saveSimilarSubImage(AdminImage image) {
		String sql = "Insert into subimage(image_type,parent_id,subimage_name,subimage_description)values(:imageType,:parentId,:subimageName,:subimageDescription)";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("imageType", image.getImagetype());
		source.addValue("parentId", image.getParentid());
		source.addValue("subimageName", image.getSimilarimage());
		source.addValue("subimageDescription", image.getSimilarimagedescription());
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
	public List<AdminImage> getImageListForAdmin() {
		String sql="select a.image_id,a.image_name, b.subimage_name, b.image_type from image a left join subimage b on a.image_id=b.parent_id;";
		return param.query(sql, new RowMapper<AdminImage>() {
			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image = new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				return image;
			}
		});
	}
	
	public List<AdminImage>getSubImagelst(AdminImage image){
		String sql="select  a.image_id, b.subimage_id, b.subimage_name, b.image_type, a.image_name from image a , subimage b where a.image_id=b.parent_id and a.image_id=:imageId";
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("imageId", image.getImageid());
		return param.query(sql,source,new RowMapper<AdminImage>() {
			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image = new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setSubimageid(rs.getInt("subimage_id"));
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
	
	public List<AdminImage> getGraphImageHavingNoSubImg(){
		String sql="select * from image where haveSubimage='0' and image_type='graph' order by rand() limit 1";
				
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				return image;
			}
		});
	}
	
	public List<AdminImage> getMapImageHavingNoSubImg(){
		String sql="select * from image where haveSubimage='0' and image_type='map' order by rand() limit 1";
		
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				return image;
			}
		});
	}
	public List<AdminImage>  getOtherImageHavingNoSubImg(){
		String sql="select * from image where haveSubimage='0' and image_type='other' order by rand() limit 1";
		
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				return image;
			}
		});
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
	
	public List<AdminImage> getImageHavingNoSubImg(){
		String sql="select * from image where haveSubimage='0' order by rand() limit 3";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				return image;
			}
		});
	}

	public int saveImageDescription(AdminImage objImageDescription, User user) {
		String sql="Insert into imagedescription(image_id,image_description,sub_image,user_id,difficulty_rating) values(:imageId,:imageDescription,:subImage,:userId,:difficultyRating)";
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("imageId", objImageDescription.getImageid());
		source.addValue("imageDescription", objImageDescription.getImagedescription());
		source.addValue("subImage", objImageDescription.getImagetype());
		source.addValue("userId", user.getUserid());
		source.addValue("difficultyRating", objImageDescription.getDifficultyrating());
		
		return param.update(sql, source);
	}

	public List<AdminImage> getImageWithRandomSubImg() {
		String sql="SELECT a.image_id,a.image_name,b.subimage_name,b.image_type,b.subimage_description FROM image a,subimage b where a.image_id=b.parent_id and b.image_type='random' order by rand() limit 3";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setRandomimagedescription(rs.getString("subimage_description"));
				return image;
			}
		});
	}
	
	public List<AdminImage> getGraphImageWithRandomSubImg() {
		String sql="SELECT a.image_id,a.image_name,b.subimage_name,b.image_type,b.subimage_description FROM image a,subimage b where a.image_id=b.parent_id and b.image_type='random' and a.image_type='graph' order by rand() limit 1";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setRandomimagedescription(rs.getString("subimage_description"));
				return image;
			}
		});
	}
	
	public List<AdminImage> getMapImageWithRandomSubImg() {
		String sql="SELECT a.image_id,a.image_name,b.subimage_name,b.image_type,b.subimage_description FROM image a,subimage b where a.image_id=b.parent_id and b.image_type='random' and a.image_type='map' order by rand() limit 1";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setRandomimagedescription(rs.getString("subimage_description"));
				return image;
			}
		});
	}
	
	public List<AdminImage> getOtherImageWithRandomSubImg() {
		String sql="SELECT a.image_id,a.image_name,b.subimage_name,b.image_type,b.subimage_description FROM image a,subimage b where a.image_id=b.parent_id and b.image_type='random' and a.image_type='other' order by rand() limit 1";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setRandomimagedescription(rs.getString("subimage_description"));
				return image;
			}
		});
	}

	public List<AdminImage> getImageWithSimilarSubImg() {
		String sql="SELECT a.image_id,a.image_name,b.subimage_name,b.image_type,b.subimage_description FROM image a,subimage b where a.image_id=b.parent_id and b.image_type='similar' order by rand() limit 3";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setSimilarimagedescription(rs.getString("subimage_description"));
				return image;
			}
		});
	}
	
	public List<AdminImage> getGraphImageWithSimilarSubImg() {
		String sql="SELECT a.image_id,a.image_name,b.subimage_name,b.image_type,b.subimage_description FROM image a,subimage b where a.image_id=b.parent_id and b.image_type='similar' and a.image_type='graph' order by rand() limit 1";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setSimilarimagedescription(rs.getString("subimage_description"));
				return image;
			}
		});
	}
	
	public List<AdminImage> getMapImageWithSimilarSubImg() {
		String sql="SELECT a.image_id,a.image_name,b.subimage_name,b.image_type,b.subimage_description FROM image a,subimage b where a.image_id=b.parent_id and b.image_type='similar' and a.image_type='map' order by rand() limit 1";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setSimilarimagedescription(rs.getString("subimage_description"));
				return image;
			}
		});
	}
	
	public List<AdminImage> getOtherImageWithSimilarSubImg() {
		String sql="SELECT a.image_id,a.image_name,b.subimage_name,b.image_type,b.subimage_description FROM image a,subimage b where a.image_id=b.parent_id and b.image_type='similar' and a.image_type='other' order by rand() limit 1";
		return param.query(sql, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImageid(rs.getInt("image_id"));
				image.setImagename(rs.getString("image_name"));
				image.setSubimagename(rs.getString("subimage_name"));
				image.setImagetype(rs.getString("image_type"));
				image.setSimilarimagedescription(rs.getString("subimage_description"));
				return image;
			}
		});
	}

	public List<AdminImage> callImageDescriptionToEvaluate(User user) {
		String sql="select a.imagedescription_id, a.image_description, b.parentimage_description, b.image_name, b.image_type from imagedescription a, image b where a.image_id=b.image_id and a.user_id <> :userId and a.isevaluated='0' order by rand() limit 9";
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("userId", user.getUserid());
		return param.query(sql, source, new RowMapper<AdminImage>() {

			@Override
			public AdminImage mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminImage image=new AdminImage();
				image.setImagedescriptionid(rs.getInt("imagedescription_id"));
				image.setImagedescription(rs.getString("image_description"));
				image.setParentimagedescription(rs.getString("parentimage_description"));
				image.setImagename(rs.getString("image_name"));
				image.setImagetype(rs.getString("image_type"));
				return image;
			}
		});
	
	}

	public int saveEvaluation(AdminImage objEvaluation) {
		String sql="Insert into evaluation(imagedescription_id,evaluation_string) values(:imageDescriptionId,:evaluationString)";
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("imageDescriptionId", objEvaluation.getImagedescriptionid());
		source.addValue("evaluationString", objEvaluation.getEvaluationstring());
		return param.update(sql, source);
		
	}
	
	public int updateEvaluationStatus(AdminImage objEvaluation){
		String sql="Update imagedescription set isevaluated=:isEvaluated where imagedescription_id=:imagedescriptionId";
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("isEvaluated", true);
		source.addValue("imagedescriptionId", objEvaluation.getImagedescriptionid());
		return param.update(sql, source);
	}
	
	
	
}
