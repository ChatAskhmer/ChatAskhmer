package com.askhmer.services;

import java.util.List;

/***
 * 
 * @author soklundy
 *
 */
public interface Testing {
	
	/***
	 * 
	 * @return list<String>
	 */
	public List<String> listStudent();
	
	/***
	 * 
	 * @param id
	 * @return String
	 */
	public String find(String id);

}
