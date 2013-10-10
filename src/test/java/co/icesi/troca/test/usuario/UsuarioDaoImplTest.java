package co.icesi.troca.test.usuario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.icesi.troca.repositories.UsuarioDAO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
public class UsuarioDaoImplTest {

	
//	@Resource(name="usuarioDao")
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Test
	public void testFindAll() {
//	System.out.println(usuarioDAO.findAll().get(0).getNombre());
	
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}
