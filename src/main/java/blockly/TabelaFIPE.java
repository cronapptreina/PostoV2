package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TabelaFIPE {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// tabelaFIPE
	public static Var marcas() throws Exception {
		return new Callable<Var>() {

			private Var marcaO = Var.VAR_NULL;
			private Var marcaJson = Var.VAR_NULL;
			private Var marcaId = Var.VAR_NULL;
			private Var url = Var.VAR_NULL;
			private Var consultamodelos = Var.VAR_NULL;
			private Var exception = Var.VAR_NULL;
			private Var consultamarcas = Var.VAR_NULL;

			public Var call() throws Exception {
				try {
					consultamarcas = cronapi.json.Operations.toJson(cronapi.util.Operations.getURLFromOthers(
							Var.valueOf("GET"), Var.valueOf("application/json"),
							Var.valueOf("http://fipeapi.appspot.com/api/1/carros/marcas.json"), Var.VAR_NULL,
							Var.VAR_NULL));
					System.out.println(consultamarcas.getObjectAsString());
				} catch (Exception exception_exception) {
					exception = Var.valueOf(exception_exception);
					consultamarcas = cronapi.json.Operations.createObjectJson();
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("success"), Var.valueOf(
									"Não foi possivel obter dados da tabela FIPE. Favor digitar a marca manualmente"));
				} finally {
				}
				return consultamarcas;
			}
		}.call();
	}

	/**
	 *
	 * @param marcaO
	 * @return Var
	 */
	// tabelaFIPE
	public static Var modelos(Var marcaO) throws Exception {
		return new Callable<Var>() {

			private Var marcaJson = Var.VAR_NULL;
			private Var marcaId = Var.VAR_NULL;
			private Var url = Var.VAR_NULL;
			private Var consultamodelos = Var.VAR_NULL;
			private Var exception = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(marcaO.getObjectAsString());
				marcaJson = cronapi.json.Operations.getJsonOrMapField(cronapi.json.Operations.toJson(marcaO),
						Var.valueOf("fipe_name"));
				System.out.println(marcaJson.getObjectAsString());
				marcaId = cronapi.json.Operations.getJsonOrMapField(marcaJson, Var.valueOf("id"));
				System.out.println(marcaId.getObjectAsString());
				try {
					url = Var.valueOf(Var.valueOf("http://fipeapi.appspot.com/api/1/carros/veiculos/").toString()
							+ marcaId.toString() + Var.valueOf(".json").toString());
					System.out.println(url.getObjectAsString());
					consultamodelos = cronapi.json.Operations.toJson(cronapi.util.Operations.getURLFromOthers(
							Var.valueOf("GET"), Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL));
					System.out.println(consultamodelos.getObjectAsString());
				} catch (Exception exception_exception) {
					exception = Var.valueOf(exception_exception);
					consultamodelos = cronapi.json.Operations.createObjectJson();
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("success"), Var.valueOf(
									"Não foi possivel obter dados da tabela FIPE. Favor digitar o modelo manualmente"));
				} finally {
				}
				return consultamodelos;
			}
		}.call();
	}

}
