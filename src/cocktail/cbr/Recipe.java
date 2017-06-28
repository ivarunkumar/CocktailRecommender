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
    private Alcohol alcohol;
    private Enhancer enhancer;
    private PrimaryJuice primaryJuice;
    private SupplementaryJuice supplementaryJuice;
    private Garnishing garnishing;
    private Taste taste;
    private Preparation preparation;
    private String steps;

    public Recipe() {
    }
    
    @Override
    public Attribute getIdAttribute() {
        return new Attribute("caseId", this.getClass());
    }
}
