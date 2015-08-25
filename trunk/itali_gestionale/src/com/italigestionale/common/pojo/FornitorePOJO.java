package com.italigestionale.common.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fornitore")
public class FornitorePOJO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_fornitore")
	private Integer id_fornitore;
	
	@Column(name="codice_fornitore")
	private String codice_fornitore; 
	
	@Column(name="tipologia")
	private String tipologia; 
	
	@Column(name="ragione_sociale")
	private String ragione_sociale; 
	
	@Column(name="tipo_ditta")
	private String tipo_ditta;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="indirizzo")
	private String indirizzo;
	
	@Column(name="civico")
	private String civico;
	
	@Column(name="stato")
	private String stato;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="citta")
	private String citta;
	
	@Column(name="cap")
	private String cap;
	
	@Column(name="telefono")
	private String telefono; 
	
	@Column(name="fax")
	private String fax;
	
	@Column(name="cellulare_1")
	private String cellulare_1;
	
	@Column(name="cellulare_2")
	private String cellulare_2;
	
	@Column(name="partita_iva")
	private String partita_iva;
	
	@Column(name="codice_fiscale")
	private String codice_fiscale;
	
	@Column(name="email")
	private String email;
	
	@Column(name="sito_web")
	private String sito_web;
	
	@Column(name="banca")
	private String banca;
	
	@Column(name="agenzia")
	private String agenzia;
	
	@Column(name="iban")
	private String iban;
	
	@Column(name="swift")
	private String swift;
	
	@Column(name="conto")
	private String conto;
	
	@Column(name="bban")
	private String bban;
	
	@Column(name="cin")
	private String cin; 
	
	@Column(name="abi")
	private String abi;
	
	@Column(name="cab")
	private String cab;	
	
	@Column(name="note")
	private String note;

	public Integer getId_fornitore() {
		return id_fornitore;
	}

	public void setId_fornitore(Integer id_fornitore) {
		this.id_fornitore = id_fornitore;
	}

	public String getCodice_fornitore() {
		return codice_fornitore;
	}

	public void setCodice_fornitore(String codice_fornitore) {
		this.codice_fornitore = codice_fornitore;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getRagione_sociale() {
		return ragione_sociale;
	}

	public void setRagione_sociale(String ragione_sociale) {
		this.ragione_sociale = ragione_sociale;
	}

	public String getTipo_ditta() {
		return tipo_ditta;
	}

	public void setTipo_ditta(String tipo_ditta) {
		this.tipo_ditta = tipo_ditta;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCellulare_1() {
		return cellulare_1;
	}

	public void setCellulare_1(String cellulare_1) {
		this.cellulare_1 = cellulare_1;
	}

	public String getCellulare_2() {
		return cellulare_2;
	}

	public void setCellulare_2(String cellulare_2) {
		this.cellulare_2 = cellulare_2;
	}

	public String getPartita_iva() {
		return partita_iva;
	}

	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSito_web() {
		return sito_web;
	}

	public void setSito_web(String sito_web) {
		this.sito_web = sito_web;
	}

	public String getBanca() {
		return banca;
	}

	public void setBanca(String banca) {
		this.banca = banca;
	}

	public String getAgenzia() {
		return agenzia;
	}

	public void setAgenzia(String agenzia) {
		this.agenzia = agenzia;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getConto() {
		return conto;
	}

	public void setConto(String conto) {
		this.conto = conto;
	}

	public String getBban() {
		return bban;
	}

	public void setBban(String bban) {
		this.bban = bban;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getAbi() {
		return abi;
	}

	public void setAbi(String abi) {
		this.abi = abi;
	}

	public String getCab() {
		return cab;
	}

	public void setCab(String cab) {
		this.cab = cab;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
