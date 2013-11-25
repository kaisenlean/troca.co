/**
 * 
 */
package co.icesi.troca.test.service.necesito.categoria;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.necesito.CategoriaNecesito;
import co.icesi.troca.services.necesito.CategoriaNecesitoService;
import co.icesi.troca.test.BaseUnit;

/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class CategoriaNecesitoServiceImplTest
* @date 24/11/2013
*
 */
public class CategoriaNecesitoServiceImplTest extends BaseUnit{

	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * categoriaNecesitoService
	 */
	@Autowired
	private CategoriaNecesitoService categoriaNecesitoService;
	
	
	
	@Test
	public void testFindAll(){
		
		List<CategoriaNecesito> lista= categoriaNecesitoService.findAll();
		assertNotNull(lista);
		
	}
}
