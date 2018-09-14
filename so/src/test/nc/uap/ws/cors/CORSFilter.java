package nc.uap.ws.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	@Override
	public void destroy() {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain filterChain) throws IOException, ServletException {
		// TODO �Զ����ɵķ������

		 HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
	     httpResponse.addHeader("Access-Control-Allow-Origin", "*");
	     filterChain.doFilter(servletRequest, servletResponse);
			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO �Զ����ɵķ������

	}

}
