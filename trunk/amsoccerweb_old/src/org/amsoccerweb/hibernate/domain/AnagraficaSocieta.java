package org.amsoccerweb.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anagrafica_societa")
public class AnagraficaSocieta {
	
	@Id
	@GeneratedValue
	@Column(name = "id_anagrafica_societa")
	private int idAnagraficaSocieta; 
	
	@Column(name = "denominazione_sociale")
	private String denominazioneSociale;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@Column(name = "cap")
	private String cap;
	
	@Column(name = "citta")
	private String citta;
	
	@Column(name = "codice_fiscale")
	private String codiceFiscale;
	
	@Column(name = "partita_iva")
	private String partitaIva;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "sito_internet")
	private String sitoInternet;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "url_logo")
	private String urlLogo;
	
}
