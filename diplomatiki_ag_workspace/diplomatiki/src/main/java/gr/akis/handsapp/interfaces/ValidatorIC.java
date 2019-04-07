package gr.akis.handsapp.interfaces;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@InputValidating
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class ValidatorIC implements Serializable {

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {

		Object[] params = ctx.getParameters();
		for (Object param : params) {
			if (param instanceof SelfValidating) {
				((SelfValidating) param).validate();
			}
		}
		Object obj = ctx.proceed();
		return obj;
	}
}
