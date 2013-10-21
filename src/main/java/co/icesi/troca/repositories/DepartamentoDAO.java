package co.icesi.troca.repositories;

import java.util.List;

import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.model.troca.Pais;

public interface DepartamentoDAO extends GenericRepository<Departamento, Integer> {


	List<Departamento> findByPais(Pais pais);
}
