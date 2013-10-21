package co.icesi.troca.repositories.impl;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.troca.Pais;
import co.icesi.troca.repositories.PaisDAO;

@Repository("paisDao")
public  class PaisDAOImpl extends GenericJpaRepository<Pais, Integer> implements PaisDAO {

}
