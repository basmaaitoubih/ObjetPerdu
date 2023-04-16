public class GestionObjetsPerdus {
        public static final String ENTETE = "\n=========================\nGESTION DES OBJETS PERDUS\n=========================\n";
        public static final String ENTETE_CHOIX1 = "\n=========================\nCONSIGNER UN OBJET PERDU\n=========================\n";
        public static final String MENU_CATEGORIES= "CATEGORIES :\n1. bijou\n2. vetement\n3. argent / portefeuille\n4. cle(s)\n5. autre\n";
        public static final String MENU = "----\nMENU\n----\n";
        public static final String CHOIX1= "1. Consigner un objet perdu";
        public static final String CHOIX2= "2. Rendre un objet reclame ";
        public static final String CHOIX3= "3. Rechercher un objet par mots cles";
        public static final String CHOIX4= "4. Rechercher un objet par date(s)";
        public static final String CHOIX5= "5. Rechercher un objet par categorie";
        public static final String CHOIX6= "6. Afficher tous les objets consignes";
        public static final String CHOIX7= "7. Quitter";
        public static final String MSG_SOL="Entrez votre choix : ";
        public static final String MSG_SOL_JOUR="\t\tEntrez le jour de la date : ";
        public static final String MSG_SOL_MOIS="\t\tEntrez le mois de la date : ";
        public static final String MSG_SOL_ANNEE="\t\tEntrez l'annee de la date : ";
        public static final String MSG_SOL_CLE="Entrez les mots-cles decrivant l'objet a consigner : ";
        public static final String MSG_SOL_LOC="Entrez la localisation de l'objet perdu consigne :";
        public static final int MIN= 1;
        public static final int MAX=7;
        public static final String MSG_SOL_CATEGORIES="Entrez le numero de la categorie : ";
        public static final String MSG_ERR_LOC="ERREUR, la chaine doit contenir entre 5 et 50 caracteres! RECOMMENCEZ...";
        public static final String MSG_ERREUR_CATEGORIES= "ERREUR, entrez un numero entre 1 et 5! RECOMMENCEZ...\n";
        public static final String MSG_ERREUR="\nERREUR, vous devez entrer un choix entre 1 et 7! RECOMMENCEZ...";
        public static final String MSG_ERREUR_DATE="\n\t\tERREUR, entrez un entier strictement positif! RECOMMENCEZ...";
        public static final String MSG_ERR_CLE= "\nERREUR, la chaine doit contenir entre 2 et 50 caracteres! RECOMMENCEZ...";
        public static final int MIN_MOT=2;
        public static final int MAX_MOT= 50;
    public static final int MIN_LOC=5;
    public static final int MAX_LOC= 50;

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

        ObjetPerdu[] objetsPerdus = TP3Utils.recupererDonnees();
        System.out.println(ENTETE);
        System.out.println();
        System.out.println();
        afficherMenu();
        choix=TP3Utils.validerEntier(MSG_SOL,MSG_ERREUR,MIN,MAX);
        if(choix==1) {
            System.out.println(ENTETE_CHOIX1);
            System.out.println(MENU_CATEGORIES);
            categorie=TP3Utils.validerEntier(MSG_SOL_CATEGORIES,MSG_ERREUR_CATEGORIES,1,5);

            System.out.println("Date de consignation :");
            jour=TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_JOUR,MSG_ERREUR_DATE);
            mois=TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_MOIS,MSG_ERREUR_DATE);
            annee=TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_ANNEE,MSG_ERREUR_DATE);
            Date date1=new Date(jour,mois,annee);
            //valliderDate
            while(date1.estDateValide()==false|| date1.estPlusPetite(date1)==true||date1.estEgale(date1)==false){
                 System.out.println("ERREUR, date invalide! RECOMMENCEZ...\n");
                System.out.println("Date de consignation :");
                jour=TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_JOUR,MSG_ERREUR_DATE);
                mois=TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_MOIS,MSG_ERREUR_DATE);
                annee=TP3Utils.validerTypeEntierStrictPositif(MSG_SOL_ANNEE,MSG_ERREUR_DATE);
                 date1.setJour(jour);
                date1.setMois(mois);
                date1.setAnnee(annee);
            }
            chaineMotsCles=TP3Utils.validerLngChaine(MSG_SOL_CLE,MSG_ERR_CLE,MIN_MOT,MAX_MOT);

            //enlever les espaces
            String [] motsCles=chaineMotsCles.split("\\s+");
            for(int i=0;i<motsCles.length;i++){
                motsCles[i]=motsCles[i].trim();
            }

            localisation=TP3Utils.validerLngChaine(MSG_SOL_LOC,MSG_ERR_LOC,MIN_LOC,MAX_LOC);
            ObjetPerdu objet1 = new ObjetPerdu (categorie,date1,localisation);
            if(nbrElemObjet== objetsPerdus.length){
                ObjetPerdu[] tab=new ObjetPerdu[objetsPerdus.length+4];
                for(int i=0;i<tab.length;i++){
                    tab[i]=objetsPerdus[i];
                }
                objetsPerdus[nbrElemObjet+1]=objet1;
            }
            afficherMenu();
    System.out.println();
    System.out.println();


        }


    }
}
