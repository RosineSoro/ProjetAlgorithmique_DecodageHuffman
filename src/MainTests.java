
import java.io.IOException;
import java.util.ArrayList;

public class MainTests {

	public static void main(String[] args) throws IOException {
		
	//Choix du répertoire pour le  fichier à décompresser
    String data1 = "bonjour";
    String data2 ="textesimple";
    
    //Exemple avec le fichier bonjour_comp.bin
    Alphabet d1 = new Alphabet (data1);
    ArrayList<Node> liste = d1.readFile();
    
    //affichage de l'aphabet utilisé 
    System.out.println("L'alphabet de d1 : "+liste+"\n");
    
    //Affichage du noeud racine
    Tree tree = new Tree(liste);
    Node root = tree.add_and_remove_node();
    System.out.println("root: "+ root+"\n");
    
    //affichage de l'arbre
    System.out.println("tree : "+ tree.printTree(root)+ "\n");
    
    //Tests pour le décodage
    BinaryFileReader file_name = new BinaryFileReader(data1);
    String code = file_name.readBinaryFile();
    Decode dec = new Decode();
    dec.decodeFile(root, code, data1);
    
    //Tests étapes 4 et 5
    Size s = new Size(data1);  
    s.getMoy();
    s.getNb();
    
    
	}

}
