package org.example.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在处理器方法执行之前执行
     *
     * @param request  请求
     * @param response 响应
     * @param handler  HandlerMethod对象，封装了处理器方法的相关信息
     * @return 返回true表示请求被放行，返回false则拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("preHandle执行了.....");
        String url = request.getRequestURL().toString();
        System.out.println("请求: "+url);

        return true;
    }

    /**
     * 在处理器执行之后，但是在视图解析之前执行该方法
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 在同步跳转视图的controller中，这里就是处理器执行后的结果。但是还没被视图解析器解析。
     *                     所以可以修改
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle执行了.....");
    }

    /**
     * 整个流程执行完成了，最后执行的方法。无论有没有异常，这个方法都会执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex 执行过程中抛出的异常。一般不处理，通过异常处理器处理即可
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion执行了.....");
    }
}

