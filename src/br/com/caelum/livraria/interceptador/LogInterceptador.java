package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext ic) throws Exception {

		long millis = System.currentTimeMillis();

		Object o = ic.proceed();

		System.out.println(ic.getTarget().getClass().getSimpleName() + " - " + ic.getMethod().getName()); 

		System.out.println("[INFO] Tempo gasto no acesso do BD: "
				+ (System.currentTimeMillis() - millis) + " ms");
		return o;
	}

}
