package Util;

import java.util.UUID;

public class Util {
	
	public static String gerarCodigo() {
		return UUID.randomUUID().toString().substring(0, 5).toUpperCase();
	}
}
