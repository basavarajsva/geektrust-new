package com.geektrust.family.service.add;


import com.geektrust.family.model.ChildNode;
import com.geektrust.family.model.Gender;
import com.geektrust.family.model.Node;

import java.util.List;
import java.util.Map;

import static com.geektrust.family.constant.Constant.*;

public class AddChild extends AddMember {

    @Override
    public void addMember(String motherName, String childName, String gender, Map<String, Node> familyTree) {
        if (familyTree.get(childName) == null) {
            Node mother = familyTree.get(motherName);
            if (!isPersonExist(mother)) {
                log(PERSON_NOT_FOUND);
                return;
            }
            if (mother.getGender() == Gender.FEMALE) {
                Gender childGender = getGenderByString(gender);
                if (!add(motherName, childName, childGender, familyTree, mother)) {
                    return;
                }
            } else {
                log(CHILD_ADDITION_FAILED);
                return;
            }

        } else {
            log(CHILD_ADDITION_FAILED);
            return;
        }
        log(CHILD_ADDITION_SUCCEEDED);
    }

    private Gender getGenderByString(String gender) {
        return FEMALE.equalsIgnoreCase(gender) ? Gender.FEMALE : Gender.MALE;
    }

    private boolean add(String motherName, String childName, Gender gender, Map<String, Node> familyTree, Node mother) {
        String fatherName = mother.getPartner();
        if (!fatherName.equals(NO_RELATIVE)) {
            Node fatherNode = familyTree.get(fatherName);
            if (fatherNode != null) {
                Node childNode = new Node(gender, fatherName, motherName, NO_RELATIVE);
                familyTree.put(childName, childNode);
                List<ChildNode> existing = mother.getChildren();
                existing.add(getChildNode(childName, gender));
                mother.setChildren(existing);
                fatherNode.setChildren(existing);
                familyTree.put(motherName, mother);
                familyTree.put(fatherName, fatherNode);
            }
            return true;
        } else {
            log(CHILD_ADDITION_FAILED);
            return false;
        }
    }

    private ChildNode getChildNode(String childName, Gender g) {
        ChildNode childNode = new ChildNode();
        childNode.setGender(g);
        childNode.setName(childName);
        return childNode;
    }

    private void log(String message) {
        if (isIsLoggingEnabled()) {
            System.out.println(message);
        }
    }

    private boolean isPersonExist(Node member) {
        return member != null;
    }
}
