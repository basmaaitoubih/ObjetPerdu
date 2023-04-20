public class GestionObjetsPerdus {
    public static final String ENTETE = "\n=========================\nGESTION DES OBJETS PERDUS\n=========================\n";
    public static final String ENTETE_CHOIX1 = "\n=========================\nCONSIGNER UN OBJET PERDU\n=========================\n";
    public static final String ENTETE_CHOIX2 = "\n=========================\nRENDRE UN OBJET RECLAME\n=========================\n";
    public static final String ENTETE_CHOIX3 = "\n=========================\nRECHERCHER PAR MOTS CLES\n=========================\n" ;
    public static final String ENTETE_CHOIX4 = "\n=========================\nRECHERCHER PAR DATE(S)\n=========================\n" ;
    public static final String ENTETE_CHOIX5 = "\n=========================\nRECHERCHER PAR CATEGORIE\n=========================\n" ;
    public static final String ENTETE_CHOIX6 = "\n=========================\nAFFICHER TOUS LES OBJETS CONSIGNES\n=========================\n" ;
    public static final String MENU_CATEGORIES= "CATEGORIES :\n1. bijou\n2. vetement\n3. argent / portefeuille\n4. cle(s)\n5. autre\n";
    public static final String MENU = "----\nMENU\n----\n";
    public static final String CHOIX1= "1. Consigner un objet perdu";
    public static final String CHOIX2= "2. Rendre un objet reclame ";
    public static final String CHOIX3= "3. Rechercher un objet par mots cles";
    public static final String CHOIX4= "4. Rechercher un objet par date(s)";
    public static final String CHOIX5= "5. Rechercher un objet par categorie";
    public static final String CHOIX6= "6. Afficher tous les objets consignes";
    public static final String CHOIX7= "7. Quitter";
    public static final String MSG_SOL_REP = "Voulez-vous vraiment rendre cet objet perdu (oui / non) :" ;
    public static final String MSG_SOL_RES= "Specifier une (d)ate ou une (p)eriode :";
    public static final String MSG_SOL_MOT = "Mot(s) cle(s) recherches :" ;
    public static final String MSG_SOL_OBJETPERDU = "Entrez le numero d'identification (id) de l'objet a rendre :";
    public static final String MSG_SOL ="Entrez votre choix : ";

    public static final String MSG_SOL_JOUR = "\t\tEntrez le jour de la date : ";
    public static final String MSG_SOL_MOIS = "\t\tEntrez le mois de la date : ";
    public static final String MSG_SOL_ANNEE = "\t\tEntrez l'annee de la date : ";
    public static final String MSG_SOL_CLE = "Entrez les mots-cles decrivant l'objet a consigner : ";
    public static final String MSG_SOL_LOC = "Entrez la localisation de l'objet perdu consigne :";
    public static final int MIN = 1;
    public static final int MAX = 7;
    public static final String MSG_SOL_CATEGORIES = "Entrez le numero de la categorie : ";
    public static final String MSG_ERR_LOC = "ERREUR, la chaine doit contenir entre 5 et 50 caracteres! RECOMMENCEZ...";
    public static final String MSG_ERREUR_CATEGORIES = "ERREUR, entrez un numero entre 1 et 5! RECOMMENCEZ...\n";
    public static final String MSG_ERREUR_CHOIX = "\nERREUR, vous devez entrer un choix entre 1 et 7! RECOMMENCEZ...";
    public static final String MSG_ERREUR = "\n\t\tERREUR, entrez un entier strictement positif! RECOMMENCEZ...";
    public static final String MSG_ERR_CLE = "\nERREUR, la chaine doit contenir entre 2 et 50 caracteres! RECOMMENCEZ...";

    public static final String MSG_ERR_REP = "ERREUR, vous devez entrer OUI ou NON! RECOMMENCEZ..";
    public static final String MSG_ERR_MOT = "ERREUR, la chaine doit contenir entre 2 et 50 caracteres! RECOMMENCEZ..." ;
    public static final String MSG_ERR_RES = "";
    public static final int MIN_MOT = 2;
    public static final int MAX_MOT = 50;
    public static final int MIN_LOC = 5;
    public static final int MAX_LOC = 50;
    public static final char CAR_MAX = 'd';
    public static final char CAR_MIN = 'p';
    public static final String REP1 = "oui";
    public static final String REP2 = "non";

    /**
     * cette methode affiche un menu de sept options
     *
     */
    public static void afficherMenu(){
        System.out.println(MENU);
        System.out.println(CHOIX1);
        System.out.println(CHOIX2);
        System.out.println(CHOIX3);
        System.out.println(CHOIX4);
        System.out.println(CHOIX5);
        System.out.println(CHOIX6);
        System.out.println(CHOIX7);
        System.out.println();
    }

    public static void taperEntree(){
        System.out.println("Appuyez sur <ENTREE> pour revenir au menu...");
        Clavier.lireFinLigne();
    }


    public static void main(String []args){

        int choix;
        int categorie;
        int jour;
        int mois;
        int annee;
        int dateValide;
        int nbrElemObjet=0;
        String chaineMotsCles;
        String localisation;
        int numeroObjetPerdu;
        String choixRep;
        char rep;

        ObjetPerdu[] objetsPerdus = TP3Utils.recupererDonnees();
        System.out.println(ENTETE);
        System.out.println();
        System.out.println();
        do {
            afficherMenu();
            choix = TP3Utils.validerEntier(MSG_SOL, MSG_ERREUR_CHOIX, MIN, MAX);
            if (choix == 1) {
                System.out.println(ENTETE_CHOIX1);
                System.out.println(MENU_CATEGORIES);
                categorie = TP3Utils.validerEntier(MSG_SOL_CATEGORIES, MSG_ERREUR_CATEGORIES, 1, 5);

                System.out.println("Date de consignation :");
                jour = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_JOUR, MSG_ERREUR_CHOIX);
                mois = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_MOIS, MSG_ERREUR_CHOIX);
                annee = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_ANNEE, MSG_ERREUR_CHOIX);
                Date date1 = new Date(jour, mois, annee);
                //valliderDate
                while (date1.estDateValide() == false || date1.estPlusPetite(date1) == true || date1.estEgale(date1) == false) {
                    System.out.println("ERREUR, date invalide! RECOMMENCEZ...\n");
                    System.out.println("Date de consignation :");
                    jour = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_JOUR, MSG_ERREUR_CHOIX);
                    mois = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_MOIS, MSG_ERREUR_CHOIX);
                    annee = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_ANNEE, MSG_ERREUR_CHOIX);
                    date1.setJour(jour);
                    date1.setMois(mois);
                    date1.setAnnee(annee);
                }


                chaineMotsCles = TP3Utils.validerLngChaine(MSG_SOL_CLE, MSG_ERR_CLE, MIN_MOT, MAX_MOT);
                localisation = TP3Utils.validerLngChaine(MSG_SOL_LOC, MSG_ERR_LOC, MIN_LOC, MAX_LOC);

                ObjetPerdu objet1 = new ObjetPerdu(categorie, date1, localisation);
            //enlever les espaces

                objet1.motsCles = chaineMotsCles.split("\\s+");
                for (int i = 0; i < objetsPerdus.length; i++) {
                    objet1.motsCles[i] = objet1.motsCles[i].trim();
                }

                System.out.println();

                if (nbrElemObjet == objetsPerdus.length) {
                    ObjetPerdu[] tab = new ObjetPerdu[objetsPerdus.length + 4];
                    for (int i = 0; i < objetsPerdus.length; i++) {
                        tab[i] = objetsPerdus[i];
                    }
                    objetsPerdus = tab;
                }
                System.out.println();
                afficherMenu();

            } else if (choix == 2) {
                System.out.println(ENTETE_CHOIX2);

                numeroObjetPerdu = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_OBJETPERDU, MSG_ERREUR);
                if (objetsPerdus == null) { //si L'objet n'est pas dans le tableau
                    // valider le choix
                    System.out.println("** LA REMISE DE L'OBJET PERDU A ETE EFFECTUEE AVEC SUCCES **");
                    taperEntree();

                } else {

                    choixRep=TP3Utils.validerRepDeuxChoix(MSG_SOL_REP,MSG_ERR_REP,REP1,REP2);
                    if (choixRep.equals(REP1)) { //OUI
                        //tab.[numeroObjetPerdu].supprimerMotCle();
                        System.out.println("** LA REMISE DE L'OBJET PERDU A ETE EFFECTUEE AVEC SUCCES **");
                        taperEntree();

                        //objetsPerdus[i].supprimerMotCle();
                    } else if (choixRep.equals(REP2)) { //NON
                        System.out.println("** LA REMISE DE L'OBJET PERDU A ETE ANNULEE **");
                        taperEntree();

                    }

                }

            } else if (choix == 3) {
                String chaine;
                System.out.println(ENTETE_CHOIX3);
                chaine = TP3Utils.validerLngChaine(MSG_SOL_MOT,MSG_ERR_MOT,MIN_MOT,MAX_MOT);
                if (objetsPerdus != null) { //objet consigne existe dans le tableau

                } else {
                    System.out.println("RESULTAT(S) DE LA RECHERCHE :");
                    System.out.println("** AUCUN OBJET TROUVE **");
                    taperEntree();
                }

            } else if (choix == 4) {
                System.out.println(ENTETE_CHOIX4);


                if(objetsPerdus== null){    //condition a changer
                    System.out.println("** AUCUN OBJET PERDU N'EST CONSIGNE **\n");
                    taperEntree();
                } else {
                    rep = TP3Utils.validerCaractere(MSG_SOL_RES,MSG_ERR_RES,CAR_MIN,CAR_MAX);
                    if (rep == 'd') {
                        System.out.println("Date :");
                        jour = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_JOUR, MSG_ERREUR_CHOIX);
                        mois = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_MOIS, MSG_ERREUR_CHOIX);
                        annee = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_ANNEE, MSG_ERREUR_CHOIX);
                        System.out.println("RESULTAT(S) DE LA RECHERCHE :");
                        //AFFICHER LES OBJETS PAR dATE
                        System.out.println("** AUCUN OBJET TROUVE **");
                        taperEntree();

                    } else if ( rep == 'p') {
                        System.out.println("Date du debut de la periode : ");
                        jour = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_JOUR, MSG_ERREUR_CHOIX);
                        mois = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_MOIS, MSG_ERREUR_CHOIX);
                        annee = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_ANNEE, MSG_ERREUR_CHOIX);
                        System.out.println("Date de la fin de la periode :");
                        jour = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_JOUR, MSG_ERREUR_CHOIX);
                        mois = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_MOIS, MSG_ERREUR_CHOIX);
                        annee = TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_ANNEE, MSG_ERREUR_CHOIX);
                        System.out.println("RESULTAT(S) DE LA RECHERCHE :");
                                                                                            //AFFICHER LES OBJETS PAR periode
                        taperEntree();

                    }
                }

            } else if (choix == 5) {
                System.out.println(ENTETE_CHOIX5);


                if (objetsPerdus==null) {  //condition a changer
                    System.out.println("");
                    System.out.println("** AUCUN OBJET PERDU N'EST CONSIGNE **");
                    taperEntree();
                } else {
                    System.out.println(MENU_CATEGORIES);
                    categorie = TP3Utils.validerEntier(MSG_SOL_CATEGORIES, MSG_ERREUR_CATEGORIES, 1, 5);
                    System.out.println("RESULTAT(S) DE LA RECHERCHE :");
                    taperEntree();

                }

            } else if (choix == 6) {
                System.out.println(ENTETE_CHOIX6);

                if (objetsPerdus==null) {
                    System.out.println("");
                    System.out.println("** AUCUN OBJET PERDU N'EST CONSIGNE **");
                    taperEntree();
                } else {
                                        //AFFICHER DE TOUS LES OBJETS CONSIGNES
                    taperEntree();

                }
            }
        } while(choix != 7);
        System.out.println("\n\nAUREVOIR !");

    }
}
