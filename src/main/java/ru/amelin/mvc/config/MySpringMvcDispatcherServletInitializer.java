package ru.amelin.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
}
