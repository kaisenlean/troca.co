package co.icesi.troca.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Service;

import co.icesi.troca.model.troca.Departamento;
import co.icesi.troca.model.troca.Pais;
import co.icesi.troca.repositories.DepartamentoDAO;
import co.icesi.troca.services.DepartamentoService;

@Service("departamentoService")
public class DepartamentoServiceImpl implements DepartamentoService, Serializable {

	private static final long serialVersionUID = -7342021171479215673L;
	@Resource(name = "departamentoDao")
	private DepartamentoDAO departamentoDao;




	@Override
	public List<SelectItem> getItmemsByPais(Pais pais) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Departamento> departamentos = departamentoDao.findByPais(pais);
		for (Departamento departamento : departamentos) {
			items.add(new SelectItem(departamento.getId(),departamento.getNombre()));
		}
		
		return items;
	}

	@Override
	public Departamento find(int id) {
		return departamentoDao.find(id);
	}



}
