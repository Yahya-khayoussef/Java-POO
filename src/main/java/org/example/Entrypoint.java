package org.example;

import java.util.Scanner;

import static org.example.GestionEmployes.*;

public class Entrypoint {
    // Main pour tester l'application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            printMenu();
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consommer la nouvelle ligne
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Poste : ");
                    String poste = scanner.nextLine();
                    System.out.print("Salaire : ");
                    double salaire = scanner.nextDouble();
                    ajouterEmploye(new Employe(id, nom, poste, salaire));
                    break;

                case 2:
                    System.out.print("ID de l'employé à modifier : ");
                    int idModif = scanner.nextInt();
                    scanner.nextLine();  // Consommer la nouvelle ligne
                    System.out.print("Nouveau nom : ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Nouveau poste : ");
                    String nouveauPoste = scanner.nextLine();
                    System.out.print("Nouveau salaire : ");
                    double nouveauSalaire = scanner.nextDouble();
                    modifierEmploye(idModif, nouveauNom, nouveauPoste, nouveauSalaire);
                    break;

                case 3:
                    System.out.print("ID de l'employé à supprimer : ");
                    int idSupprimer = scanner.nextInt();
                    supprimerEmploye(idSupprimer);
                    break;

                case 4:
                    afficherEmployes();
                    break;

                case 5:
                    scanner.nextLine();  // Consommer la nouvelle ligne
                    System.out.print("Entrez un nom ou poste à rechercher : ");
                    String critere = scanner.nextLine();
                    rechercherEmploye(critere);
                    break;

                case 6:
                    calculerMasseSalariale();
                    break;

                case 7:
                    System.out.print("Trier par ordre croissant (true/false) : ");
                    boolean ordre = scanner.nextBoolean();
                    trierEmployesParSalaire(ordre);
                    break;

                case 8:
                    continuer = false;
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}
