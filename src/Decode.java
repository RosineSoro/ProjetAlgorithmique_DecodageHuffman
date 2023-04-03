
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class Decode {
	
	
	//constructeur
    public Decode() {}
    
        
   public void decodeFile(Node root, String code, String fileName) {
	   
	   /*Décode le fichier dont le nom est passé en paramètre
	    * Prend en paramètre le noeud racine et le code renvoyé par le fichier "_comp.bin"
	    * Retourne un message de confirmation si le fichier .txt a été bien crée
	    */
	   
    	String decodage = "";
        Node currentNode = root;
        
        /*Parcourt le code bit par bit pour obtenir le texte.
         * Si le bite est 0, on passe au fils gauche du noeud courant
         * S'il est égal à 1, on passe au fils droit du noeud courant
         * Si le noeud courant est une feuille, on s'arrête, on note son label puis on continue en repartant toujours du noeud racine
         */

        for (int i = 0; i < code.length(); i++) {
        	
            if (code.charAt(i) == '0') {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }

            if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
                decodage += currentNode.getLabel();
                currentNode = root;
            }
        }
 
        //Affiche le texte décodé
        System.out.println("Le texte decode est : "+decodage+"\n");
        
        try {
        //création du fichier.txt comportant le texte décodé
        FileWriter writer = new FileWriter(fileName+"/"+fileName+".txt",Charset.forName("UTF-8"));  
 	    writer.write(decodage);
 	    writer.close(); 	   
 	    System.out.println("fichier "+fileName+".txt cree avec succes."+"\n");
 	    
        }catch  (IOException e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
   }
   
  	  

    
}
