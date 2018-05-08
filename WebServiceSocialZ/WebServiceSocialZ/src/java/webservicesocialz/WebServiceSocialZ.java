/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicesocialz;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author enrico.daronche
 */
@WebService(serviceName = "WebServiceSocialZ")
public class WebServiceSocialZ {
	
	@WebMethod(operationName = "getHobbiesConPraticanti")
	public String getHobbiesConPraticanti() {
		String ris="{";
		ArrayList<String>hobbies=dbutil.DButil.getHobbies();
		ris+="\"hobbies\":[";
		for(String hobby:hobbies){
			ris+="{\"nome\":\""+hobby+"\",\"praticanti\":[";
			ArrayList<String>praticanti=dbutil.DButil.getPraticanti(hobby);
			for(String praticante:praticanti){
				ris+="\""+praticante+"\",";
			}
			ris=ris.substring(0,ris.length()-1);
			ris+="]},";
		}
		ris=ris.substring(0, ris.length()-1);
		return ris+"]}";
	}
}
