package com.thecatapi.TesteApi;

public class MassaDeDados {
	String vote_id;
	String fav_id;
	
	String urlCadastro = "user/passwordlesssignup";
	String corpoCadastro = "{\"email\": \"larissacfdasilva@gmail.com\", \"appDescription\": \"teste the cat api\"}";
	String corpoVotacao = "{\"image_id\": \"6ut\", \"value\": \"true\", \"sub_id\": \"demo-78eb32\"}";
	String corpoFavorito = "{\"image_id\": \"cg7\", \"sub_id\": \"demo-78eb32\"}";
	String urlDesfavorita = "favourites/{favourite_id}";
	String api_key = "781908e3-a7c2-449b-ad88-b819817e78a0";
}
