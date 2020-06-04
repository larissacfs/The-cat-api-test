package com.thecatapi.TesteApi;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TesteApi extends MassaDeDados {

	@BeforeClass
	public static void urlBase() {
		//website https://thecatapi.com/
		RestAssured.baseURI = "https://api.thecatapi.com/v1/";
	}

	@Test
	public void cadastro() {

		// dado, quando
		Response response = given().contentType("application/json").body(corpoCadastro).when().post(urlCadastro);

		// entao, sao validacoes
		validaSucesso(response);

	}

	public void votacao() {

		// dado, quando
		Response response = given().contentType("application/json").body(corpoVotacao).when().post("votes/");

		// entao, sao validacoes
		validaSucesso(response);

		// pegando o id contido na resposta
		String id = response.jsonPath().getString("id");
		//System.out.println("Id = " + id);
		vote_id = id;

	}

	public void deletaVotacao() {

		// dado, quando
		Response response = given().contentType("application/json").header("x-api-key", api_key)
				.pathParam("vote_id", vote_id).when().delete("votes/{vote_id}");

		// entao, sao validacoes
		validaSucesso(response);

	}

	@Test
	public void deletaVoto() {

		votacao();
		deletaVotacao();

	}

	public void favorito() {

		// dado, quando
		Response response = given().contentType("application/json").header("x-api-key", api_key).body(corpoFavorito)
				.when().post("favourites");

		// entao, sao validacoes
		validaSucesso(response);

		// pegando o id contido na resposta
		String id = response.jsonPath().getString("id");
		//System.out.println("Id = " + id);

		fav_id = id;

	}

	@Test
	public void deletaFavorito() {

		favorito();
		deletaFav();

	}

	public void deletaFav() {

		// dado, quando
		Response response = given().contentType("application/json").header("x-api-key", api_key)
				.pathParam("favourite_id", fav_id).when().delete(urlDesfavorita);

		// entao, sao validacoes
		validaSucesso(response);

	}

	public void validaSucesso(Response response) {
		response.then().statusCode(200).body("message", containsString("SUCCESS"));
		System.out.println("Retorno = " + response.body().asString());
		System.out.println(".............................");
	}
}
