package com.intact.headerforwardinterceptorlib.filter;

import com.intact.headerforwardinterceptorlib.util.HeaderTypeEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Data
@Component
public class CustomFilter implements Filter {

    private Map<String,String>  headers = new HashMap<>();
    @Override
    public void doFilter(ServletRequest servletrequest, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletrequest;
        Enumeration<String> headerNames = request.getHeaderNames();
        Arrays.stream(HeaderTypeEnum.values()).forEach(h -> {
            System.out.println(request.getHeader(h.getHeaderType()));
            if(request.getHeader(h.getHeaderType()) != null){
                headers.put(h.getHeaderType(),request.getHeader(h.getHeaderType()));
            }
        });
        filterChain.doFilter(servletrequest,response);

    }



    public Map<String, String> getHeaders() {
        return headers;
    }
}
