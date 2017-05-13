package uni.db.project.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Dimitry on 14.02.17.
 */
//@WebFilter("/*")
public class FormEncodingSetterFilter implements Filter {

    // кодировка
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        // читаем из конфигурации
        encoding = config.getInitParameter("requestEncoding");

        // если не установлена - устанавливаем Cp1251
        if (encoding == null)
            encoding = "utf-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        next.doFilter(request, response);
    }

    public void destroy() {
    }
}

