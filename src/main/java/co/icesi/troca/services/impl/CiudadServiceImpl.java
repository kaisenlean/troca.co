package co.icesi.troca.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Service;

import co.icesi.troca.model.Ciudad;
import co.icesi.troca.model.Departamento;
import co.icesi.troca.repositories.CiudadDao;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.services.CiudadService;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class CiudadServiceImpl
* @date 22/10/2013
*
 */
@Service("ciudadService")
public class CiudadServiceImpl extends GenericServiceImpl<Ciudad, Integer> implements CiudadService, Serializable {

	private static final long serialVersionUID = -7342021171479215673L;
	@Resource(name = "ciudadDao")
	private CiudadDao ciudadDao;
/**
 * (non-Javadoc)
 * @see co.icesi.troca.services.CiudadService#getItmemsByDepto(co.icesi.troca.model.Departamento)
 */
	@Override
	public List<SelectItem> getItmemsByDepto(Departamento departamento) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Ciudad> departamentos = ciudadDao.findByDepto(departamento);
		items.add(new SelectItem(0,"- - SELECCIONA UNA CIUDAD - -"));
		for (Ciudad ciudad : departamentos) {
			items.add(new SelectItem(ciudad.getId(), ciudad.getNombre()));
		}

		return items;
	}

/**
 * (non-Javadoc)
 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
 */
	@Override
	public GenericRepository<Ciudad, Integer> getDao() {
		return ciudadDao;
	}

}
