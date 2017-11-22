package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Campeoes {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Campeoes
	public static Var carros() throws Exception {
		return new Callable<Var>() {

			private Var retorno = Var.VAR_NULL;
			private Var consulta = Var.VAR_NULL;

			public Var call() throws Exception {
				retorno = cronapi.list.Operations.newList();
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.Abastecimento"),
						Var.valueOf("select a.carro.marca.nome, a.carro.modelo.nome from Abastecimento a"),
						Var.VAR_NULL);
				return Var.VAR_NULL;
			}
		}.call();
	}

}
