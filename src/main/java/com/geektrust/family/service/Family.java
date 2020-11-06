package com.geektrust.family.service;


import com.geektrust.family.constant.Constant;
import com.geektrust.family.model.Gender;
import com.geektrust.family.model.Node;

import java.util.LinkedHashMap;
import java.util.Map;

public class Family {
    private Map<String, Node> familyTree = new LinkedHashMap<>();

    public Map<String, Node> getFamilyTree() {
        return familyTree;
    }

    public Family() {
        Node rootMale = new Node(Gender.MALE, "", "", Constant.QUEEN);
        Node rootFemale = new Node(Gender.FEMALE, "", "", Constant.KING);
        familyTree.put(Constant.KING, rootMale);
        familyTree.put(Constant.QUEEN, rootFemale);
    }

    public void populateRelation() {

    }
}
