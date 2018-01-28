package com.dhruba.image;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import com.dhruba.page.Page;

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

}
