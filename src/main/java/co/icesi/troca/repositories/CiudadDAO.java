package co.icesi.troca.repositories;

import java.util.List;

import co.icesi.troca.model.troca.Ciudad;
import co.icesi.troca.model.troca.Departamento;

public interface CiudadDAO extends GenericRepository<Ciudad, Integer>{


	List<Ciudad> findByDepto(Departamento departamento);
}
