package com.rode.foro.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patata")
public class Patata implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private Boolean comestible;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "patata_gusanos",
            joinColumns = @JoinColumn(name="patata_id"),
            inverseJoinColumns = @JoinColumn(name="gusanos_id") )
    private Set<Gusanos> gusanosSet = new HashSet<>();

    public Patata(){}

    public Boolean getComestible() {
        return comestible;
    }

    public void setComestible(Boolean comestible) {
        this.comestible = comestible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Set getGusanosSet() {
        return gusanosSet;
    }

    public void setGusanosSet(Set gusanosSet) {
        this.gusanosSet = gusanosSet;
    }
}
