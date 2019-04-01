package gr.anagnosg.utis;

import java.util.List;

import gr.anagnosg.schoolservices.models.Skill;


public class StringUtils {

	public static String convertSkills2String(List<Skill> skills){
		String output = "";
		if(skills!=null){
			for(int i = 0 ; i < skills.size() ; i++){
				Skill s = skills.get(i);
				String descr = s.getDescr()==null?"":s.getDescr();
				if(output.equals("")){
					output = descr;
				}
				else{
					output+="," + descr;
				}
			}
		}
		return output;
	}
}
