/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocktail.ui;

import cocktail.cbr.Recipe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import jcolibri.cbrcore.Attribute;
import jcolibri.method.retrieve.NNretrieval.NNConfig;
import jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;
import jcolibri.method.retrieve.NNretrieval.similarity.local.EnumCyclicDistance;
import jcolibri.method.retrieve.NNretrieval.similarity.local.EnumDistance;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import jcolibri.method.retrieve.NNretrieval.similarity.local.Threshold;
import jcolibri.method.retrieve.NNretrieval.similarity.local.ontology.OntCosine;
import jcolibri.method.retrieve.NNretrieval.similarity.local.ontology.OntDeep;
import jcolibri.method.retrieve.NNretrieval.similarity.local.ontology.OntDeepBasic;
import jcolibri.method.retrieve.NNretrieval.similarity.local.ontology.OntDetail;
import jcolibri.util.FileIO;

/**
 * Travel Recommender example for the jCOLIBRI2 framework.
 *
 * @author Juan A. Recio-García. GAIA - Group for Artificial Intelligence
 * Applications http://gaia.fdi.ucm.es 25/07/2006
 *
 * @author visaac
 */
public class SimilarityConfigPanelv2 extends JPanel {

    private static final long serialVersionUID = 1L;
    SimilConfigPanel holidayType;
    SimilConfigPanel persons;
    SimilConfigPanel region;
    SimilConfigPanel transportation;
    SpinnerNumberModel k;
    
    public SimilarityConfigPanelv2() {
        configurePanel();
    }

    private void configurePanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
        }
        this.setLayout(new BorderLayout());

        /**
         * *******************************************************
         */
        Vector<String> stringfunctions = new Vector<String>();
        stringfunctions.add("Equal");

        Vector<String> numberfunctions = new Vector<String>();
        numberfunctions.add("Threshold");
        numberfunctions.add("Interval");
        numberfunctions.add("Equal");

        Vector<String> enumfunctions = new Vector<String>();
        enumfunctions.add("EnumCyclicDistance");
        enumfunctions.add("EnumDistance");
        enumfunctions.add("Equal");

        Vector<String> ontofunctions = new Vector<String>();
        ontofunctions.add("OntCosine");
        ontofunctions.add("OntDeep");
        ontofunctions.add("OntDeepBasic");
        ontofunctions.add("OntDetail");
        ontofunctions.add("Equal");


        //panel.setLayout(new GridLayout(10,2));
        this.setLayout(new SpringLayout());

        JLabel label;
        this.add(label = new JLabel("Attribute"));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        JPanel l = new JPanel();
        l.setLayout(new GridLayout(1, 3));
        l.add(label = new JLabel("Function"));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        l.add(label = new JLabel("Weight"));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        l.add(label = new JLabel("Function Param."));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        this.add(l);

        this.add(new JLabel("Ingredients to include"));
        this.add(holidayType = new SimilConfigPanel(stringfunctions));

        this.add(new JLabel("Number of persons"));
        this.add(persons = new SimilConfigPanel(numberfunctions));

        this.add(new JLabel("Ingredients to avoid"));
        this.add(region = new SimilConfigPanel(ontofunctions));

        this.add(new JLabel("Preparation method"));
        this.add(transportation = new SimilConfigPanel(stringfunctions));

        this.add(new JLabel());
        this.add(new JLabel());

        this.add(label = new JLabel("K"));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        this.add(new JSpinner(k = new SpinnerNumberModel(3, 1, 100, 1)));

//		Lay out the panel.
        Utils.makeCompactGrid(this,
                4, 2, //rows, cols
                6, 6, //initX, initY
                20, 10);       //xPad, yPad

        JPanel panelAux = new JPanel();
        panelAux.setLayout(new BorderLayout());
        panelAux.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelAux.add(this, BorderLayout.NORTH);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());

