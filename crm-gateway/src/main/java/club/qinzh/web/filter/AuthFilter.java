package club.qinzh.web.filter;

import club.qinzh.enums.ExceptionEnums;
import club.qinzh.utils.JsonUtils;
import club.qinzh.utils.JwtTokenUtils;
import club.qinzh.utils.ResponseResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
@Component
public class AuthFilter extends ZuulFilter {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if(request.getRequestURI().contains("/crm-auth")|| request.getRequestURI().contains("/v2/api-docs")){
            return null;
        }
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        if(StringUtils.isBlank((token))){
            errorResponse(requestContext,ExceptionEnums.TOKEN_ERROR);
        }else{
            String username = JwtTokenUtils.getUsername(token);
            String redisToken = redisTemplate.opsForValue().get(username);
            if(token.equals(redisToken) && !JwtTokenUtils.isExpiration(token)){
                return null;
            }else {
                errorResponse(requestContext,ExceptionEnums.TOKEN_ERROR);
            }
        }
        return null;
    }
    public void errorResponse(RequestContext requestContext,ExceptionEnums exceptionEnums){
        requestContext.addZuulResponseHeader("content-type","application/json;charset=utf-8");
        requestContext.setResponseStatusCode(ExceptionEnums.TOKEN_ERROR.getCode());
        requestContext.setResponseBody(JsonUtils.serialize(new ResponseResult(exceptionEnums)));
        requestContext.setSendZuulResponse(false);
    }

}