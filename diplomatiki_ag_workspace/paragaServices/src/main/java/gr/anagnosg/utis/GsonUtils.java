package gr.anagnosg.utis;


import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.google.gson.Gson;

import gr.anagnosg.schoolservices.models.SelectValue;
import gr.anagnosg.schoolservices.models.Skill;

@ApplicationScoped
public class GsonUtils {

	
	public String toJson(Object obj){
		String output=null;
		if(obj!=null){
			//TODO chekc if list is supported.
			/*if(obj instanceof List){ 
				
			}*/
			output =new Gson().toJson(obj); 
		}
		return output;
	} 
	
	//TODO make lamda use 
	public List<SelectValue> skill2SelectValue(List<Skill> skills,String term,boolean applyTrim){
		List<SelectValue> output = new ArrayList<SelectValue>();
		for(int i= 0 ; i < skills.size() ; i++){
			
			Skill s = skills.get(i);
			if(term!=null && s.getDescr().contains(term)){
				SelectValue sv = new SelectValue();
				String descr = s.getDescr();
				if(applyTrim){
					descr = descr.trim();
				}
				sv.setId(s.getId()); sv.setName(descr);sv.setValue(descr);sv.setLabel(descr);
				output.add(sv);
			}
		}
		return output;
	}
}
