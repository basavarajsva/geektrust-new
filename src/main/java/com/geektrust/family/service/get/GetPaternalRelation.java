package com.geektrust.family.service.get;

import com.geektrust.family.helper.PrintResult;
import com.geektrust.family.model.ChildNode;
import com.geektrust.family.model.Gender;
import com.geektrust.family.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geektrust.family.constant.Constant.PERSON_NOT_FOUND;


public class GetPaternalRelation implements GetService {
    private Gender gender;

    public GetPaternalRelation(Gender gender) {
        this.gender = gender;
    }

    @Override
    public void getRelation(String member, Map<String, Node> family) {
        List<String> nodes = new ArrayList<>();
        Node childNode = family.get(member);
        if (nullCheck(childNode)) {
            System.out.println(PERSON_NOT_FOUND);
            return;
        }
        Node father = family.get(childNode.getFather());
        if (nullCheck(father)) {
            System.out.println(PERSON_NOT_FOUND);
            return;
        }
        Node grandMother = family.get(father.getFather());
        if (grandMother != null && grandMother.getChildren().size() > 1) {
            for (ChildNode node : grandMother.getChildren()) {
                if (node.getGender() == gender) {
                    nodes.add(node.getName());
                }
            }
        }
        nodes.remove(childNode.getFather());
        PrintResult.printResult(nodes);
    }

    private boolean nullCheck(Node node) {
        return node == null;
    }
}
