package cocktail.cbr;

import jcolibri.cbraplications.StandardCBRApplication;
import jcolibri.cbrcore.CBRCase;
import jcolibri.cbrcore.CBRCaseBase;
import jcolibri.cbrcore.CBRQuery;
import jcolibri.cbrcore.Connector;
import jcolibri.exception.ExecutionException;
import jcolibri.exception.InitializingException;
import jcolibri.method.retrieve.NNretrieval.NNConfig;

import javax.annotation.Generated;
import cocktail.cbr.CaseDescription;
import java.util.ArrayList;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.cbrcore.Attribute;
import jcolibri.method.retrieve.RetrievalResult;
import jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import jcolibri.method.retrieve.selection.SelectCases;
import java.util.Collection;
import java.util.List;
import jcolibri.connector.DataBaseConnector;
import jcolibri.method.retrieve.NNretrieval.similarity.local.EqualsStringIgnoreCase;
import jcolibri.method.reuse.DirectAttributeCopyMethod;

public class CBRApplication implements StandardCBRApplication {

    @Generated(value = {"ColibriStudio"})
    Connector connector;

    @Generated(value = {"ColibriStudio"})
    CBRCaseBase casebase;
    NNConfig similarityConfig;
    
    List<RetrievalResult> retrievedCases = new ArrayList<RetrievalResult>();
    private List<String> adaptationConfig;
    //******************************************************************/
    // Configuration
    //******************************************************************/
    @Override
    public void configure() throws ExecutionException {
        try {
            configureConnector();
            configureCaseBase();
        } catch (Exception e) {
            throw new ExecutionException(e);
        }
    }

    /**
     * Configures the connector
     */
    @Generated(value = {"CS-PTConector"})
    private void configureConnector() throws InitializingException {
        connector = new jcolibri.connector.PlainTextConnector();
        connector.initFromXMLfile(jcolibri.util.FileIO
                .findFile("config/plainTextConnectorConfig.xml"));
}

    /**
     * Configures the case base
     */
    @Generated(value = {"CS-CaseManager"})
    private void configureCaseBase() throws InitializingException {
        casebase = new jcolibri.casebase.LinealCaseBase();
    }

    //******************************************************************/
    // Similarity
    //******************************************************************/
    /**
     * Configures the similarity
     */
//    @Generated(value = {"CS-Similarity"})
//    private NNConfig getSimilarityConfig() {
//        NNConfig simConfig = new NNConfig();
//        simConfig.setDescriptionSimFunction(new jcolibri.method.retrieve.NNretrieval.similarity.global.Average());
//
//        Attribute attribute0 = new Attribute("Alcohol", CaseDescription.class);
//        simConfig.addMapping(attribute0, new EqualsStringIgnoreCase());
//        simConfig.setWeight(attribute0, 1.00);
//
//        Attribute attribute1 = new Attribute("Enhancer", CaseDescription.class);
//        simConfig.addMapping(attribute1, new EqualsStringIgnoreCase());
//        simConfig.setWeight(attribute1, 1.00);
//
//        Attribute attribute2 = new Attribute("PrimaryJuice", CaseDescription.class);
//        simConfig.addMapping(attribute2, new EqualsStringIgnoreCase());
//        simConfig.setWeight(attribute2, 1.00);
//
//        Attribute attribute3 = new Attribute("SupplementaryJuice", CaseDescription.class);
//        simConfig.addMapping(attribute3, new EqualsStringIgnoreCase());
//        simConfig.setWeight(attribute3, 1.00);
//        
//        Attribute attribute4 = new Attribute("Garnishing", CaseDescription.class);
//        simConfig.addMapping(attribute4, new EqualsStringIgnoreCase());
//        simConfig.setWeight(attribute4, 1.00);
//        
//        Attribute attribute5 = new Attribute("Taste", CaseDescription.class);
//        simConfig.addMapping(attribute5, new EqualsStringIgnoreCase());
//        simConfig.setWeight(attribute5, 1.00);
//        
//        Attribute attribute6 = new Attribute("Preparation", CaseDescription.class);
//        simConfig.addMapping(attribute6, new EqualsStringIgnoreCase());
//        simConfig.setWeight(attribute6, 1.00);
//        
//        return simConfig;
//    }
  
    //******************************************************************/
    // Methods
    //******************************************************************/
    @Generated(value = {"ColibriStudio"})
    @Override
    public CBRCaseBase preCycle() throws ExecutionException {
        casebase.init(connector);
        return casebase;
    }

