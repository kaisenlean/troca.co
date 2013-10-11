package co.icesi.troca.repositories;

import java.util.List;

import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.model.troca.Pais;

public interface DepartamentoDAO {


	List<Departamento> findByPais(Pais pais);
	Departamento find(int id);
}
