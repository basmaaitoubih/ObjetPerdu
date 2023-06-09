public class ObjetPerdu {

    //CONSTANTES DE CLASSE

    public static final int CAT_BIJOU = 0; //
    public static final int CAT_VETEMENT = 1; //annee max valide
    public static final int CAT_ARGENT_PORTEFEUILLE = 2;     //mois min valide
    public static final int CAT_CLE = 3;    //mois max valide
    public static final int CAT_AUTRE = 4;     //jour min valide
    public static final String[] CATEGORIES = {"bijou", "vetement", "argent / portefeuille", "cle(s)", "autre"};

    //ATTRIBUTS DE CLASSE
    public static int sequenceId = 1;

    //ATTRIBUTS (VARIABLES D'INSTANCE)
    private int id ;
    private String [] motsCles;
    private int categorie;
    private Date date;
    private String localisation;


    //CONSTRUCTEURS

    /**
     *  Constructeur qui initialise les attributs: categorie, date, localisation par les valeurs passés en paramère
     * @param categorie la categorie de l'objet perdu
     *  ANTECEDANT :: doit être une valeur entre 0 et CATEGORIES.length – 1 inclusivement
     * @param date date de consignation de l'objet perdu
     * @param localisation l'endroit où l'on range l'objet perdu consigné
     */
    public ObjetPerdu(int categorie, Date date, String localisation){
        if (categorie >= 0 && categorie < CATEGORIES.length) {
            this.categorie = categorie;
        }
        this.date = date;
        this.localisation = localisation;
        id = sequenceId;
        sequenceId++;
        this.motsCles= new String[0];
    }
    //GETTERS

    /**
     * Permet d'obtenir le numero unique d'identification de cet objet perdu.
     * @return le numero unique d'identification de cet objet perdu
     */
    public int getId(){
        return id;
    }

    /**
     * Permet d'obtenir la categorie de cet objet perdu.
     * @return la categorie de cet objet perdu.
     */
    public int getCategorie(){
        return categorie;
    }
    /**
     * Permet d'obtenir la date de consignation de cet objet perdu
     * @return la date de consignation de cet objet perdu
     */
    public Date getDate(){
        return date;
    }
    /**
     * Permet d'obtenir l’endroit où l’on range l’objet perdu consigné .
     * @return l’endroit où l’on range l’objet perdu consigné
     */
    public String getLocalisation(){
        return localisation;
    }

    //SETTERS
    /**
     * Permet de modifier la categorie de cet objet perdu.
     * @param categorie nouvelle categorie.
     * ANTECEDANT: categorie doit être une valeur entre 0 et CATEGORIES.length – 1 inclusivement
     */
    public void setCategorie(int categorie) {
        if (categorie >= 0 && categorie <= CATEGORIES.length-1) {
            this.categorie = categorie;
        }
    }

    /**
     * Permet de modifier la date de consignation de cet objet perdu .
     * @param date la nouvelle date de consignation de cet objet perdu .
     */
    public void setDate (Date date) {
        this.date = date;
    }

    /**
     * Permet de modifier le nom de cet employe.
     * @param localisation nouveau nom pour cet employe.
     */
    public void setLocalisation (String localisation) {
        this.localisation = localisation;
    }

    //AUTRES METHODES D'INSTANCE PUBLIQUES
    /**
     * Methode qui permet d'obtenir une chaine de caractères contenant tous les mots clés associés à cet objet perdu (stockés dans
     * l’attribut motsCles)
     * Si le tableau motsCles est vide, la chaine retournée par cette méthode sera la chaine vide.
     * @return une chaine qui contient les mots cles dans l'ordre ou ils apparaissent dans le tableau motsCles
     */
    public String obtenirMotsCles() {
        return String.join(" ", motsCles);
    }

    /**
     * Methode qui permet d’ajouter le motCle donné en paramètre dans le tableau motsCles de cet objet perdu.
        * @param motCle  un mot cle a associer a cet objet perd
    * @return true si le motCle a bien été ajouté, false sinon
    */
    public boolean ajouterMotCle (String motCle) {
        boolean videOuNull;
        boolean trouve = false;
        

        videOuNull = (motCle == null || motCle.isEmpty());
        if (!videOuNull) {   
            for (int i = 0; i < motsCles.length; i++) {
                if (motCle.equalsIgnoreCase(motsCles[i])) {
                    trouve = true;
                }
            }
        }

        if (!videOuNull && !trouve) {
            String[] nvMotsCles = new String[motsCles.length + 1];
            for (int i = 0; i < motsCles.length; i++) {
                nvMotsCles[i] = motsCles[i];
            }
            nvMotsCles[motsCles.length] = motCle;
            motsCles = nvMotsCles;
        }
        return !videOuNull && !trouve;
    }

    /**
     * cette methode permet
     * @param motCle le mot clé dont on veut savoir s’il est associé à cet objet perdu
     * @return retourne true si le motCle donné en paramètre est présent (sans tenir compte de la casse) dans le
     * tableau motsCles de cet objet perdu, retourne false sinon.
     */
    public boolean estAssocieACeMotCle(String motCle) {
        boolean trouve = false;
        for (int i = 0; i < motsCles.length; i++) {
            if (motCle.equalsIgnoreCase(motsCles[i])) {
                trouve = true;
            }
        }
        return trouve;
    }

    /**
     * cette methode permet de supprimer le motCle donné en paramètre du tableau motsCles de cet objet perdu
     * @param motCle le mot clé dont on veut retirer l’association à cet objet perdu
     * Si motCle n’est pas dans le tableau motsCles, cette méthode ne supprime rien, et le tableau motsCles demeure inchangé.
     * @return true si le motCle donné en paramètre a été retiré du tableau motsCles de cet objet perdu,
     * retourne false sinon
     */
    public boolean supprimerMotCle(String motCle) {
        boolean trouve = false;
        int j = 0;

        for (int i = 0; i < motsCles.length; i++) {
            if (motCle.equalsIgnoreCase(motsCles[i])) {
                trouve = true;
                j = i;
            }
        }
        if (trouve) {
            String[] nvMotsCles = new String[motsCles.length - 1];
            for (int i = 0; i < motsCles.length; i++) {
                if (i < j) {
                    nvMotsCles[i] = motsCles[i];
                } else if (i > j) {
                    nvMotsCles[i - 1] = motsCles[i];
                }
            }
            motsCles = nvMotsCles;
        }
        return trouve;
    }


    /**
     * Cette methode retourne une representation sous forme d'une chaine de caracteres de cet
     * objet perdu.
     *
     * ANTECEDENTS :
     *   - la categorie de cet objet perdu est valide (entre 0 et CATEGORIES.length - 1)
     *   - le tableau motsCles n'est pas null.
     *
     * @return une representation sous forme d'une chaine de caracteres de cet objet perdu.
     */
    public String toString() {
        String listeMotsCles = "";
        String desc = "ID           : " + id + "\n" + "MOTS CLES    : ";

        for (String motCle : motsCles) {
            listeMotsCles = listeMotsCles + motCle + ", ";
        }

        desc = desc + (!listeMotsCles.isEmpty()
                ? listeMotsCles.substring(0, listeMotsCles.length() - 2) : listeMotsCles);
        desc = desc + "\n";
        desc = desc + "CATEGORIE    : " + CATEGORIES[categorie] + "\n"
                + "DATE         : " + date + "\n"
                + "LOCALISATION : " + localisation;
        return desc;
    }

    // METHODES DE CLASSE PUBLLIQUES
    /**
     * Methode qui permet d'obtenir la valeur de l'attribut sequenceId.
     * @return la valeur de l’attribut de classe sequenceId .
     */
    public static int getSequenceId() {
        return sequenceId;
    }

    /**
     * Cette methode permet de modifier la valeur de l'attribut de classe sequenceId  par la valeur donnée en paramètre.
     * @param valeur la nouvelle valeur de sequenceId.
     */
    public static void setSequenceId(int valeur) {
        sequenceId = valeur;
    }

}