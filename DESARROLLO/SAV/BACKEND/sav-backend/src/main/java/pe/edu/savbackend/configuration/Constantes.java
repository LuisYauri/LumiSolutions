package pe.edu.savbackend.configuration;

public class Constantes {
//	public static final Key SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	public static final String SECRET_STRING = "1234";
	/*Aqui se genera el par de llaves privadas y publicas */
	//public static final KeyPair KEY_PAIR = Keys.keyPairFor(SignatureAlgorithm.RS256);	
	public static final long EXPIRATION_DATE = 1000000L;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}
