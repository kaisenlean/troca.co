package co.icesi.troca.test.pais;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.icesi.troca.repositories.UsuarioDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
public class UsuarioDAOImplTest {

	@Autowired
	private UsuarioDAO dao;


	@Test
	public void testCreate() {
//		fail("Not yet implemented");
	}
	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

}
