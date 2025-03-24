import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Librairie extends JFrame {

    // Variables pour la gestion des produits et des montants
    String[] produits = {"Stylo", "Crayon", "Cahier", "Gomme", "Colle"};
    double prixUnitaire, total = 0, montant;
    int nombreProduits, produitsListeAchat = 0;
    String produitSelectionné;

    DefaultListModel modeleProduit, modeleMontant;

    private static final long serialVersionUID = 1L;
    private JTextField txtPrix;
    private JTextField txtNombre;
    private JLabel lblNombreProduits;
    private JLabel lblSommeTotal;

    /**
     * Point d'entrée du programme.
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
     * Constructeur principal : gestion de l'interface.
     */
    public Librairie() {
        // Initialisation des modèles pour les listes dynamiques
        modeleProduit = new DefaultListModel();
        modeleMontant = new DefaultListModel();

        // Configuration de la fenêtre principale
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 990, 600);
        getContentPane().setLayout(null);

        // Titre principal
        JLabel lblNewLabel = new JLabel("Gestion de Librairie et Produits");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
        lblNewLabel.setBounds(245, 10, 500, 50);
        getContentPane().add(lblNewLabel);

        // Panel pour les entrées
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(10, 70, 230, 320);
        panel.setLayout(null);
        getContentPane().add(panel);

        // Choix du produit
        JLabel lblProduits = new JLabel("Choisir le produit");
        lblProduits.setHorizontalAlignment(SwingConstants.LEFT);
        lblProduits.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblProduits.setBounds(10, 10, 200, 30);
        panel.add(lblProduits);

        JComboBox cmbProduit = new JComboBox();
        cmbProduit.setBounds(10, 40, 200, 30);
        panel.add(cmbProduit);

        // Ajouter les produits au combo box
        for (String produit : produits) {
            cmbProduit.addItem(produit);
        }

        // Entrer le prix
        JLabel lblPrix = new JLabel("Prix unitaire");
        lblPrix.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblPrix.setBounds(10, 80, 200, 30);
        panel.add(lblPrix);

        txtPrix = new JTextField();
        txtPrix.setBounds(10, 110, 200, 30);
        panel.add(txtPrix);

        // Entrer la quantité
        JLabel lblNombre = new JLabel("Quantité");
        lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNombre.setBounds(10, 150, 200, 30);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(10, 180, 200, 30);
        panel.add(txtNombre);

        // Panel pour afficher les achats
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(260, 70, 700, 320);
        panel_1.setLayout(null);
        getContentPane().add(panel_1);

        JLabel lblAchat = new JLabel("Liste des Achats");
        lblAchat.setHorizontalAlignment(SwingConstants.CENTER);
        lblAchat.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblAchat.setBounds(20, 10, 250, 30);
        panel_1.add(lblAchat);

        JList lstAchat = new JList();
        lstAchat.setBounds(20, 50, 300, 200);
        panel_1.add(lstAchat);
        lstAchat.setModel(modeleProduit);

        JLabel lblMontants = new JLabel("Montants");
        lblMontants.setHorizontalAlignment(SwingConstants.CENTER);
        lblMontants.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblMontants.setBounds(380, 10, 250, 30);
        panel_1.add(lblMontants);

        JList lstMontant = new JList();
        lstMontant.setBounds(380, 50, 300, 200);
        panel_1.add(lstMontant);
        lstMontant.setModel(modeleMontant);

        lblNombreProduits = new JLabel("0");
        lblNombreProduits.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreProduits.setBounds(20, 260, 300, 30);
        panel_1.add(lblNombreProduits);

        lblSommeTotal = new JLabel("0.0");
        lblSommeTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblSommeTotal.setBounds(380, 260, 300, 30);
        panel_1.add(lblSommeTotal);

        // Boutons interactifs
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setBounds(10, 400, 950, 100);
        panel_2.setLayout(null);
        getContentPane().add(panel_2);

        // Ajouter un produit
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtPrix.getText().isEmpty() && !txtNombre.getText().isEmpty()) {
                    produitSelectionné = cmbProduit.getSelectedItem().toString();
                    prixUnitaire = Double.parseDouble(txtPrix.getText());
                    nombreProduits = Integer.parseInt(txtNombre.getText());
                    modeleProduit.addElement(produitSelectionné);
                    montant = prixUnitaire * nombreProduits;
                    modeleMontant.addElement(montant);
                    produitsListeAchat++;
                    lblNombreProduits.setText(String.valueOf(produitsListeAchat));
                    total += montant;
                    lblSommeTotal.setText(String.valueOf(total));
                    txtPrix.setText("");
                    txtNombre.setText("");
                } else {
                    System.out.println("Veuillez remplir tous les champs !");
                }
            }
        });
        btnAjouter.setBounds(30, 30, 120, 30);
        panel_2.add(btnAjouter);

        // Supprimer un produit
        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int produitSelectionneIndex = lstAchat.getSelectedIndex();
                if (!lstAchat.isSelectionEmpty()) {
                    produitsListeAchat--;
                    lblNombreProduits.setText(String.valueOf(produitsListeAchat));
                    montant = Double.parseDouble(modeleMontant.getElementAt(produitSelectionneIndex).toString());
                    total -= montant;
                    lblSommeTotal.setText(String.valueOf(total));
                    modeleProduit.remove(produitSelectionneIndex);
                    modeleMontant.remove(produitSelectionneIndex);
                } else {
                    System.out.println("Veuillez sélectionner un produit à supprimer !");
                }
            }
        });
        btnSupprimer.setBounds(160, 30, 120, 30);
        panel_2.add(btnSupprimer);

        // Effacer toutes les données
        JButton btnEffacer = new JButton("Effacer");
        btnEffacer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtPrix.setText("");
                txtNombre.setText("");
                modeleProduit.removeAllElements();
                modeleMontant.removeAllElements();
                produitsListeAchat = 0;
                total = 0;
                lblNombreProduits.setText("0");
                lblSommeTotal.setText("0.0");
            }
        });
        btnEffacer.setBounds(290, 30, 120, 30);
        panel_2.add(btnEffacer);

        // Quitter l'application
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnQuitter.setBounds(420, 30, 120, 30);
        panel_2.add(btnQuitter);
    }
}