//        JButton ok = new JButton("Set Similarity Configuration >>");
//        ok.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                setSimilarity();
//            }
//        });
//        buttons.add(ok, BorderLayout.CENTER);
//        JButton exit = new JButton("Exit");
//        exit.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                  
//                    // TODO: visaac
//                    //TravelRecommender.getInstance().postCycle();
//                } catch (Exception ex) {
//                  //  org.apache.commons.logging.LogFactory.getLog(TravelRecommender.class).error(ex);
//                }
//                System.exit(-1);
//            }
//        });
//        buttons.add(exit, BorderLayout.WEST);
//
//        panelAux.add(buttons, BorderLayout.SOUTH);
//        this.add(panelAux, BorderLayout.CENTER);

    }

    void setSimilarity() {
        this.setVisible(false);
    }

    public NNConfig getSimilarityConfig() {
        NNConfig config = new NNConfig();
        Attribute attribute;
        SimilConfigPanel similConfig;
        LocalSimilarityFunction function;

        similConfig = holidayType;
        attribute = new Attribute("IngridentsWhitelist", Recipe.class);
        function = localSimilFactory(similConfig.getSimilFuntion(), similConfig.getParam());
        config.addMapping(attribute, function);
        config.setWeight(attribute, similConfig.getWeight());

        similConfig = this.persons;
        attribute = new Attribute("IngridentsBlacklist", Recipe.class);
        function = localSimilFactory(similConfig.getSimilFuntion(), similConfig.getParam());
        config.addMapping(attribute, function);
        config.setWeight(attribute, similConfig.getWeight());

        similConfig = this.region;
        attribute = new Attribute("NumberOfPersons", Recipe.class);
        function = localSimilFactory(similConfig.getSimilFuntion(), similConfig.getParam());
        config.addMapping(attribute, function);
        config.setWeight(attribute, similConfig.getWeight());

        similConfig = this.transportation;
        attribute = new Attribute("PreparationMethod", Recipe.class);
        function = localSimilFactory(similConfig.getSimilFuntion(), similConfig.getParam());
        config.addMapping(attribute, function);
        config.setWeight(attribute, similConfig.getWeight());

        return config;
    }

    public int getK() {
        return k.getNumber().intValue();
    }

    private LocalSimilarityFunction localSimilFactory(String name, int param) {
        if (name.equals("Equal")) {
            return new Equal();
        } else if (name.equals("Interval")) {
            return new Interval(param);
        } else if (name.equals("Threshold")) {
            return new Threshold(param);
        } else if (name.equals("EnumCyclicDistance")) {
            return new EnumCyclicDistance();
        } else if (name.equals("EnumDistance")) {
            return new EnumDistance();
        } else if (name.equals("OntCosine")) {
            return new OntCosine();
        } else if (name.equals("OntDeep")) {
            return new OntDeep();
        } else if (name.equals("OntDeepBasic")) {
            return new OntDeepBasic();
        } else if (name.equals("OntDetail")) {
            return new OntDetail();
        } else {
            //org.apache.commons.logging.LogFactory.getLog(this.getClass()).error("Simil Function not found");
            return null;
        }
    }

    private class SimilConfigPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        Vector<String> functions;
        JComboBox functionCombo;
        SpinnerNumberModel param;
        JSpinner paramSpinner;
        JSlider weight;

        public SimilConfigPanel(Vector<String> functions) {
            this.functions = new Vector<String>(functions);

            this.setLayout(new GridLayout(1, 3));
            functionCombo = new JComboBox(functions);

            this.add(functionCombo);

            weight = new JSlider(0, 10, 10);
            weight.setPaintLabels(false);

            this.add(weight);

            paramSpinner = new JSpinner(param = new SpinnerNumberModel());

            this.add(paramSpinner);

            functionCombo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateParam();
                }

            });
            updateParam();
        }

        void updateParam() {
            int sel = functionCombo.getSelectedIndex();
            if (sel == -1) {
                paramSpinner.setVisible(false);
                return;
            }
            String f = functions.elementAt(sel);
            paramSpinner.setVisible(f.endsWith("Interval") || f.endsWith("Threshold"));
        }

        public double getWeight() {
            return ((double) weight.getValue()) / 10;
        }

        public int getParam() {
            return param.getNumber().intValue();
        }

        public String getSimilFuntion() {
            return (String) functionCombo.getSelectedItem();
        }
    }

}
