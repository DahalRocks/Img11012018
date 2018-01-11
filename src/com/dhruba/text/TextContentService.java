package com.dhruba.text;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.dhruba.user.User;

@Component
@Scope("session")
public class TextContentService {
	@Autowired
	private TextContentDao textContentDao;

	public boolean createTextContent(TextContent textContent) {
		boolean isCreated = true;
		try {
			textContentDao.saveTextContent(textContent);
		} catch (DataAccessException e) {
			isCreated = false;
			
		}
		return isCreated;
	}
	
	public List<TextContent> getTextContentList(User user){
		List<TextContent>lstText= new ArrayList<TextContent>();
		try {
			lstText=textContentDao.getTextContentList(user);
		} catch (DataAccessException e) {
			
		}
		
		return lstText;
	}
	
	public boolean getTextContentForDivision(TextContent textContent){
		
		if(textContentDao.selectTextContentForDivision(textContent)<1)
			return true;
		else
			return false;
		
	}
	
	public boolean updateTextContent(TextContent textContent){
		if(textContentDao.updateTextContent(textContent)>1)
			return true;
		else 
			return false;
					
	}
}
