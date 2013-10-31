package co.icesi.troca.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Service;

import co.icesi.troca.model.Pais;
import co.icesi.troca.repositories.GenericRepository;
import co.icesi.troca.repositories.PaisDao;
import co.icesi.troca.services.PaisService;

@Service("paisService")
public class PaisServiceImpl extends GenericServiceImpl<Pais, Integer> implements PaisService, Serializable {

	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7342021171479215673L;
	/**
	 * 22/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * paisDao
	 */
	@Resource(name = "paisDao")
	private PaisDao paisDao;

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#findAll()
	 */
	@Override
	public List<Pais> findAll() {
		return paisDao.findAll();
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @return
	*/
	public PaisDao getPaisDao() {
		return paisDao;
	}

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 22/10/2013
	* @param paisDao
	*/
	public void setPaisDao(PaisDao paisDao) {
		this.paisDao = paisDao;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.PaisService#getItmems()
	 */
	@Override
	public List<SelectItem> getItmems() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Pais> paises = paisDao.findAll();
		items.add(new SelectItem(0,"- - SELECCIONA UNA PAIS - -"));
		for (Pais pais : paises) {
			items.add(new SelectItem(pais.getId(), pais.getNombre()));
		}

		return items;
	}

	/** (non-Javadoc)
	 * @see co.icesi.troca.services.impl.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericRepository<Pais, Integer> getDao() {
		return paisDao;
	}

}
