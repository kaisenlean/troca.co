package co.icesi.troca.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Service;

import co.icesi.troca.model.troca.Ciudad;
import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.repositories.CiudadDAO;
import co.icesi.troca.services.CiudadService;

@Service("ciudadService")
public class CiudadServiceImpl implements CiudadService, Serializable {

	private static final long serialVersionUID = -7342021171479215673L;
	@Resource(name = "ciudadDao")
	private CiudadDAO ciudadDao;

	@Override
	public List<SelectItem> getItmemsByDepto(Departamento departamento) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Ciudad> departamentos = ciudadDao.findByDepto(departamento);
		for (Ciudad ciudad : departamentos) {
			items.add(new SelectItem(ciudad.getId(),ciudad.getNombre()));
		}
		
		return items;
	}

	@Override
	public Ciudad find(int id) {
		return ciudadDao.findById(id);
	}



}
