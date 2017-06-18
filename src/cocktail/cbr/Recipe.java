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

    private String caseId;
    private String recipeTitle;
    private Instance alcohol;
    private Instance enhancer;
    private PrimaryJuice primaryJuice;
    private SupplementaryJuice supplementaryJuice;
    private Garnishing garnishing;
    private Taste taste;
    private Preparation preparation;
    private String steps;

    public Recipe() {
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public Instance getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Instance alcohol) {
        this.alcohol = alcohol;
    }

    public Instance getEnhancer() {
        return enhancer;
    }

    public void setEnhancer(Instance enhancer) {
        this.enhancer = enhancer;
    }

    public PrimaryJuice getPrimaryJuice() {
        return primaryJuice;
    }

    public void setPrimaryJuice(PrimaryJuice primaryJuice) {
        this.primaryJuice = primaryJuice;
    }

    public SupplementaryJuice getSupplementaryJuice() {
        return supplementaryJuice;
    }

    public void setSupplementaryJuice(SupplementaryJuice supplementaryJuice) {
        this.supplementaryJuice = supplementaryJuice;
    }

    public Garnishing getGarnishing() {
        return garnishing;
    }

    public void setGarnishing(Garnishing garnishing) {
        this.garnishing = garnishing;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    public Preparation getPreparation() {
        return preparation;
    }

    public void setPreparation(Preparation preparation) {
        this.preparation = preparation;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
    
    @Override
    public Attribute getIdAttribute() {
        return new Attribute("caseId", this.getClass());
    }
}
