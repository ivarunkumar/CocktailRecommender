package cocktail.cbr;

import jcolibri.cbrcore.Attribute;
import jcolibri.cbrcore.CaseComponent;
//import colibristudio.annotations.JCOLIBRIAttributeType;


public class CaseDescription implements CaseComponent { 


	/* Generated Class. Please Do Not Modify... */ 


	private java.lang.Integer CaseId;


	public java.lang.Integer getCaseId()
		{
			return CaseId;
		}
	public void setCaseId(java.lang.Integer CaseId0)
		{
			this.CaseId = CaseId0;
		}

	private java.lang.String RecipeName;


	public java.lang.String getRecipeName()
		{
			return RecipeName;
		}
	public void setRecipeName(java.lang.String RecipeName1)
		{
			this.RecipeName = RecipeName1;
		}

	private java.lang.String Alcohol;


	public java.lang.String getAlcohol()
		{
			return Alcohol;
		}
	public void setAlcohol(java.lang.String Alcohol2)
		{
			this.Alcohol = Alcohol2;
		}

	private java.lang.String Enhancer;


	public java.lang.String getEnhancer()
		{
			return Enhancer;
		}
	public void setEnhancer(java.lang.String Enhancer3)
		{
			this.Enhancer = Enhancer3;
		}

	private java.lang.String PrimaryJuice;


	public java.lang.String getPrimaryJuice()
		{
			return PrimaryJuice;
		}
	public void setPrimaryJuice(java.lang.String PrimaryJuice4)
		{
			this.PrimaryJuice = PrimaryJuice4;
		}

	private java.lang.String SupplementaryJuice;


	public java.lang.String getSupplementaryJuice()
		{
			return SupplementaryJuice;
		}
	public void setSupplementaryJuice(java.lang.String SupplementaryJuice5)
		{
			this.SupplementaryJuice = SupplementaryJuice5;
		}

	private java.lang.String Garnishing;


	public java.lang.String getGarnishing()
		{
			return Garnishing;
		}
	public void setGarnishing(java.lang.String Garnishing6)
		{
			this.Garnishing = Garnishing6;
		}

	private java.lang.String Taste;


	public java.lang.String getTaste()
		{
			return Taste;
		}
	public void setTaste(java.lang.String Taste7)
		{
			this.Taste = Taste7;
		}

	private java.lang.String Preparation;


	public java.lang.String getPreparation()
		{
			return Preparation;
		}
	public void setPreparation(java.lang.String Preparation8)
		{
			this.Preparation = Preparation8;
		}

	private java.lang.String Steps;


	public java.lang.String getSteps()
		{
			return Steps;
		}
	public void setSteps(java.lang.String Steps9)
		{
			this.Steps = Steps9;
		}


	@Override
	public Attribute getIdAttribute()
		{
			return new Attribute("CaseId",this.getClass());
		} 

	public String toString()		{
			return "["+ Steps + " , " + RecipeName + " , " + Enhancer + " , " + PrimaryJuice + " , " + Preparation + " , " + Garnishing + " , " + Alcohol + " , " + CaseId + " , " + Taste + " , " + SupplementaryJuice +"]";
		}

}
