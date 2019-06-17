package com.questions.zuulserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TrackingFilter extends ZuulFilter {
	
	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;
	private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);
	
	@Autowired
	FilterUtils filterUtils;

	@Override
	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	@Override
	public Object run() throws ZuulException {
		if(isCorrelationIdPresent()) {
			logger.debug("Correlation ID is present in tracking filter: {}", filterUtils.getCorrelationId());
		} else {
			filterUtils.setCorrelationId(generateCorrelationId());
			logger.debug("Correlation ID is generated in tracking filter: {}", filterUtils.getCorrelationId());
		}
		
		RequestContext ctx = RequestContext.getCurrentContext();
		logger.debug("Processing incoming request for {}", ctx.getRequest().getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		return filterUtils.PRE_FILTER_TYPE;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}
	
	public boolean isCorrelationIdPresent() {
		return filterUtils.getCorrelationId() != null;
	}
	
	public String generateCorrelationId() {
		return java.util.UUID.randomUUID().toString();
	}

}
