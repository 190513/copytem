/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.copytem.infra;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author quintanilha
 */
@SuppressWarnings("deprecation")
@Component
@ApplicationScoped
public class SessionCreatorFactory implements ComponentFactory<SessionFactory> {
    
    private SessionFactory factory;
    
    @PostConstruct
    public void abre(){
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure();
        
        this.factory = configuration.buildSessionFactory();        
    }

    public SessionFactory getInstance() {        
        return this.factory;        
    }
    
    @PreDestroy
    public void fecha(){
        this.factory.close();
    }
    
}
