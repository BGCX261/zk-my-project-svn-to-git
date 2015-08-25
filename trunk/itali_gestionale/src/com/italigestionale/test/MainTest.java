package com.italigestionale.test;

import com.italigestionale.bean.Fornitore;
import com.italigestionale.integration.IntegrationInterface;
import com.italigestionale.integration.MyFactory;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntegrationInterface integrationInterface = MyFactory.getFactory().getInterface();
		
		Fornitore fornitore = new Fornitore();
		fornitore.setId_fornitore(null);
		fornitore.setCodice_fornitore("123");
		fornitore.setRagione_sociale("Mussa S.R.L");
		fornitore.setCognome("Mussa");
		fornitore.setNome("Enzo");
		integrationInterface.insertFornitorePOJO(fornitore);
		
	}

}
