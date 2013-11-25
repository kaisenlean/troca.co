/**
 * 
 */
package co.icesi.troca.test.dao.necesito.categoria;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.necesito.CategoriaNecesito;
import co.icesi.troca.repositories.necesito.CategoriaNecesitoDao;
import co.icesi.troca.test.BaseUnit;

import static org.junit.Assert.assertNotNull;

/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class CategoriaNecesitoDaoImplTest
* @date 24/11/2013
*
 */
public class CategoriaNecesitoDaoImplTest extends BaseUnit{

	/**
	 * 24/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * categoriaNecesitoDao
	 */
	@Autowired
	private CategoriaNecesitoDao categoriaNecesitoDao;
	
	
	
	@Test
	public void testFindAll(){
		
		List<CategoriaNecesito> lista= categoriaNecesitoDao.findAll();
		assertNotNull(lista);
		
	}
}
