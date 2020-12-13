package ru.amelin.mvc.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Замена web.xml
 */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
//      этот метод не будет использоваться
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
//      указание класса со Spring-конфигурацией
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
//      любые запросы будут обрабатываться DispatcherServlet
        return new String[]{"/"};
    }


    //запускается при старте приложения
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

//  Добавляет к приложению фильтр hiddenHttpMethodFilter, который перехватывает все входящие http запросы,
//  смотрит скрытое поле _method и перенаправляет запросы на нужные методы контроллера
    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }

}
