package com.geektrust.family.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Gender gender;
    private String partner;
    private List<ChildNode> children;
    private String father;
    private String mother;

    public Node(Gender gender, String father, String mother, String partner) {
        this.children = new ArrayList<>();
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.partner = partner;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public List<ChildNode> getChildren() {
        return children;
    }

    public void setChildren(List<ChildNode> children) {
        this.children = children;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

}
