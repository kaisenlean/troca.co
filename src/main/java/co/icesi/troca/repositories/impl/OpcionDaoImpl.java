/**
 * 
 */
package co.icesi.troca.repositories.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import co.icesi.troca.model.Opcion;
import co.icesi.troca.repositories.OpcionDao;

/**
 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
 * @project troca-co
 * @class OpcionDaoImpl
 * @date 6/11/2013
 *
 */
@Service("opcionDao")
public class OpcionDaoImpl extends GenericJpaRepository<Opcion, String>  implements OpcionDao,Serializable{

	/**
	 * 6/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * KEY_FIELD
	 */
	private static final String KEY_FIELD = "key";
	/**
	 * 6/11/2013
	 * @author <a href="mailto:elmerdiazlazo@gmail.com">Elmer Jose Diaz Lazo</a>
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** (non-Javadoc)
	 * @see co.icesi.troca.repositories.OpcionDao#getValueByKey(java.lang.String)
	 */
	@Override
	public String getValueByKey(String value) throws Exception{
		Criterion criterio = Restrictions.eq(KEY_FIELD, value);
		List<Opcion> lista = findByCriteria(criterio);
		if (lista.isEmpty()) {
			return null;
		}else{
		return	lista.get(BigDecimal.ZERO.intValue()).getValue();
		}
	}

}
