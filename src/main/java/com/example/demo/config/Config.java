package com.example.demo.config;

import com.example.demo.endpoints.EndPoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class Config {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletServlet(ApplicationContext context){
        MessageDispatcherServlet messageDispatcherServlet= new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);

        return  new ServletRegistrationBean<>(messageDispatcherServlet);
    }

    @Bean
    public XsdSchema schema(){
        return  new SimpleXsdSchema(new ClassPathResource("loanEligebilty.xsd"));
    }


    @Bean("loan")
    public DefaultWsdl11Definition wsdl11Definition(XsdSchema schema){
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setSchema(schema);
        defaultWsdl11Definition.setTargetNamespace(EndPoint.nameSpace);
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setPortTypeName("ServiceIndicator");
        return defaultWsdl11Definition;
    }
}
