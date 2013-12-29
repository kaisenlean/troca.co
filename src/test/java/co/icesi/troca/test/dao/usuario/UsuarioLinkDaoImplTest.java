/**
 * 
 */
package co.icesi.troca.test.dao.usuario;

import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.model.usuario.UsuarioLink;
import co.icesi.troca.repositories.UsuarioDao;
import co.icesi.troca.repositories.usuario.UsuarioLinkDao;
import co.icesi.troca.test.BaseUnit;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class UsuarioLinkDaoImplTest
 * @date 28/11/2013
 * 
 */
public class UsuarioLinkDaoImplTest extends BaseUnit {

	/**
	 * 27/11/2013
	 * 
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 *         FILTER_PHRASE
	 */
	private static final String BIOGRAPHY_PRUEBA = "biography";
	private static final String PASSWORD_PRUEBA = "666";
	private static final String EMAIL_PRUEBA = "TROCA@TROCA.COM";
	private static final String APELLIDO_PRUEBA = "APELLIDO PRUEBA";
	private static final String NOMBRE_PRUEBA = "NOMBRE PRUEBA";
	@Autowired
	private UsuarioLinkDao usuarioLinkDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@Test
	public void getLinkByUsuario() {
		List<UsuarioLink> lista = usuarioLinkDao
				.getLinkByUsuario(saveTestUsuario());
		assertNotNull(lista);
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
	 * Test method for
	 * {@link co.icesi.troca.repositories.impl.GenericJpaRepository#findAll()}.
	 */
	@Test
	public void testFindAll() {
		List<UsuarioLink> lista = usuarioLinkDao.findAll();
		assertNotNull(lista);

	}
}
