package com.geektrust.family.service.get;

import com.geektrust.family.helper.PrintResult;
import com.geektrust.family.model.ChildNode;
import com.geektrust.family.model.Gender;
import com.geektrust.family.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geektrust.family.constant.Constant.NO_RELATIVE;
import static com.geektrust.family.constant.Constant.PERSON_NOT_FOUND;


public class GetInLaw implements GetService {
    private Gender gender;

    public GetInLaw(Gender gender) {
        this.gender = gender;
    }

    @Override
    public void getRelation(String member, Map<String, Node> family) {
        Node person = family.get(member);
        List<String> result = new ArrayList<>();
        if (person != null) {
            if (!person.getFather().equals(NO_RELATIVE)) {
                spouseOfSibling(family, person.getFather(), result);
                result.remove(member);
            }
            if (!person.getPartner().equals(NO_RELATIVE)) {
                siblingOfSpouse(family, person.getPartner(), result);
                result.remove(person.getPartner());
            }
            result.remove(person.getPartner());
        } else {
            System.out.println(PERSON_NOT_FOUND);
            return;
        }
        PrintResult.printResult(result);
    }

    private Gender getOppositeGender(Gender g) {
        return g == Gender.MALE ? Gender.FEMALE : Gender.MALE;
    }

    private void spouseOfSibling(Map<String, Node> family, String fatherName, List<String> result) {
        Node father = family.get(fatherName);
        if (father != null && father.getChildren().size() > 1) {
            for (ChildNode node : father.getChildren()) {
                if (node.getGender() == getOppositeGender(gender) && !family.get(node.getName()).getPartner().equals(NO_RELATIVE)) {
                    result.add(family.get(node.getName()).getPartner());
                }
            }
        }
    }

    private void siblingOfSpouse(Map<String, Node> family, String parther, List<String> result) {
        Node spouse = family.get(parther);
        if (!spouse.getMother().equals(NO_RELATIVE) && family.get(spouse.getMother()).getChildren().size() > 1) {
            for (ChildNode node : family.get(spouse.getMother()).getChildren()) {
                if (node.getGender() == gender) {
                    result.add(node.getName());
                }
            }
        }
    }
}

