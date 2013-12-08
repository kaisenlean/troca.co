/**
 * 
 */
package co.icesi.troca.repositories.proyecto.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.icesi.troca.exception.BaseException;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoVisita;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.impl.GenericJpaRepository;
import co.icesi.troca.repositories.proyecto.ProyectoVisitaDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoVisitaDaoImpl
 * @date 8/12/2013
 * 
 */
@Repository("proyectoVisitaDao")
public class ProyectoVisitaDaoImpl extends
		GenericJpaRepository<ProyectoVisita, Integer> implements Serializable,
		ProyectoVisitaDao {

	/**
	 * 8/12/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.proyecto.ProyectoVisitaDao#registrarVisita(co.icesi.troca.model.proyecto.Proyecto,
	 *      co.icesi.troca.model.usuario.Usuario)
	 */
	@Override
	public void registrarVisita(Proyecto proyecto, Usuario usuario)
			throws BaseException {
		ProyectoVisita visita = new ProyectoVisita();
		visita.setProyecto(proyecto);
		visita.setUsuario(usuario);
		save(visita);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see co.icesi.troca.repositories.proyecto.ProyectoVisitaDao#findProyectosMasVisitados()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> findProyectosMasVisitados(int maxResults) throws BaseException {
		List<Proyecto> proyectos=new ArrayList<Proyecto>();
	Query query= getEntityManager().createNativeQuery(new StringBuilder(
				"SELECT DISTINCT   pv.proyecto AS proyecto  FROM proyecto_visita  AS pv  ORDER BY  (SELECT COUNT(p.usuario) FROM proyecto_visita p WHERE p.proyecto = pv.proyecto)  DESC LIMIT ").append(maxResults==0?4:maxResults).toString()
				);
	List<Integer> result=query.getResultList();
	for (Integer p : result) {
		Proyecto pTemp=(Proyecto)(findById(p, Proyecto.class));
		proyectos.add(pTemp);
	}
	return proyectos;

}
	
}
