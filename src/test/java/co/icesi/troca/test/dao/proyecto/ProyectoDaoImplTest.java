/**
 * 
 */
package co.icesi.troca.test.dao.proyecto;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.proyecto.Proyecto;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.UsuarioDao;
import co.icesi.troca.repositories.proyecto.ProyectoDao;
import co.icesi.troca.test.BaseUnit;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class ProyectoDaoImplTest
 * @date 7/11/2013
 * 
 */
public class ProyectoDaoImplTest extends BaseUnit {

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * NAME_PROYECTO
	 */
	private static final String NAME_PROYECTO = "nameProyecto";

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * DESC_LARG_PROYECTO
	 */
	private static final String DESC_LARG_PROYECTO = "DESC LARGAA PROYECTO";

	/**
	 * 7/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * DESCRIPCION_PROYECTO
	 */
	private static final String DESCRIPCION_PROYECTO = "DESCRIPCION PROYECTO";

	@Autowired
	private ProyectoDao proyectoDao;
	
	@Autowired
	private UsuarioDao usuarioDao;

	
	
	private static final String BIOGRAPHY_PRUEBA = "biography";
	private static final String PASSWORD_PRUEBA = "666";
	private static final String EMAIL_PRUEBA = "TROCA@TROCA.COM";
	private static final String APELLIDO_PRUEBA = "APELLIDO PRUEBA";
	private static final String NOMBRE_PRUEBA = "NOMBRE PRUEBA";

	
	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.proyecto.impl.ProyectoDaoImpl#findProyectosByUsuario(co.icesi.troca.model.usuario.Usuario)}
	 * .
	 */
	@Test
	public void testFindProyectosByUsuario() {
		Proyecto proyecto= saveProyectoTest();
		Usuario usuario= proyecto.getOwner();
		
		List<Proyecto> proyectos= proyectoDao.findProyectosByUsuario(usuario);
		
		assertNotNull(proyectos);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Proyecto> listado = proyectoDao.findAll();
		assertNotNull(listado);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findById(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testFindById() {
		Proyecto proyecto= saveProyectoTest();
		Integer id= proyecto.getId();
		
		proyecto=proyectoDao.findById(id);
		
		assertNotNull(proyecto);
		
		
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#delete(java.lang.Object)}
	 * .
	 */
	@Test
	public void testDelete() {
		Proyecto proyecto= saveProyectoTest();
		Integer id= proyecto.getId();
		
		proyectoDao.delete(proyecto);
		proyecto=proyectoDao.findById(id);
		assertNull(proyecto);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSave() {
		Proyecto proyecto= saveProyectoTest();
		assertNotNull(proyecto.getId());
	}

	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 7/11/2013
	* @return
	 */
	public Proyecto saveProyectoTest(){
		
	Proyecto proyecto= new Proyecto();
	proyecto.setDescripcion(DESCRIPCION_PROYECTO);
	proyecto.setDescripcionLarga(DESC_LARG_PROYECTO);
	proyecto.setNombre(NAME_PROYECTO);
	proyecto.setOwner(saveTestUsuario());
	
	return proyectoDao.save(proyecto);
	
	
	}
	
	
	/**
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 22/10/2013
	 * @return
	 */
	private Usuario saveTestUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombre(NOMBRE_PRUEBA);
		usuario.setApellido(APELLIDO_PRUEBA);
		usuario.setEmail(EMAIL_PRUEBA);
		usuario.setPassword(PASSWORD_PRUEBA);
		usuario.setBiografia(BIOGRAPHY_PRUEBA);
		Usuario temp = usuarioDao.save(usuario);
		return temp;
	}
}
