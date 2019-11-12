package sv.edu.entity;
// Generated 11-12-2019 05:16:03 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Mecanico generated by hbm2java
 */
@Entity
@Table(name="mecanico"
    ,catalog="Taller"
    , uniqueConstraints = {@UniqueConstraint(columnNames="nombreusu"), @UniqueConstraint(columnNames="dui")} 
)
public class Mecanico  implements java.io.Serializable {


     private Integer idmecanico;
     private String nombreusu;
     private String password;
     private String nombre;
     private String telefono;
     private String telefono2;
     private String dui;
     private String nit;
     private Set<Caso> casos = new HashSet<Caso>(0);

    public Mecanico() {
    }

	
    public Mecanico(String nombreusu, String password, String nombre, String telefono, String dui, String nit) {
        this.nombreusu = nombreusu;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.dui = dui;
        this.nit = nit;
    }
    public Mecanico(String nombreusu, String password, String nombre, String telefono, String telefono2, String dui, String nit, Set<Caso> casos) {
       this.nombreusu = nombreusu;
       this.password = password;
       this.nombre = nombre;
       this.telefono = telefono;
       this.telefono2 = telefono2;
       this.dui = dui;
       this.nit = nit;
       this.casos = casos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idmecanico", unique=true, nullable=false)
    public Integer getIdmecanico() {
        return this.idmecanico;
    }
    
    public void setIdmecanico(Integer idmecanico) {
        this.idmecanico = idmecanico;
    }

    
    @Column(name="nombreusu", unique=true, nullable=false, length=30)
    public String getNombreusu() {
        return this.nombreusu;
    }
    
    public void setNombreusu(String nombreusu) {
        this.nombreusu = nombreusu;
    }

    
    @Column(name="password", nullable=false, length=50)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="nombre", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="telefono", nullable=false, length=8)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="telefono2", length=8)
    public String getTelefono2() {
        return this.telefono2;
    }
    
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    
    @Column(name="dui", unique=true, nullable=false, length=9)
    public String getDui() {
        return this.dui;
    }
    
    public void setDui(String dui) {
        this.dui = dui;
    }

    
    @Column(name="nit", nullable=false, length=14)
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mecanico")
    public Set<Caso> getCasos() {
        return this.casos;
    }
    
    public void setCasos(Set<Caso> casos) {
        this.casos = casos;
    }




}


