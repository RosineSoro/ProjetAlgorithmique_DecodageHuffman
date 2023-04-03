import java.util.ArrayList;
import java.util.Iterator;

public class Tree {
	
	private Node root;
	private ArrayList<Node> listeNodes;
	
	//constructeur
	public Tree(ArrayList<Node> listeNodes)
	{
		this.listeNodes = listeNodes;
		this.root = this.add_and_remove_node();
	}

	//getters and setters
	public Node getRoot(){return root;}
	public void setRoot(Node root) {this.root = root;}
	
	
	
	public ArrayList<Node> getListeNodes() {return listeNodes;}
	public void setListeNodes(ArrayList<Node> listeNodes) {this.listeNodes = listeNodes;}

		
    private ArrayList<Node> triListNodes(ArrayList<Node> liste) { 
    //méthode qui trie une liste de noeuds en fonction des fréquences croissantes puis en fonction de l'ASCII si même fréquence
    	
    for (int i = 0; i < liste.size(); i++) { 
        for (int j = 0; j < liste.size() - i - 1; j++) {
            if (liste.get(j).getOccurrence() > liste.get(j + 1).getOccurrence() 
                    || (liste.get(j).getLabel().equals(liste.get(j + 1).getLabel()) 
                        && liste.get(j).getOccurrence() > liste.get(j + 1).getOccurrence())) { 
                Node temp = liste.get(j); 
                liste.set(j,liste.get(j + 1)); 
                liste.set(j + 1, temp); 
            }
        }
    } 
    return liste; 
}
   
	
	   
	  private ArrayList<Node> insert_and_remove(ArrayList<Node> liste, Node a, Node b, Node c) {
		  //méthode qui ajoute le noeud c à une liste triée de noeuds tout en gardant l'ordre de la liste puis retire les noeuds a et b
		  
		    ArrayList<Node> newList = new ArrayList<Node>(liste); // créer une nouvelle liste pour éviter de modifier la liste d'origine
		    newList.add(c);
		    Iterator<Node> iterator = newList.iterator();
		    
		    while (iterator.hasNext()) {
		        Node node = iterator.next();
		       
		        if (node.getOccurrence() == a.getOccurrence() && node.getLabel().equals(a.getLabel())) {
		            iterator.remove();
		            
		        } else if (node.getOccurrence() == b.getOccurrence() && node.getLabel().equals(b.getLabel())) {
		            iterator.remove();
		        }
		    }
		    return triListNodes(newList);
		}

		
			
		public Node add_and_remove_node(){
			/*méthode qui reduit la liste de noeuds passée au constructeur grace a la fonction insert_and_remove jusqu a obtenir une liste ayant un seul élément: le noeud racine
			 *retourne le noeud racine
			 */

		
			String new_label;
			int  new_occur;
		    Node new_leftChild;
		    Node  new_rightChild;
		    Node new_node;
		    
		    //tant que la longueur de la liste est > 1 : creer un nouveau noeud avec avec les 2 premiers elements de la liste
		    
	        while (listeNodes.size()>1){
	        	
	        	
	        	//creation de l etiquette du nouveau noeud
	        	new_label =  listeNodes.get(0).getLabel() + listeNodes.get(1).getLabel();
	            new_occur = listeNodes.get(0).getOccurrence() + listeNodes.get(1).getOccurrence();

	            //affecte le 1er element de la liste comme etant le fils gauche et le 2nd comme etant le fils droit
	            new_leftChild = listeNodes.get(0);
	            new_rightChild = listeNodes.get(1);

	            //affecte la branche 0 au fils gauche et la branche 1 au fils droit
	            new_leftChild.setBranch("0");
	            new_rightChild.setBranch("1");
	            
	            //cree un nouveau noeud ,supprime les 2 premiers noeuds de la liste noeud puis y rajoute le nouveau noeud 
	            new_node = new Node(new_label,new_occur,new_leftChild,new_rightChild);
	            listeNodes= insert_and_remove (listeNodes,listeNodes.get(0), listeNodes.get(1),new_node);

	            add_and_remove_node();	
	        }	
	        return listeNodes.get(0);

		}

		
		public ArrayList<Object> printTree(Node root) {
			//méthode qui gère l'affichage de l'arbre
			
			ArrayList<Object> tree = new ArrayList<Object>();
		    if (root != null) {
		        tree.add(root.getLabel());
		        tree.add(printTree(root.getLeftChild()));
		        tree.add(printTree(root.getRightChild()));
		    }
		    return tree;
		}
	
		@Override
		public String toString() {
			return "(root=" + root + ")";
		}
		
		
}
