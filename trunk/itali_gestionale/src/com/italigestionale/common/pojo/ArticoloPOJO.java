package com.italigestionale.common.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articolo")
public class ArticoloPOJO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_articolo")
	private Integer id_articolo;
	
	@Column(name="codice_articolo")
	private String codice_articolo;
	
	@Column(name="codice_fornitore")
	private String codice_fornitore;
	
	@Column(name="codice_ean_upc")
	private String codice_ean_upc;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="fornitore")
	private String fornitore;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="peso")
	private String peso; 
	
	@Column(name="peso_unita")
	private String peso_unita;
	
	@Column(name="ingredienti")
	private String ingredienti; 
	
	@Column(name="url_thumb")
	private String url_thumb; 
	
	@Column(name="url_thumb_max")
	private String url_thumb_max;
	
	@Column(name="giacenza")
	private String giacenza;
	
	@Column(name="prenotati")
	private String prenotati; 
	
	@Column(name="riordino")
	private String riordino;
	
	@Column(name="scorta_minima")
	private String scorta_minima;
	
	@Column(name="unita_di_misura")
	private String unita_di_misura;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="sotto_categoria")
	private String sotto_categoria; 
	
	@Column(name="listino_fornitore")
	private String listino_fornitore;
	
	@Column(name="sconto_fornitore")
	private String sconto_fornitore;
	
	@Column(name="prezzo_acquisto")
	private String prezzo_acquisto;
	
	@Column(name="sconto_medio")
	private String sconto_medio;
	
	@Column(name="confezione")
	private String confezione;
	
	@Column(name="regione")
	private String regione;
	
	@Column(name="fabbricazione")
	private String fabbricazione;
	
	@Column(name="certificazioni")
	private String certificazioni;
	
	@Column(name="produttore")
	private String produttore;
	
	@Column(name="image")
	private byte[] image;

	public Integer getId_articolo() {
		return id_articolo;
	}

	public void setId_articolo(Integer id_articolo) {
		this.id_articolo = id_articolo;
	}

	public String getCodice_articolo() {
		return codice_articolo;
	}

	public void setCodice_articolo(String codice_articolo) {
		this.codice_articolo = codice_articolo;
	}

	public String getCodice_fornitore() {
		return codice_fornitore;
	}

	public void setCodice_fornitore(String codice_fornitore) {
		this.codice_fornitore = codice_fornitore;
	}

	public String getCodice_ean_upc() {
		return codice_ean_upc;
	}

	public void setCodice_ean_upc(String codice_ean_upc) {
		this.codice_ean_upc = codice_ean_upc;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFornitore() {
		return fornitore;
	}

	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getPeso_unita() {
		return peso_unita;
	}

	public void setPeso_unita(String peso_unita) {
		this.peso_unita = peso_unita;
	}

	public String getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public String getUrl_thumb() {
		return url_thumb;
	}

	public void setUrl_thumb(String url_thumb) {
		this.url_thumb = url_thumb;
	}

	public String getUrl_thumb_max() {
		return url_thumb_max;
	}

	public void setUrl_thumb_max(String url_thumb_max) {
		this.url_thumb_max = url_thumb_max;
	}

	public String getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(String giacenza) {
		this.giacenza = giacenza;
	}

	public String getPrenotati() {
		return prenotati;
	}

	public void setPrenotati(String prenotati) {
		this.prenotati = prenotati;
	}

	public String getRiordino() {
		return riordino;
	}

	public void setRiordino(String riordino) {
		this.riordino = riordino;
	}

	public String getScorta_minima() {
		return scorta_minima;
	}

	public void setScorta_minima(String scorta_minima) {
		this.scorta_minima = scorta_minima;
	}

	public String getUnita_di_misura() {
		return unita_di_misura;
	}

	public void setUnita_di_misura(String unita_di_misura) {
		this.unita_di_misura = unita_di_misura;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSotto_categoria() {
		return sotto_categoria;
	}

	public void setSotto_categoria(String sotto_categoria) {
		this.sotto_categoria = sotto_categoria;
	}

	public String getListino_fornitore() {
		return listino_fornitore;
	}

	public void setListino_fornitore(String listino_fornitore) {
		this.listino_fornitore = listino_fornitore;
	}

	public String getSconto_fornitore() {
		return sconto_fornitore;
	}

	public void setSconto_fornitore(String sconto_fornitore) {
		this.sconto_fornitore = sconto_fornitore;
	}

	public String getPrezzo_acquisto() {
		return prezzo_acquisto;
	}

	public void setPrezzo_acquisto(String prezzo_acquisto) {
		this.prezzo_acquisto = prezzo_acquisto;
	}

	public String getSconto_medio() {
		return sconto_medio;
	}

	public void setSconto_medio(String sconto_medio) {
		this.sconto_medio = sconto_medio;
	}

	public String getConfezione() {
		return confezione;
	}

	public void setConfezione(String confezione) {
		this.confezione = confezione;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getFabbricazione() {
		return fabbricazione;
	}

	public void setFabbricazione(String fabbricazione) {
		this.fabbricazione = fabbricazione;
	}

	public String getCertificazioni() {
		return certificazioni;
	}

	public void setCertificazioni(String certificazioni) {
		this.certificazioni = certificazioni;
	}

	public String getProduttore() {
		return produttore;
	}

	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
