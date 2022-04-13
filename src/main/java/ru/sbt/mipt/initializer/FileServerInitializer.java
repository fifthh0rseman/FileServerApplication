package ru.sbt.mipt.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class FileServerInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        var context = new AnnotationConfigWebApplicationContext();
        context.scan("ru.sbt.mipt");
        context.refresh();

        var registrationDynamic =
                servletContext.addServlet("app", new DispatcherServlet(context));
        registrationDynamic.setLoadOnStartup(1);
        registrationDynamic.addMapping("/");
    }
}
