package co.icesi.troca.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Service;

import co.icesi.troca.model.Departamento;
import co.icesi.troca.model.Pais;
import co.icesi.troca.repositories.DepartamentoDao;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.services.DepartamentoService;

/**
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class DepartamentoServiceImpl
 * @date 22/10/2013
 * 
 */
@Service("departamentoService")
public class DepartamentoServiceImpl extends
		GenericServiceImpl<Departamento, Integer> implements
		DepartamentoService, Serializable {

	private static final long serialVersionUID = -7342021171479215673L;
	@Resource(name = "departamentoDao")
	private DepartamentoDao departamentoDao;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Departamento, Integer> getDao() {
		return departamentoDao;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.services.DepartamentoService#getItmemsByPais(co.icesi.troca.model.Pais)
	 */
	@Override
	public List<SelectItem> getItmemsByPais(Pais pais) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Departamento> departamentos = departamentoDao.findByPais(pais);
		items.add(new SelectItem(0, "- - SELECCIONA UN DEPARTAMENTO - -"));
		for (Departamento departamento : departamentos) {
			items.add(new SelectItem(departamento.getId(), departamento
					.getNombre()));
		}

		return items;
	}

}
