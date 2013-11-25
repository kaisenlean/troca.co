/**
 * 
 */
package co.icesi.troca.test.service.proyecto;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.proyecto.ProyectoTengoUsuario;
import co.icesi.troca.services.proyecto.ProyectoTengoUsuarioService;
import co.icesi.troca.test.BaseUnit;
/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDaoImplTest
 * @date 7/11/2013
 * 
 */
public class ProyectoTengoUsuarioServiceImplTest extends BaseUnit {

	
	@Autowired
	private ProyectoTengoUsuarioService proyectoTengoUsuarioDao;
	
	
	
	@Test
	public void testFindAll(){
		
		List<ProyectoTengoUsuario> lista = proyectoTengoUsuarioDao.findAll();
		assertNotNull(lista);
	}
}
