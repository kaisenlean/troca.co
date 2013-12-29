package co.icesi.troca.repositories.impl;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.Pais;
import co.icesi.troca.repositories.PaisDao;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class PaisDAOImpl
 * @date 22/10/2013
 * 
 */
@Repository("paisDao")
public class PaisDaoImpl extends GenericJpaRepository<Pais, Integer> implements
		PaisDao {

}
