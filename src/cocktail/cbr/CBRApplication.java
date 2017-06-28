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
import jcolibri.method.retrieve.NNretrieval.similarity.local.EqualsStringIgnoreCase;

public class CBRApplication implements StandardCBRApplication {

    @Generated(value = {"ColibriStudio"})
    Connector connector;

    @Generated(value = {"ColibriStudio"})
    CBRCaseBase casebase;
    NNConfig similarityConfig;
    
    List<RetrievalResult> retrievedCases = new ArrayList<RetrievalResult>();
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
        // Execute NN
        Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(casebase.getCases(), query, similarityConfig);

        // Select k cases
        //eval = SelectCases.selectTopKRR(eval, 5);
        Collection<CBRCase> selectedCases = SelectCases.selectTopK(eval, 3);
        
        System.out.println("Retrieved cases:");
        for(RetrievalResult rr: eval)
            if(selectedCases.contains(rr.get_case()))
		retrievedCases.add(rr);
	
    }

    @Generated(value = {"ColibriStudio"})
    @Override
    public void postCycle() throws ExecutionException {
        connector.close();
    }

    public void setSimilarityConfig(NNConfig similarityConfig) {
        this.similarityConfig = similarityConfig;
    }
    

    List<CaseDescription> getSelectedCases() {
    
        List<CaseDescription> outList = new ArrayList<>();
        for (RetrievalResult rr : retrievedCases) {

        double sim = rr.getEval();

        CBRCase _case = rr.get_case();
        //this.caseId.setText(_case.getID().toString()+" -> "+sim+" ("+(currentCase+1)+"/"+cases.size()+")");

        CaseDescription desc = (CaseDescription) _case.getDescription();
        outList.add(desc);
//        TravelSolution sol = (TravelSolution) _case.getSolution();
//        this.price.setText(sol.getPrice().toString());
//        this.hotel.setText(sol.getHotel());
        }
        
        return outList;
    }
}
