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
	
	private JScrollPane ingredientsSelectorPane = null;;
	private JTree ingredientsTree = null;
	private JButton select = new JButton("Select");
	

	
	private String selectedIngredient = null;
	public IngredientSelectorDialog() {
		this.setTitle("Select Ingredient");
		this.setModal(true);
		this.setupDialog();
		this.setSize(200,400);
		this.setResizable(false);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2, 
				getWidth(),
				getHeight());
	}
	
	
	private  void setupDialog() {
		DefaultMutableTreeNode categories = new DefaultMutableTreeNode("Ingredients");
		for (int i = 0; i < ingredientTypes.length; i++) {
			DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(ingredientTypes[i]);
			for (String item : ingredients[i]) {
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