    @Generated(value = {"ColibriStudio"})
    @Override
    public void cycle(CBRQuery query) throws ExecutionException {
        retrievedCases.clear();
        // Execute NN
        Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(casebase.getCases(), query, similarityConfig);

        // Select k cases
        //eval = SelectCases.selectTopKRR(eval, 5);
        Collection<CBRCase> selectedCases = SelectCases.selectTopK(eval, 3);
        
        // Adapt depending on user selection
        if(adaptationConfig.contains("ALCOHOL"))
        {
            DirectAttributeCopyMethod.copyAttribute(new Attribute("AlcoholType",CaseDescription.class), 
                                                    new Attribute("AlcoholType",CaseDescription.class), 
                                                    query, selectedCases);
        }

        if(adaptationConfig.contains("ENHANCER"))
        {
            DirectAttributeCopyMethod.copyAttribute(new Attribute("EnhancerType", CaseDescription.class), 
                                                    new Attribute("EnhancerType", CaseDescription.class), 
                                                    query, selectedCases);
        }
        
        if(adaptationConfig.contains("PRIMARY_JUICE"))
        {
            DirectAttributeCopyMethod.copyAttribute(new Attribute("PrimaryJuice", CaseDescription.class), 
                                                    new Attribute("PrimaryJuice", CaseDescription.class), 
                                                    query, selectedCases);
        }
        
        if(adaptationConfig.contains("SUPPLEMENTARY_JUICE"))
        {
            DirectAttributeCopyMethod.copyAttribute(new Attribute("SupplementaryJuice", CaseDescription.class), 
                                                    new Attribute("SupplementaryJuice", CaseDescription.class), 
                                                    query, selectedCases);
        }
        
        if(adaptationConfig.contains("GARNISHING"))
        {
            DirectAttributeCopyMethod.copyAttribute(new Attribute("Garnishing", CaseDescription.class), 
                                                    new Attribute("Garnishing", CaseDescription.class), 
                                                    query, selectedCases);
        }
        
        if(adaptationConfig.contains("TASTE"))
        {
            DirectAttributeCopyMethod.copyAttribute(new Attribute("Taste", CaseDescription.class), 
                                                    new Attribute("Taste", CaseDescription.class), 
                                                    query, selectedCases);
        }
        
        if(adaptationConfig.contains("PREPARATION"))
        {
            DirectAttributeCopyMethod.copyAttribute(new Attribute("Preparation", CaseDescription.class), 
                                                    new Attribute("Preparation", CaseDescription.class), 
                                                    query, selectedCases);
        }
        
        System.out.println("Retrieved cases:");
        for(RetrievalResult rr: eval) {
            if(selectedCases.contains(rr.get_case())) {
                System.out.println(rr.get_case());
		retrievedCases.add(rr);
            }
        }
	
    }

    @Generated(value = {"ColibriStudio"})
    @Override
    public void postCycle() throws ExecutionException {
        connector.close();
    }

    public void setSimilarityConfig(NNConfig similarityConfig) {
        this.similarityConfig = similarityConfig;
    }
    

    public List<CocktailCase> getSelectedCases() {
    
        List<CocktailCase> outList = new ArrayList<>();
        for (RetrievalResult rr : retrievedCases) {
            CocktailCase ccase = new CocktailCase();
            ccase.similarity = rr.getEval();
            CBRCase _case = rr.get_case();
            //this.caseId.setText(_case.getID().toString()+" -> "+sim+" ("+(currentCase+1)+"/"+cases.size()+")");
            ccase.description = (CaseDescription) _case.getDescription();
            ccase.recipe = (Recipe)_case.getSolution();
            outList.add(ccase);
        }
        
        return outList;
    }

    public void setAdaptationConfig(List<String> adaptationPreferences) {
        this.adaptationConfig = adaptationPreferences;
    }
    
    public void learn (List<CBRCase> cases) {
        for (CBRCase ccase : cases) {
            CaseDescription desc = (CaseDescription)ccase.getDescription();
            desc.setCaseID(getNextId());
        }
        casebase.learnCases(cases);
    }
    
    private int getNextId() {
        Integer i = 0;

        for (CBRCase ccase : casebase.getCases()) {
            CaseDescription desc = (CaseDescription)ccase.getDescription();
            if (desc.getCaseID().intValue() > i.intValue()) {
                i = desc.getCaseID();
            }
        }
            
        return i + 1;
    }

    
}
