package cocktail.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class IngredientSelectorDialog extends JDialog implements ActionListener, TreeSelectionListener{

    private static final long serialVersionUID = 1L;
    private static String[] ingredientTypes = {"Alcohol", "Fruit Juice", "Seasoning", "Taste", "Fruit"};
    private static String [][] ingredients = { {"Beer", "Rum", "Tequila", "Wine", "Wiskey", "Gin"},
                                                             {"Apple", "Organge", "Mango", "Peach", "Lemon"},
                                                             {"Ice cubes", "Pistachio"},
                                                             {"Smooth", "Rough"},
                                                             {"Apple", "Organge", "Mango", "Peach", "Lemon", "Cherry"}};


    private static String[] alcoholTypes = {"Mild", "Neutral", "Strong", "Very Strong"};
    private static String [][] alcohols = { {"Beer", "Rum", "Tequila", "Wine", "Wiskey", "Gin"},
                                                             {"Apple", "Organge", "Mango", "Peach", "Lemon"},
                                                             {"Ice cubes", "Pistachio"},
                                                             {"Smooth", "Rough"}};

    private static String[] enhancerTypes = {"Syrup", "Alcohol", "Fruit"};
    private static String [][] enhancers = { {"Syrup 1", "Syrup 2", "Syrup 3"},
                                            {"Cognac", "Rum"},
                                            {"Smooth", "Rough"}};


    private static String[] primaryJuiceTypes = {"Juice"};
    private static String [][] primaryJuices = { {"Apple Juice", "Orange Juice", "Lemonade"}};

    private static String[] secondayJuiceTypes = {"Juice"};
    private static String [][] secondayJuices = { {"Apple Juice", "Orange Juice", "Lemonade"}};
    
    private JScrollPane ingredientsSelectorPane = null;;
    private JTree ingredientsTree = null;
    private JButton select = new JButton("Select");



    private String selectedIngredient = null;
    public IngredientSelectorDialog(Filter type) {
        this.setTitle("Select Ingredient");
        this.setModal(true);

        switch(type) {
            case Alcohol: this.setupDialog(alcoholTypes, alcohols); break;
            case Enhancer: this.setupDialog(enhancerTypes, enhancers); break;
            case PrimaryJuice: this.setupDialog(primaryJuiceTypes, primaryJuices); break;
            case SupplementaryJuice: this.setupDialog(secondayJuiceTypes, secondayJuices); break;
            default: this.setupDialog(ingredientTypes, ingredients);
        } 
        this.setSize(200,400);
        this.setResizable(false);
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - this.getWidth()) / 2,
                        (screenSize.height - this.getHeight()) / 2, 
                        getWidth(),
                        getHeight());
    }


    private  void setupDialog(String[] topics, String[][] subTopics) {
            DefaultMutableTreeNode categories = new DefaultMutableTreeNode("Ingredients");
            for (int i = 0; i < topics.length; i++) {
                    DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(topics[i]);
                    for (String item : subTopics[i]) {
                            DefaultMutableTreeNode itemNode = new DefaultMutableTreeNode(item);
                            categoryNode.add(itemNode);
                    }
                    categories.add(categoryNode);
            }
            ingredientsTree = new JTree(categories);
            ingredientsTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

            ingredientsSelectorPane = new JScrollPane(ingredientsTree);

            this.getContentPane().setLayout(new BorderLayout(10,10));
            this.getContentPane().add(ingredientsSelectorPane, BorderLayout.CENTER);
            this.getContentPane().add(select,  BorderLayout.SOUTH);

            select.addActionListener(this);
            ingredientsTree.addTreeSelectionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            this.dispose();

    }


    @Override
    public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)ingredientsTree.getLastSelectedPathComponent();

        //Nothing is selected.
            if (selectedNode == null) 
                return;

        Object nodeInfo = selectedNode.getUserObject();
        selectedIngredient = (String) nodeInfo;
    }


    public String getSelectedIngredient() {
            return selectedIngredient;
    }

}
