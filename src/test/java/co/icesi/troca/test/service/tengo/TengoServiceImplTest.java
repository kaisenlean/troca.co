/**
 * 
 */
package co.icesi.troca.test.service.tengo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.tengo.EstadoTengo;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.services.UsuarioService;
import co.icesi.troca.services.tengo.TengoService;
import co.icesi.troca.services.tengo.impl.TengoServiceImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * Test case de la clase {@link TengoServiceImpl}
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class {@link TengoServiceImpl}
 * @date 31/10/2013
 *
 */
public class TengoServiceImplTest  extends BaseUnit{


	/**
	 * 31/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * DESCRIPCION_TENGO
	 */
	private static final String DESCRIPCION_TENGO = "DESCRIPCION TENGO";
	/**
	 * 31/10/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * NOMBRE_TENGO
	 */
	private static final String NOMBRE_TENGO = "TENGO 1";
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TengoService tengoService;
	

	private static final String BIOGRAPHY_PRUEBA = "biography";
	private static final String PASSWORD_PRUEBA = "666";
	private static final String EMAIL_PRUEBA = "TROCA@TROCA.COM";
	private static final String APELLIDO_PRUEBA = "APELLIDO PRUEBA";
	private static final String NOMBRE_PRUEBA = "NOMBRE PRUEBA";
	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@Test
	public void testFindAll() {
		List<Tengo> listado= tengoService.findAll();
		assertNotNull(listado);
	}

	
	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@Test
	public void testFindById() {
		Tengo tengo = createTengoTest();
		int id= tengo.getId();
		
		tengo=tengoService.findById(id);
		assertNotNull(tengo);
		
	}

	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@Test
	public void testDelete() {
	Tengo tengo = createTengoTest();
	tengoService.delete(tengo);
	tengo=tengoService.findById(tengo.getId());
	assertNull(tengo);
	
	
	}

	/**
	 * 
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	 */
	@Test
	public void testSave() {
	Tengo tengo= createTengoTest();
	assertNotNull(tengo.getId());
	}
	

	/**
	* @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	* @date 31/10/2013
	* @return
	*/
	private Tengo createTengoTest() {
		Usuario usuario= saveTestUsuario();
		Tengo  tengo= new Tengo();
		tengo.setOwner(usuario);
		tengo.setNombre(NOMBRE_TENGO);
		tengo.setEstado(EstadoTengo.ACTIVO);
		tengo.setDescripcion(DESCRIPCION_TENGO);
		tengo=tengoService.save(tengo);
		return tengo;
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
		Usuario temp = usuarioService.save(usuario);
		return temp;
	}
	

}
