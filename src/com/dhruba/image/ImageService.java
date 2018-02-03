package com.dhruba.image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import com.dhruba.page.Page;
import com.dhruba.user.User;

@Component
@Scope("session")
public class ImageService {
	@Autowired
	private ImageDao imageDao;

	@Autowired
	Image objImage;

	@Autowired
	AdminImage objAdminImage;

	public boolean createImage(Image image) {
		boolean isCreated = true;
		try {
			imageDao.saveImage(image);
		} catch (DataAccessException e) {
			isCreated = false;
			
		}
		return isCreated;
	}

	public List<AdminImage> getSubImagelst(AdminImage image){
		List<AdminImage>lstSubImage=new ArrayList<>();
		try {
			lstSubImage= imageDao.getSubImagelst(image);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
		return lstSubImage;
		
	}
	
	public boolean createImageByAdmin(AdminImage image) {
		boolean isCreated = true;
		try {
			imageDao.saveImageByAdmin(image);
			
		} catch (DataAccessException e) {
			isCreated = false;
			
		}
		return isCreated;
	}

	public boolean createRandomSubImage(AdminImage image) {
		boolean isCreated = true;
		try {
			objAdminImage = imageDao.selectLastInsertImageId();
			image.setParentid(objAdminImage.getImageid());
			image.setImagetype("random");
			imageDao.saveRandomSubImage(image);
		} catch (DataAccessException e) {
			// TODO: handle exception
			
			isCreated = false;
		}
		return isCreated;
	}
	
	public boolean updateRandomImage(AdminImage image){
		boolean isUpdated=true;
		try {
			imageDao.updateRandomImage(image);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			isUpdated=false;
		}
		return isUpdated;
	}
	
	
	public boolean deleteParentImage(AdminImage image){
		boolean isDeleted=true;
		try {
			imageDao.deleteParentImage(image);
			imageDao.deleteSubImage(image);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			isDeleted=false;
		}
		return isDeleted;
	}
	
	
	public boolean updateSimilarImage(AdminImage image){
		boolean isUpdated=true;
		try {
			imageDao.updateRandomImage(image);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			isUpdated=false;
		}
		return isUpdated;
	}

	public boolean createSimilarSubImage(AdminImage image) {
		boolean isCreated = true;
		try {
			objAdminImage = imageDao.selectLastInsertImageId();
			image.setParentid(objAdminImage.getImageid());
			image.setImagetype("similar");
			imageDao.saveSimilarSubImage(image);
		} catch (DataAccessException e) {
			// TODO: handle exception
			
			isCreated = false;
		}
		return isCreated;
	}

	public List<AdminImage> getImageList() {
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		lstImage = imageDao.getImageList();
		return lstImage;
	}
	public List<AdminImage> getImageListForAdmin() {
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		lstImage = imageDao.getImageListForAdmin();
		return lstImage;
	}
	

	public List<Image> getImageContentList(Page page) {
		List<Image> lstImage = new ArrayList<Image>();
		lstImage = imageDao.getImageContentList(page);
		return lstImage;
	}

	public boolean checkImageExist(Image image) {
		Boolean isThere = false;
		int count = imageDao.countImage(image);
		if (count > 0)
			isThere = true;
		return isThere;
	}

	public boolean updateImage(Image image) {
		Boolean isUpdated = true;
		try {
			int num = imageDao.updateImage(image);
			if (num != 1)
				isUpdated = false;
		} catch (DataAccessException e) {
			isUpdated = false;
		}
		return isUpdated;
	}
	
	/*public List<AdminImage>getImageHavingNoSubImg(){
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		try {
			lstImage=imageDao.getImageHavingNoSubImg();
		} catch (DataAccessException e) {
			
		}
		return lstImage;
	}*/
	
	public List<AdminImage>getImageHavingNoSubImg(){
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		try {
			
			
			List<AdminImage> graphImage=imageDao.getGraphImageHavingNoSubImg();
			for(AdminImage image:graphImage){
				lstImage.add(image);
			}
			List<AdminImage> mapImage=imageDao.getMapImageHavingNoSubImg();
			for(AdminImage image:mapImage){
				lstImage.add(image);
			}
			List<AdminImage> otherImage=imageDao.getOtherImageHavingNoSubImg();
			for(AdminImage image:otherImage){
				lstImage.add(image);
			}
			
			
		} catch (DataAccessException e) {
			
		}
		return lstImage;
	}

	public void saveImageDescription(AdminImage objImageDescription, HttpSession session) {
		
		try {
			User user=(User)session.getAttribute("user");
			imageDao.saveImageDescription(objImageDescription,user);
		} catch (DataAccessException e) {
			
		}
	}

	/*public List<AdminImage> getImageWithRandomSubImg() {
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		try {
			lstImage=imageDao.getImageWithRandomSubImg();
		} catch (DataAccessException e) {
			
		}
		return lstImage;
	}*/
	
	public List<AdminImage> getImageWithRandomSubImg() {
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		try {
			List <AdminImage>graphImage=imageDao.getGraphImageWithRandomSubImg();
						
			for(AdminImage image:graphImage){
				lstImage.add(image);
			}
			List <AdminImage>mapImage=imageDao.getMapImageWithRandomSubImg();
			for(AdminImage image:mapImage){
				lstImage.add(image);
			}
			List <AdminImage>otherImage=imageDao.getOtherImageWithRandomSubImg();
			for(AdminImage image:otherImage){
				lstImage.add(image);
			}
		} catch (DataAccessException e) {
			
		}
		return lstImage;
	}

	/*public List<AdminImage> getImageWithSimilarSubImg() {
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		try {
			lstImage=imageDao.getImageWithSimilarSubImg();
		} catch (DataAccessException e) {
			
		}
		return lstImage;
	}*/
	public List<AdminImage> getImageWithSimilarSubImg() {
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		try {
			
			List <AdminImage>graphImage=imageDao.getGraphImageWithSimilarSubImg();
			
			for(AdminImage image:graphImage){
				lstImage.add(image);
			}
			List <AdminImage>mapImage=imageDao.getMapImageWithSimilarSubImg();
			for(AdminImage image:mapImage){
				lstImage.add(image);
			}
			List <AdminImage>otherImage=imageDao.getOtherImageWithSimilarSubImg();
			for(AdminImage image:otherImage){
				lstImage.add(image);
			}
		} catch (DataAccessException e) {
			
		}
		return lstImage;
	}

	public List<AdminImage> callImageDescriptionToEvaluate(User user) {
		List<AdminImage> lstEvaluation = new ArrayList<AdminImage>();
		try {
			lstEvaluation=imageDao.callImageDescriptionToEvaluate(user);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return lstEvaluation;
	}

	public boolean saveEvaluation(AdminImage objEvaluation) {
		boolean isSaved = true;
		try {
			imageDao.saveEvaluation(objEvaluation);
			imageDao.updateEvaluationStatus(objEvaluation);
		} catch (DataAccessException e) {
			isSaved = false;
			
		}
		return isSaved;
		
	}

	

}
