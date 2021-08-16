package hello.login.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter do filter");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 여러 요청을 처리할 수 있도록 설계되었으나, 기능이 부족함으로 httpServletRequest로 다운캐스팅하여 사용
        String requestURI = httpRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString();

        try {
            log.info("REQUEST [{}][{}]",uuid,requestURI);
            chain.doFilter(request,response); // 다음 필터 호출
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("RESPONSE[{}][{}]",uuid,requestURI);
        }
    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
