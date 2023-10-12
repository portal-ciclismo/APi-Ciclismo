package br.com.dcx.ufpb.eng.ApiCiclismo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serial;

@Entity
public class Bike {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(mappedBy = "bike")
    private Profile profile;

    @Size(max = 30)
    private String frameMaterial;

    @Size(max = 30)
    private String frameBrand;

    @Size(max = 2)
    private Integer wheelSize;

    public Bike(String frameMaterial, String frameBrand, Integer wheelSize) {
        this.frameMaterial = frameMaterial;
        this.frameBrand = frameBrand;
        this.wheelSize = wheelSize;
    }

    public Bike() {
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFrameMaterial() {
        return frameMaterial;
    }

    public void setFrameMaterial(String frameMaterial) {
        this.frameMaterial = frameMaterial;
    }

    public String getFrameBrand() {
        return frameBrand;
    }

    public void setFrameBrand(String frameBrand) {
        this.frameBrand = frameBrand;
    }

    public Integer getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(Integer wheelSize) {
        this.wheelSize = wheelSize;
    }
}