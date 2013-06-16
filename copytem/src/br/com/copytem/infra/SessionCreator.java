/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.copytem.infra;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



/**
 *
 * @author quintanilha
 */
@Component
public class SessionCreator implements ComponentFactory<Session> {
    
    private final SessionFactory factory;
    private Session session;

    public SessionCreator(SessionFactory factory) {
        this.factory = factory;
    }
    
    @PostConstruct
    public void abre(){
        this.session = factory.openSession();
    }
    
    public Session getInstance() {
        return this.session;
    }
    
    @PreDestroy
    public void fecha(){
        this.session.close();
    }
}
