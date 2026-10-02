package br.cefetrj.appcorp.config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateConfig {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(
                br.cefetrj.appcorp.model.Pessoa.class
            );
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
