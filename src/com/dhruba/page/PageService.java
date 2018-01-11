package com.dhruba.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageService {

	@Autowired
	private PageDao pageDao;

	public boolean createPage(Page page) {
		if (pageDao.savePage(page) > 0)
			return true;
		else
			return false;
	}

	public Page getPageDetailByName(Page page) {
		page = pageDao.getPageDetailByName(page);
		return page;
	}

}
