package co.icesi.troca.test.pais;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.icesi.troca.services.PaisService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:WebContent/WEB-INF/applicationContext.xml"})
public class PaisServiceImplTest {

	
	@Autowired
	private PaisService paisService;

	@Test
	public void testFindAll() {
		Assert.assertNotNull(paisService.findAll());
	
	}
public void setPaisService(PaisService paisService) {
	this.paisService = paisService;
}
	
}
