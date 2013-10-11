package co.icesi.troca.services;

import java.util.List;

import javax.faces.model.SelectItem;

import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.model.troca.Pais;

public interface DepartamentoService {

	
	List<SelectItem> getItmemsByPais(Pais pais);
	Departamento find(int id);
}