package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class GestionEmployes {
    private static Employe[] employes = new Employe[50];  // Tableau pour stocker jusqu'à 50 employés
    private static int nombreEmployes = 0;  // Compteur pour le nombre d'employés actuels

    // Méthode pour afficher le menu principal
    public static void printMenu() {
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher la liste des employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("8. Quitter");
    }

    // Méthode pour ajouter un nouvel employé
    public static void ajouterEmploye(Employe employe) {
        if (nombreEmployes < 50) {
            employes[nombreEmployes] = employe;
            nombreEmployes++;
            System.out.println("Employé ajouté avec succès.");
        } else {
            System.out.println("Erreur : Le tableau d'employés est plein.");
        }
        System.out.println("*****************************");
    }

    // Méthode pour modifier un employé existant
    public static void modifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire) {
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                employes[i].setNom(nouveauNom);
                employes[i].setPoste(nouveauPoste);
                employes[i].setSalaire(nouveauSalaire);
                System.out.println("Employé modifié avec succès.");
                System.out.println("*****************************");
                return;
            }
        }
        System.out.println("Erreur : Employé non trouvé.");
    }

    // Méthode pour supprimer un employé par son ID
    public static void supprimerEmploye(int id) {
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                // Décaler tous les éléments après l'employé supprimé
                for (int j = i; j < nombreEmployes - 1; j++) {
                    employes[j] = employes[j + 1];
                }
                employes[nombreEmployes - 1] = null;
                nombreEmployes--;
                System.out.println("Employé supprimé avec succès.");
                System.out.println("*****************************");
                return;
            }
        }
        System.out.println("Erreur : Employé non trouvé.");
        System.out.println("*****************************");
    }

    // Méthode pour afficher tous les employés
    public static void afficherEmployes() {
        if (nombreEmployes == 0) {
            System.out.println("Aucun employé trouvé.");
        } else {
            for (int i = 0; i < nombreEmployes; i++) {
                System.out.println(employes[i]);
            }
        }
        System.out.println("*****************************");
    }

    // Méthode pour rechercher un employé par nom ou poste
    public static void rechercherEmploye(String critere) {
        boolean trouve = false;
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getNom().equalsIgnoreCase(critere) || employes[i].getPoste().equalsIgnoreCase(critere)) {
                System.out.println(employes[i]);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun employé trouvé avec ce critère.");
        }
        System.out.println("*****************************");
    }

    // Méthode pour calculer la masse salariale
    public static void calculerMasseSalariale() {
        double totalSalarial = 0;
        for (int i = 0; i < nombreEmployes; i++) {
            totalSalarial += employes[i].getSalaire();
        }
        System.out.println("Masse salariale totale : " + totalSalarial);
        System.out.println("*****************************");
    }

    // Méthode pour trier les employés par salaire
    public static void trierEmployesParSalaire(boolean ordreCroissant) {
        Arrays.sort(employes, 0, nombreEmployes, (e1, e2) -> {
            if (ordreCroissant) {
                return Employe.compareParSalaire(e1, e2);
            } else {
                return Employe.compareParSalaire(e2, e1);
            }
        });
        afficherEmployes();
        System.out.println("*****************************");
    }

//    // Main pour tester l'application
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        boolean continuer = true;
//
//        while (continuer) {
//            printMenu();
//            int choix = scanner.nextInt();
//
//            switch (choix) {
//                case 1:
//                    System.out.print("ID : ");
//                    int id = scanner.nextInt();
//                    scanner.nextLine();  // Consommer la nouvelle ligne
//                    System.out.print("Nom : ");
//                    String nom = scanner.nextLine();
//                    System.out.print("Poste : ");
//                    String poste = scanner.nextLine();
//                    System.out.print("Salaire : ");
//                    double salaire = scanner.nextDouble();
//                    ajouterEmploye(new Employe(id, nom, poste, salaire));
//                    break;
//
//                case 2:
//                    System.out.print("ID de l'employé à modifier : ");
//                    int idModif = scanner.nextInt();
//                    scanner.nextLine();  // Consommer la nouvelle ligne
//                    System.out.print("Nouveau nom : ");
//                    String nouveauNom = scanner.nextLine();
//                    System.out.print("Nouveau poste : ");
//                    String nouveauPoste = scanner.nextLine();
//                    System.out.print("Nouveau salaire : ");
//                    double nouveauSalaire = scanner.nextDouble();
//                    modifierEmploye(idModif, nouveauNom, nouveauPoste, nouveauSalaire);
//                    break;
//
//                case 3:
//                    System.out.print("ID de l'employé à supprimer : ");
//                    int idSupprimer = scanner.nextInt();
//                    supprimerEmploye(idSupprimer);
//                    break;
//
//                case 4:
//                    afficherEmployes();
//                    break;
//
//                case 5:
//                    scanner.nextLine();  // Consommer la nouvelle ligne
//                    System.out.print("Entrez un nom ou poste à rechercher : ");
//                    String critere = scanner.nextLine();
//                    rechercherEmploye(critere);
//                    break;
//
//                case 6:
//                    calculerMasseSalariale();
//                    break;
//
//                case 7:
//                    System.out.print("Trier par ordre croissant (true/false) : ");
//                    boolean ordre = scanner.nextBoolean();
//                    trierEmployesParSalaire(ordre);
//                    break;
//
//                case 8:
//                    continuer = false;
//                    break;
//
//                default:
//                    System.out.println("Choix invalide.");
//            }
//        }
//
//        scanner.close();
//    }
}

