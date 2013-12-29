/**
 * 
 */
package co.icesi.troca.test.dao.tengo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.tengo.EstadoTengo;
import co.icesi.troca.model.tengo.Tengo;
import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.UsuarioDao;
import co.icesi.troca.repositories.tengo.TengoDao;
import co.icesi.troca.repositories.tengo.impl.TengoDaoImpl;
import co.icesi.troca.test.BaseUnit;

/**
 * Test case de la clase
 * {@link co.icesi.troca.repositories.tengo.impl.TengoDaoImpl}
 * 
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class TengoDaoImpl
 * @date 31/10/2013
 * 
 */

public class TengoDaoImplTest extends BaseUnit {

	/**
	 * 1/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         MAX_RESULT_TENGOS
	 */
	private static final int MAX_RESULT_TENGOS = 2;
	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         DESCRIPCION_TENGO
	 */
	private static final String DESCRIPCION_TENGO = "DESCRIPCION TENGO";
	/**
	 * 31/10/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         NOMBRE_TENGO
	 */
	private static final String NOMBRE_TENGO = "TENGO 1";
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private TengoDao tengoDao;

	private static final String BIOGRAPHY_PRUEBA = "biography";
	private static final String PASSWORD_PRUEBA = "666";
	private static final String EMAIL_PRUEBA = "TROCA@TROCA.COM";
	private static final String APELLIDO_PRUEBA = "APELLIDO PRUEBA";
	private static final String NOMBRE_PRUEBA = "NOMBRE PRUEBA";

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @return
	 */
	private Tengo createTengoTest() {
		Usuario usuario = saveTestUsuario();
		Tengo tengo = new Tengo();
		tengo.setOwner(usuario);
		tengo.setNombre(NOMBRE_TENGO);
		tengo.setEstado(EstadoTengo.ACTIVO);
		tengo.setDescripcion(DESCRIPCION_TENGO);
		tengo = tengoDao.save(tengo);
		return tengo;
	}

	/**
	 * Test method for {@link TengoDaoImpl#findTengosByUsuario(Usuario)}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 */
	@Test
	public void findTengosByUsuario() {

		Tengo tengo1 = createTengoTest();
		List<Tengo> tengos = tengoDao.findTengosByUsuario(tengo1.getOwner());
		assertNotNull(tengos);
	}

	/**
	 * Test method for {@link TengoDaoImpl#findUltimosTengo(int)}
	 * 
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 1/11/2013
	 */
	@Test
	public void findUltimosTengo() {
		List<Tengo> listado = tengoDao.findUltimosTengo(MAX_RESULT_TENGOS);
		assertNotNull(listado);
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

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param tengoDao
	 *            the tengoDao to set
	 */
	public void setTengoDao(TengoDao tengoDao) {
		this.tengoDao = tengoDao;
	}

	/**
	 * @author <a href="elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * @date 31/10/2013
	 * @param usuarioDao
	 *            the usuarioDao to set
	 */
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#delete(java.lang.Object)}
	 * .
	 */
	@Test
	public void testDelete() {
		Tengo tengo = createTengoTest();
		tengoDao.delete(tengo);
		tengo = tengoDao.findById(tengo.getId());
		assertNull(tengo);

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<Tengo> listado = tengoDao.findAll();
		assertNotNull(listado);
	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findById(java.io.Serializable)}
	 * .
	 */
	@Test
	public void testFindById() {
		Tengo tengo = createTengoTest();
		int id = tengo.getId();

		tengo = tengoDao.findById(id);
		assertNotNull(tengo);

	}

	/**
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#save(java.lang.Object)}
	 * .
	 */
	@Test
	public void testSave() {
		Tengo tengo = createTengoTest();
		assertNotNull(tengo.getId());
	}

}
