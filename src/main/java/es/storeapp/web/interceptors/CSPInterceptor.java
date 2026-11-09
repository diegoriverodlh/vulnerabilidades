package es.storeapp.web.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class CSPInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        response.setHeader("Content-Security-Policy",
                "default-src 'none'; img-src 'self' data:; font-src 'self'; frame-ancestors 'none'; frame-src 'none'; child-src 'none'; script-src 'self' 'sha256-I4NfWRPZMRjiaYSIPU7cqZtx6OkCj4jyIlpXpuaVqLs=' 'sha256-YGHFEvj556ZNwsFJYmdWE/4CCJj1aStrjr7YtwqJCJ4=' 'sha256-aR2utwKhdnR+GHr8oyfCbtgNFfZt8jGGkH0kW39RkYE=' 'sha256-Y2eZl9kVGG22Nu0L5pFP8FG2jCfgK6iWCjoCtKwJm8g=' 'sha256-W1/BckEBffZxvHP0O+WzD+jRblLyL2/3Y/TFm2KAMGI=' 'sha256-mKaii2Xuq3j9hJmK6hLzeK+HyPF+eTOnXVlEdjOfwW4=' 'sha256-CPh/2ugOByPy8AvLfKRog+65LnJiVbJfwVwr3PG4wJU=' 'sha256-/QF9ucheBlXO04ZtK2+p3PUKnm0HXlN/ODAZAglxv4U=' 'sha256-+gB8K8PHR2w92lDZOEQlWXlrRTA69ZDPm8W0icbn7UQ=' 'sha256-3MAaORZtaTiQE+/ZAaeVmxGnCBpj7oxq8aCB0Se/Rzo='; script-src-attr 'none'; manifest-src 'none'; connect-src 'self'; base-uri 'none'; object-src 'none'; media-src 'none'; style-src 'self' 'unsafe-hashes' 'sha256-47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU=' 'sha256-jI6iy08EN9xHjk+wqivEvYFOTtdJQqdSH98ZEmBQmGE=' 'sha256-sC9roG6gjsOxA1jz9CZn8bm+B+LEew4Jef0kbhK/zYY=' 'sha256-eyDYjftaY/vsyZ/MdOp0/fOzXiFQ4Gr9UFK/9iaiZJ8=';"
        );

        return true;
    }
    
}


