package code.injectors.track.city.ws.domain.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Chatzakis Nikolaos
 */
public class UUIDGenerator implements IdentifierGenerator {

    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        return UUID.randomUUID().toString();
    }
}
