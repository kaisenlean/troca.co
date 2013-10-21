package co.icesi.troca.test.pais;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import co.icesi.troca.repositories.UsuarioDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class UsuarioDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UsuarioDAO dao;


	@Test
	public void testCreate() {
//		fail("Not yet implemented");
	}
	
	
	@Test
	public void testFindAll(){
		System.out.println(dao.findAll());
		
	}
	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

}
