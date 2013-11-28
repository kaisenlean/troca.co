/**
 * 
 */
package co.icesi.troca.test.dao.proyecto.categoria;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.proyecto.ProyectoCategoria;
import co.icesi.troca.repositories.proyecto.ProyectoCategoriaDao;
import co.icesi.troca.test.BaseUnit;
/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoCategoriaDaoImpl
 * @date 24/11/2013
 *
 */
public class ProyectoCategoriaDaoImplTest  extends BaseUnit{

	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * proyectoCategoriaDao
	 */
	@Autowired
	private ProyectoCategoriaDao proyectoCategoriaDao;
	
	
	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 24/11/2013
	*/
	@Test
	public void testFindAll(){
		List<ProyectoCategoria> categorias = proyectoCategoriaDao.findAll();
		assertNotNull(categorias);
		
	}
}
