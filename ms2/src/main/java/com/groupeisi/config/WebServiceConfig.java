package com.groupeisi.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    public static final String HTTP_WS_M2GL = "http://ws.groupeisi.com";

    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean
    @Qualifier("infoSchema")
    public XsdSchema infoSchema(){
        return new SimpleXsdSchema(new ClassPathResource("shema.xsd"));
    }

    public DefaultWsdl11Definition infoWsDefinition(@Qualifier("infoSchema") XsdSchema infoSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("infoPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(HTTP_WS_M2GL);
        wsdl11Definition.setSchema(infoSchema);
        return wsdl11Definition;
    }

}
