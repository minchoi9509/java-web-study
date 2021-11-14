package com.board.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "encoding", value = "utf-8", description = "encoding"),
		@WebInitParam(name = "forceEncoding", value = "true", description = "forceEncoding") })
public class EncodingFilter implements Filter {

	private String encoding = "";
	private String forceEncoding = "false";
	
	private static final String ENCODING = "encoding";
	private static final String FORCE_ENCODING = "forceEncoding";

	/**
	 * Default constructor.
	 */
	public EncodingFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (encoding != null && !"".equals(encoding)) {
			request.setCharacterEncoding(encoding);
		}

		if (encoding != null && "true".equalsIgnoreCase(forceEncoding)) {
			response.setCharacterEncoding(encoding);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter(ENCODING) == null ? "" : filterConfig.getInitParameter(ENCODING);
		forceEncoding = filterConfig.getInitParameter(FORCE_ENCODING) == null ? "false"
				: filterConfig.getInitParameter(FORCE_ENCODING);
	}

}
