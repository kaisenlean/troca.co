package co.icesi.troca.services;

import java.io.Serializable;

import co.icesi.troca.repositories.GenericRepository;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class GenericService
 * @date 22/10/2013
 * 
 */
public interface GenericService<C, PK extends Serializable> extends
		GenericRepository<C, PK> {

}
