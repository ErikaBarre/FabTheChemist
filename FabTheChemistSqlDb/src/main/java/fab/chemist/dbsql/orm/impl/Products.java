package fab.chemist.dbsql.orm.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import fab.chemist.dbsql.constant.DBConstant;
import fab.chemist.dbsql.orm.interf.IProducts;
import fab.chemist.dbsql.orm.interf.IReviewPeriod;

@Entity(name = IProducts.ENTITY_NAME)
@Table(name=IProducts.TABLE_NAME)
public class Products implements Serializable{

	@Id
	@Column(name="id_produit", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productsGenerator")
	@SequenceGenerator(name = "productsGenerator", sequenceName = IProducts.SEQUENCE_NAME, allocationSize = 1)
	Long id;
		
	@Column(name = "no_produit") 
	Long noProduit;
	
	@Column(name = "nom") 
	String nameProduit;
	
	@Column(name = "prix") 
	Long prix;
	
	@Column(name = "prix_promotion") 
	Long prixPromotion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNoProduit() {
		return noProduit;
	}

	public void setNoProduit(Long noProduit) {
		this.noProduit = noProduit;
	}

	public String getNameProduit() {
		return nameProduit;
	}

	public void setNameProduit(String nameProduit) {
		this.nameProduit = nameProduit;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public Long getPrixPromotion() {
		return prixPromotion;
	}

	public void setPrixPromotion(Long prixPromotion) {
		this.prixPromotion = prixPromotion;
	}

	
}


/*
no_produit integer CONSTRAINT doit_etre_different UNIQUE,
nom text NOT NULL,
prix numeric NOT NULL CONSTRAINT prix_positif CHECK (prix > 0),
prix_promotion numeric CHECK (prix_promotion > 0), CONSTRAINT promo_valide CHECK (prix > prix_promotion)
*/