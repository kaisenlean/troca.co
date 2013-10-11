package co.icesi.troca.services;

import java.util.List;

import javax.faces.model.SelectItem;

import co.icesi.troca.model.troca.Ciudad;
import co.icesi.troca.model.troca.Departamento;

public interface CiudadService {

	
	List<SelectItem> getItmemsByDepto(Departamento pais);
	Ciudad find(int id);
}