package Model;



public class Employee {
    public enum Role {
        EMPLOYEE,
        ADMIN
    }

    public enum Poste {
        INGENIEUR_ETUDE_ET_DEVELOPPEMENT,
        TEAM_LEADER,
        PILOTE
    }
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private String email;



    private Double salaire ;
    private Poste poste ;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private Role role ;

    public Employee(int id, String nom, String prenom, String tel, String email,double salaire , Role role , Poste poste) {
        this.salaire = salaire ;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
        this.role = role ;
        this.poste = poste ;
    }
    public Double getSalaire() {
        return salaire;
    }
    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }
    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    @Override
    public String toString() {
        return String.format(
                "| %-5s | %-15s | %-15s | %-15s | %-25s | %-10s | %-20s | %-10s |",
                id, nom, prenom, tel, email, salaire, poste, role
        );
    }
}
