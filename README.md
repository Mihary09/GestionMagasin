# 📚 Librairie - Application de Gestion de Produits

## 📝 Description

Cette application de gestion de librairie est développée en Java avec la bibliothèque Swing pour l'interface graphique. Elle permet de gérer dynamiquement les produits achetés (stylos, cahiers, gommes…) avec leurs quantités et montants totaux.

L'utilisateur peut :
- Sélectionner un produit
- Entrer son prix unitaire
- Spécifier la quantité
- Ajouter l'article à la liste d'achat
- Supprimer ou effacer les achats

## ✨ Fonctionnalités

- **Ajout de produit** : Sélection du produit, saisie du prix unitaire et de la quantité, ajout à la liste.
- **Suppression** : Retrait d’un produit sélectionné dans la liste d’achat.
- **Effacement total** : Réinitialisation de la liste et des montants.
- **Calcul automatique** :
  - Nombre total de produits achetés
  - Somme totale des montants

## 🔧 Structure du projet

- `Librairie.java` : Classe principale qui gère :
  - L’interface graphique avec Swing
  - La logique de calcul des montants
  - L’ajout/suppression des produits via des listes dynamiques

## 🛠️ Technologies utilisées

| Technologie | Description |
|-------------|-------------|
| Java        | Langage principal |
| Swing       | Interface utilisateur |
| AWT         | Gestion des composants et événements |
| JDK 8+      | Environnement de développement |

⚠️ Ce projet ne nécessite pas de base de données, tout est géré en mémoire pendant l’exécution.

## 🖥️ Configuration requise

- Java JDK 8 ou supérieur
- Un IDE comme IntelliJ IDEA, Eclipse ou NetBeans (optionnel)

## 🚀 Installation & Exécution

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/Mihary09/GestionUtilisateurs


Compiler et exécuter l’application :
   javac Librairie.java
java Librairie

