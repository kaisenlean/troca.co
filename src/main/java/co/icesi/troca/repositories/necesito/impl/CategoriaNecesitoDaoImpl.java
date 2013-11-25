/**
 * 
 */
package co.icesi.troca.repositories.necesito.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.necesito.CategoriaNecesito;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.necesito.CategoriaNecesitoDao;

/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class CategoriaNecesitoDaoImpl
* @date 24/11/2013
*
 */
@Repository("categoriaNecesitoDao")
public class CategoriaNecesitoDaoImpl extends GenericJpaRepository<CategoriaNecesito, Integer> implements Serializable ,CategoriaNecesitoDao{

	
	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
}
