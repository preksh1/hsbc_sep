package com.insta_java.service;

import java.util.List;
import java.util.Map;

import com.insta_java.dao.InstaDao;
import com.insta_java.dao.InstaDaoInterface;
import com.insta_java.entity.InstaUser;
import com.insta_java.utility.InstaException;

public class InstaService implements InstaServiceInterface {
		// TODO Auto-generated method stub
		private InstaDaoInterface id;
		public InstaService(){
			id = new InstaDao();
		}

	@Override
	public int createProfileService(InstaUser iu) throws Exception {
		// TODO Auto-generated method stub
		int i=id.createProfileDao(iu);
		return i;
	}

	@Override
	public InstaUser viewProfileService(InstaUser iu)  {
		// TODO Auto-generated method stub
		/*id.viewProfileDao();
		System.out.println("posted");*/
		return id.viewProfileDao(iu);
		
		
	}

	@Override
	public int editProfileService(InstaUser iu){
		// TODO Auto-generated method stub
		int i=id.editProfileDao(iu);
		return i;
		//System.out.println("profile edited");
		
	}

	@Override
	public int deleteProfileService(InstaUser iu){
		// TODO Auto-generated method stub
		return id.deleteProfileDao(iu);
		
		
	}

	@Override
	/*public InstaUser searchProfileService(InstaUser iu) {
		// TODO Auto-generated method stub
		InstaUser iu1=id.searchProfileDao(iu);
		return iu1;
		/*id.searchProfileDao();
		System.out.println("profile searched");
		*/
	//}*/
	public List<InstaUser> searchProfileService(InstaUser iu) throws InstaException{
		// TODO Auto-generated method stub
		return id.searchProfileDao(iu);
		/*id.searchProfileDao();
		System.out.println("profile searched");
		*/
	}

	@Override
	public String viewAllProfileService() throws Exception {
		// TODO Auto-generated method stub
		return id.viewAllProfileDao(); 
				
	}
	/* DERBY CODE
	public List<InstaUser> viewAllProfileService() {
		// TODO Auto-generated method stub
		return null; 
		
		 return id.viewAllProfileDao();
		 
		//System.out.println("commented");
		
	}*/

	@Override
	public Map<String, List<InstaUser>> viewhistoryservice() throws Exception {
		// TODO Auto-generated method stub
		return id.viewhistorydao();
	}

}
