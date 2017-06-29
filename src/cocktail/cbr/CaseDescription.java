package cocktail.cbr;

import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CaseComponent;
//import colibristudio.annotations.JCOLIBRIAttributeType;


public class CaseDescription implements CaseComponent { 

	/* Generated Class. Please Do Not Modify... */ 


	private java.lang.Integer CaseID;


	public java.lang.Integer getCaseID()
		{
			return CaseID;
		}
	public void setCaseID(java.lang.Integer CaseID0)
		{
			this.CaseID = CaseID0;
		}

	private cocktail.cbr.AlcoholType AlcoholType;


	public cocktail.cbr.AlcoholType getAlcoholType()
		{
			return AlcoholType;
		}
	public void setAlcoholType(cocktail.cbr.AlcoholType AlcoholType1)
		{
			this.AlcoholType = AlcoholType1;
		}

	private cocktail.cbr.EnhancerType EnhancerType;


	public cocktail.cbr.EnhancerType getEnhancerType()
		{
			return EnhancerType;
		}
	public void setEnhancerType(cocktail.cbr.EnhancerType EnhancerType2)
		{
			this.EnhancerType = EnhancerType2;
		}

	private cocktail.cbr.PrimaryJuice PrimaryJuice;


	public cocktail.cbr.PrimaryJuice getPrimaryJuice()
		{
			return PrimaryJuice;
		}
	public void setPrimaryJuice(cocktail.cbr.PrimaryJuice PrimaryJuice3)
		{
			this.PrimaryJuice = PrimaryJuice3;
		}

	private cocktail.cbr.SupplementaryJuice SupplementaryJuice;


	public cocktail.cbr.SupplementaryJuice getSupplementaryJuice()
		{
			return SupplementaryJuice;
		}
	public void setSupplementaryJuice(cocktail.cbr.SupplementaryJuice SupplementaryJuice4)
		{
			this.SupplementaryJuice = SupplementaryJuice4;
		}

	private cocktail.cbr.Garnishing Garnishing;


	public cocktail.cbr.Garnishing getGarnishing()
		{
			return Garnishing;
		}
	public void setGarnishing(cocktail.cbr.Garnishing Garnishing5)
		{
			this.Garnishing = Garnishing5;
		}

	private cocktail.cbr.Taste Taste;


	public cocktail.cbr.Taste getTaste()
		{
			return Taste;
		}
	public void setTaste(cocktail.cbr.Taste Taste6)
		{
			this.Taste = Taste6;
		}

	private cocktail.cbr.Preparation Preparation;


	public cocktail.cbr.Preparation getPreparation()
		{
			return Preparation;
		}
	public void setPreparation(cocktail.cbr.Preparation Preparation7)
		{
			this.Preparation = Preparation7;
		}


	@Override
	public Attribute getIdAttribute()
		{
			return new Attribute("CaseID",this.getClass());
		} 

	public String toString()		{
			return "[EnhancerType:"+ EnhancerType + " , PrimaryJuice:" + PrimaryJuice + " , Preparation:" + Preparation + " , Garnishing:" + Garnishing + " , AlcoholType:" + AlcoholType + " , Taste:" + Taste + " , CaseID:" + CaseID + " , SupplementaryJuice:" + SupplementaryJuice +"]";
		}

}
