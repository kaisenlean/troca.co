package co.icesi.troca.repositories;

import java.util.List;

import co.icesi.troca.model.troca.Pais;

public interface PaisDAO {

	List<Pais> findAll();
	Pais find(int id);
}
