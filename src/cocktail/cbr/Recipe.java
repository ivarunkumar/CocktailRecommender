/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocktail.cbr;

import jcolibri.cbrcore.Attribute;
import jcolibri.datatypes.Instance;

/**
 *
 * @author visaac
 */
public class Recipe  implements jcolibri.cbrcore.CaseComponent {


	/* Generated Class. Please Do Not Modify... */ 


	private java.lang.String RecipeName;


	public java.lang.String getRecipeName()
		{
			return RecipeName;
		}
	public void setRecipeName(java.lang.String RecipeName8)
		{
			this.RecipeName = RecipeName8;
		}

	private cocktail.cbr.AlcoholStrength AlcoholStrength;


	public cocktail.cbr.AlcoholStrength getAlcoholStrength()
		{
			return AlcoholStrength;
		}
	public void setAlcoholStrength(cocktail.cbr.AlcoholStrength AlcoholStrength9)
		{
			this.AlcoholStrength = AlcoholStrength9;
		}

	private cocktail.cbr.Alcohol Alcohol;


	public cocktail.cbr.Alcohol getAlcohol()
		{
			return Alcohol;
		}
	public void setAlcohol(cocktail.cbr.Alcohol Alcohol10)
		{
			this.Alcohol = Alcohol10;
		}

	private cocktail.cbr.Enhancer Enhancer;


	public cocktail.cbr.Enhancer getEnhancer()
		{
			return Enhancer;
		}
	public void setEnhancer(cocktail.cbr.Enhancer Enhancer11)
		{
			this.Enhancer = Enhancer11;
		}


	@Override
	public Attribute getIdAttribute()
		{
			return new Attribute("RecipeName",this.getClass());
		} 

	public String toString()		{
			return "["+ RecipeName + " , " + Enhancer + " , " + AlcoholStrength + " , " + Alcohol +"]";
		}

}
