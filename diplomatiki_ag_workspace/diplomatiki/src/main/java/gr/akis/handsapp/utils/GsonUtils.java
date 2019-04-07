package gr.akis.handsapp.utils;

import javax.enterprise.context.ApplicationScoped;
import com.google.gson.Gson;

@ApplicationScoped
public class GsonUtils {

	public String toJson(Object obj) {
		String output = null;
		if (obj != null) {
			output = new Gson().toJson(obj);
		}
		return output;
	}
}
