package co.icesi.troca.services;

import java.util.List;

import javax.faces.model.SelectItem;

import co.icesi.troca.model.troca.Pais;

public interface PaisService {

	List<Pais> findAll();
	List<SelectItem> getItmems();
	Pais find(int id);
}