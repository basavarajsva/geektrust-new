package com.geektrust.family.service.get;


import com.geektrust.family.helper.PrintResult;
import com.geektrust.family.model.ChildNode;
import com.geektrust.family.model.Gender;
import com.geektrust.family.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geektrust.family.constant.Constant.PERSON_NOT_FOUND;

public class GetMaternalRelation implements GetService {

    Gender maternal;

    public GetMaternalRelation(Gender gender) {
        maternal = gender;
    }

    @Override
    public void getRelation(String member, Map<String, Node> family) {
        List<String> nodes = new ArrayList<>();
        Node childNode = family.get(member);
        if (nullCheck(childNode)) {
            System.out.println(PERSON_NOT_FOUND);
            return;
        }
        Node mother = family.get(childNode.getMother());
        if (nullCheck(mother)) {
            System.out.println(PERSON_NOT_FOUND);
            return;
        }
        Node grandMother = family.get(mother.getFather());
        if (grandMother != null && grandMother.getChildren().size() > 1) {
            for (ChildNode node : grandMother.getChildren()) {
                if (node.getGender() == maternal) {
                    nodes.add(node.getName());
                }
            }
            nodes.remove(childNode.getMother());
        }
        PrintResult.printResult(nodes);
    }

    private boolean nullCheck(Node node) {
        return node == null;
    }
}

