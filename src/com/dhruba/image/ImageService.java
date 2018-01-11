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

	public boolean createImage(Image image) {
		boolean isCreated = true;
		try {
			imageDao.saveImage(image);
		} catch (DataAccessException e) {
			isCreated = false;
			System.out.println(e.getMessage());
		}
		return isCreated;
	}

	public boolean createImageByAdmin(AdminImage image) {
		boolean isCreated = true;
		try {
			imageDao.saveImageByAdmin(image);
		} catch (DataAccessException e) {
				isCreated = false;
				System.out.println(e.getMessage());
		}
		return isCreated;
	}

	public List<AdminImage> getImageList() {
		List<AdminImage> lstImage = new ArrayList<AdminImage>();
		lstImage = imageDao.getImageList();
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
