package com.intact.headerforwardinterceptorlib.interceptor;

import com.intact.headerforwardinterceptorlib.filter.CustomFilter;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private final CustomFilter customFilter;

    public RestTemplateInterceptor(CustomFilter customFilter) {
        this.customFilter = customFilter;
    }

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request,
            byte[] body,
            ClientHttpRequestExecution execution) throws IOException {
        customFilter.getHeaders().entrySet().stream().forEach(e -> request.getHeaders().add(e.getKey() , "e.getValue()"));
        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }
}
