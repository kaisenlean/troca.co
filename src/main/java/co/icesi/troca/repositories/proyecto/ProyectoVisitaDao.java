/**
 * 
 */
package co.icesi.troca.repositories.proyecto;

import java.util.List;

import co.icesi.troca.exception.BaseException;
import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.proyecto.ProyectoVisita;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.GenericRepository;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoVisitaDao
 * @date 8/12/2013
 * 
 */
public interface ProyectoVisitaDao extends
		GenericRepository<ProyectoVisita, Integer> {

	/**
	 * Método que consulta los proyectos destacados
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @return
	 * @throws BaseException
	 * 
	 */
	List<Proyecto> findProyectosMasVisitados(int maxResults)
			throws BaseException;

	/**
	 * Guardar una visita en la base de datos
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 8/12/2013
	 * @param proyecto
	 * @param usuario
	 * @throws BaseException
	 */
	void registrarVisita(Proyecto proyecto, Usuario usuario)
			throws BaseException;

}
