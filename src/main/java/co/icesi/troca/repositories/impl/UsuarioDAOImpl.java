package co.icesi.troca.repositories.impl;

import org.springframework.stereotype.Repository;

import co.icesi.troca.model.troca.Usuario;
import co.icesi.troca.repositories.UsuarioDAO;

@Repository("usuarioDao")
public class UsuarioDAOImpl extends GenericJpaRepository<Usuario, Integer> implements UsuarioDAO {


}
