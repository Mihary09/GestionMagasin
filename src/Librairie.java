import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Librairie extends JFrame {
	
	// mon codeee
	
	String [] produits = {"Stylo", "Crayon", "Cahier", "Gomme", "Colle"};
	double prixUnitaire, total = 0, montant;
	int nombreProduits, produitsListeAchat = 0;
	String produitSelectionné;
	
	// D�claration de DefaultListModel mon code
    DefaultListModel modeleProduit, modeleMontant;
	
    private static final long serialVersionUID = 1L;
    private JTextField txtPrix;
    private JTextField txtNombre;
    private JLabel lblMontants;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Librairie frame = new Librairie();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Librairie() {
    	
    	// Initialisation de DefaultListModel
        modeleProduit = new DefaultListModel();
        modeleMontant = new DefaultListModel();
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 990, 547);
        getContentPane().setLayout(null); // Utiliser un layout null
        
        JLabel lblNewLabel = new JLabel("Gestion de Librairies");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
        lblNewLabel.setBounds(245, 10, 500, 50); // D�finir la position et taille
        getContentPane().add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(10, 70, 221, 300); // D�finir la position et taille
        panel.setLayout(null); // Layout null pour les composants internes
        getContentPane().add(panel);
        

        // ENTRER LE PRODUIT
        JLabel lblProduits =  new JLabel("Choisir le produit");
        lblProduits.setHorizontalAlignment(SwingConstants.LEFT);
        lblProduits.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblProduits.setBounds(10, 18, 200, 30); // D�finir la position et taille
        panel.add(lblProduits);
        
         
        // CHOIX DES PRODUITS
        JComboBox cmbProduit = new JComboBox();
        cmbProduit.setBounds(10, 46, 200, 30); // D�finir la position et taille
        panel.add(cmbProduit);
        
        	
        // ENTRER LE PRIX

        JLabel lblPrix = new JLabel("Entrer le prix unitaire");
        lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrix.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblPrix.setBounds(0, 100, 190, 30); // D�finir la position et taille
        panel.add(lblPrix);

        // INTRODUCTION DES PRIX
        txtPrix = new JTextField();
        txtPrix.setBounds(10, 130, 200, 30); // D�finir la position et taille
        panel.add(txtPrix);
        txtPrix.setColumns(10);
        
        
        // ENTRER LE NOMBRE
        
        JLabel lblNombre = new JLabel("Entrer le nombre");
        lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNombre.setBounds(10, 182, 200, 30); // D�finir la position et taille
        panel.add(lblNombre);
        
        // INTRO DES NOMBRES
        txtNombre = new JTextField();
        txtNombre.setBounds(10, 212, 200, 30); // D�finir la position et taille
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(255, 71, 715, 300); // D�finir la position et taille
        panel_1.setLayout(null); // Layout null pour les composants internes
        getContentPane().add(panel_1);

        JLabel lblAchat = new JLabel("Liste d'achats");
        lblAchat.setHorizontalAlignment(SwingConstants.CENTER);
        lblAchat.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblAchat.setBounds(28, 11, 250, 30); // D�finir la position et taille
        panel_1.add(lblAchat);

        lblMontants = new JLabel("Montants");
        lblMontants.setHorizontalAlignment(SwingConstants.CENTER);
        lblMontants.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblMontants.setBounds(443, 11, 118, 30); // D�finir la position et taille
        panel_1.add(lblMontants);
        
        
        // LISTES DES ACHATS
        JList lstAchat = new JList();
        lstAchat.setBounds(10, 45, 317, 195);
        panel_1.add(lstAchat);
        lstAchat.setModel(modeleProduit); // je sais pas
        
        // LISTES DES MONTANTS
        JList lstMontant = new JList();
        lstMontant.setBounds(371, 45, 334, 195);
        panel_1.add(lstMontant);
        //suite mon code 5
        lstMontant.setModel(modeleMontant);
        
        // TOTAL LISTES DES ACHATS
        JLabel lblNombreProduits = new JLabel("n");
        lblNombreProduits.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreProduits.setBounds(10, 251, 317, 38);
        panel_1.add(lblNombreProduits);
        
        // mon code
        lblNombreProduits.setText(String.valueOf(produitsListeAchat));
        // mon code1
        for (int i = 0; i <produits.length; i++) {
        	cmbProduit.addItem(produits[i]);
        }
     
        // TOTAL LISTE DES MONTANTS
        JLabel lblSommeTotal = new JLabel("n");
        lblSommeTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblSommeTotal.setBounds(371, 251, 334, 38);
        panel_1.add(lblSommeTotal);
        // mon code2
        lblSommeTotal.setText(String.valueOf(total));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setBounds(10, 380, 960, 100); // D�finir la position et taille
        getContentPane().add(panel_2);
        panel_2.setLayout(null); // Layout null pour les composants internes
        
        
        // BOUTTON AJOUTER
        
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// la condition verifie ....
        		if (!txtPrix.getText() .isEmpty() && !txtNombre.getText() .isEmpty() )
        		{
        		produitSelectionné = cmbProduit.getSelectedItem().toString();
        		prixUnitaire = Double.parseDouble(txtPrix.getText());
        		nombreProduits = Integer.parseInt(txtNombre.getText());  // je sais pas3
        		
        		
        		modeleProduit.addElement(produitSelectionné);  // je sais pas2
        		// mon code5
        		montant = prixUnitaire*nombreProduits;
        		modeleMontant.addElement(montant);
        		produitsListeAchat++;
        		lblNombreProduits.setText(String.valueOf(produitsListeAchat));
        		total = Double.parseDouble(lblSommeTotal.getText());
        		total +=montant;
        		lblSommeTotal.setText(String.valueOf(total)); 
        		
        		// Mise � jours automatique du prix unitaire entrer et le nombre entrer recompte � vide
        		txtPrix.setText("");
                txtNombre.setText("");
                txtPrix.requestFocus();
                // 
        		} else {
                    // Afficher un message d'erreur ou effectuer une autre action si les champs sont vides
                    System.out.println("Veuillez remplir tous les champs !");    }
        	}
        });
        btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAjouter.setBounds(37, 41, 112, 23);
        panel_2.add(btnAjouter);
        
        
        // BOUTTON SUPPRIMER
        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        // pour supprimer ....
        btnSupprimer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int produitSelectionneIndex = lstAchat.getSelectedIndex();
        		
        		if (!lstAchat.isSelectionEmpty()) {
        			produitsListeAchat = Integer.parseInt(lblNombreProduits.getText());
        			produitsListeAchat--;
        			lblNombreProduits.setText(String.valueOf(produitsListeAchat));
        			total = Double.parseDouble(lblSommeTotal.getText());  
        			montant = Double.parseDouble(modeleMontant.getElementAt(produitSelectionneIndex).toString());
        			total-=montant;
        			lblSommeTotal.setText(String.valueOf(total));
        			modeleProduit.remove(produitSelectionneIndex);
        			modeleMontant.remove(produitSelectionneIndex);
        		}
        		else {
                    // Afficher un message d'erreur si aucun produit n'est s�lectionn�
                    System.out.println("Veuillez s�lectionner un produit � supprimer !");
                }
        	}
        });
        btnSupprimer.setBounds(251, 41, 123, 23);
        panel_2.add(btnSupprimer);
        
        
        // BOUTTON EFFACER 
        JButton btnEffacer = new JButton("Effacer");
        btnEffacer.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnEffacer.setBounds(513, 41, 89, 23);
        panel_2.add(btnEffacer);
        // pour effacer ce qui a �t� �crit
        btnEffacer.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtPrix.setText("");
            txtNombre.setText("");
            modeleProduit.removeAllElements();
            modeleMontant.removeAllElements();
            produitsListeAchat = 0;
            total = 0;
            lblNombreProduits.setText(String.valueOf(produitsListeAchat));
            lblSommeTotal.setText(String.valueOf(total));
        }
        }); 
        
        
        // 	BOUTTON QUITTER
        JButton btnQuitter = new JButton("Quitter");
        // pour quitter le plateform
        btnQuitter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// mon code
        		System.exit(0);
        	}
        });
        btnQuitter.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnQuitter.setBounds(787, 41, 89, 23);
        panel_2.add(btnQuitter);
        
        
        // BOUTTON AJOUTER PRODUIT
        JButton btnAjouterProduit = new JButton("Ajouter un nouveau produit");
        btnAjouterProduit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String produit = JOptionPane.showInputDialog(null, 
        				"Entrez le nouveau produit", 
        				"Ajout produit",
        				JOptionPane.DEFAULT_OPTION);
        		cmbProduit.addItem(produit);
        	}
        });
        btnAjouterProduit.setBounds(10, 10, 221, 45);
        getContentPane().add(btnAjouterProduit);
    }
}
