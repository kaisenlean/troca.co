package co.icesi.troca.repositories.impl;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.usuario.Usuario;
import co.icesi.troca.repositories.UsuarioDao;
/**
 * 
* @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
* @project troca-co
* @class UsuarioDAOImpl
* @date 22/10/2013
*
*/
@Repository("usuarioDao")
public class UsuarioDaoImpl extends GenericJpaRepository<Usuario, Integer>
		implements UsuarioDao {

}
