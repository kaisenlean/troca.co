package co.icesi.troca.repositories;

import java.util.List;

import co.icesi.troca.model.troca.Ciudad;
import co.icesi.troca.model.troca.Departamento;

public interface CiudadDAO {


	List<Ciudad> findByDepto(Departamento departamento);
	Ciudad find(int id);
}
