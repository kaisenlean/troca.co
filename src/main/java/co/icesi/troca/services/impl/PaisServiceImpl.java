package co.icesi.troca.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Service;

import co.icesi.troca.model.troca.Pais;
import co.icesi.troca.repositories.PaisDAO;
import co.icesi.troca.services.PaisService;

@Service("paisService")
public class PaisServiceImpl implements PaisService, Serializable {

	private static final long serialVersionUID = -7342021171479215673L;
	@Resource(name = "paisDao")
	private PaisDAO paisDao;

	@Override
	public List<Pais> findAll() {
		return paisDao.findAll();
	}

	public PaisDAO getPaisDao() {
		return paisDao;
	}

	public void setPaisDao(PaisDAO paisDao) {
		this.paisDao = paisDao;
	}

	@Override
	public List<SelectItem> getItmems() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Pais> paises = paisDao.findAll();
		for (Pais pais : paises) {
			items.add(new SelectItem(pais.getId(),pais.getNombre()));
		}
		
		return items;
	}

	@Override
	public Pais find(int id) {
		return paisDao.findById(id);
	}

}
