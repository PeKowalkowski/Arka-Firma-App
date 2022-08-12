package com.example.arkaFirmaApp.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "productions")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int scratchNumber;
    private String projectName;
    private String principalName;
    private String material;
    private double thickness;
    private int quantity;
    private String waterLaser;
    private String ship;
    private String comments;

    public Production() {
    }

    public Production(LocalDate date, int scratchNumber, String projectName, String principalName, String material,
                      double thickness, int quantity, String waterLaser, String ship, String comments) {
        this.date = date;
        this.scratchNumber = scratchNumber;
        this.projectName = projectName;
        this.principalName = principalName;
        this.material = material;
        this.thickness = thickness;
        this.quantity = quantity;
        this.waterLaser = waterLaser;
        this.ship = ship;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getScratchNumber() {
        return scratchNumber;
    }

    public void setScratchNumber(int scratchNumber) {
        this.scratchNumber = scratchNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWaterLaser() {
        return waterLaser;
    }

    public void setWaterLaser(String waterLaser) {
        this.waterLaser = waterLaser;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
