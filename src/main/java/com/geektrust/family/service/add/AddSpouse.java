package com.geektrust.family.service.add;

import com.geektrust.family.constant.Constant;
import com.geektrust.family.model.Gender;
import com.geektrust.family.model.Node;

import java.util.Map;

import static com.geektrust.family.constant.Constant.SPOUSE_ADDITION_FAILED;
import static com.geektrust.family.constant.Constant.SPOUSE_ADDITION_SUCCEEDED;

public class AddSpouse extends AddMember {

    @Override
    public void addMember(String partner1, String partner2, String gender, Map<String, Node> family) {
        Node partnerNode = family.get(partner1);
        if (partnerNode != null && !partnerNode.getGender().toString().equalsIgnoreCase(gender) && partnerNode.getPartner().trim().equals(Constant.NO_RELATIVE)) {
            Node spouse = new Node(getGender(gender), Constant.NO_RELATIVE, Constant.NO_RELATIVE, partner1);
            partnerNode.setPartner(partner2);
            family.put(partner2, spouse);
            log(SPOUSE_ADDITION_SUCCEEDED);
        } else {
            log(SPOUSE_ADDITION_FAILED);
        }
    }

    public Gender getGender(String gender) {
        if (gender.trim().equalsIgnoreCase(Constant.FEMALE)) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }

    private void log(String message) {
        if (isIsLoggingEnabled()) {
            System.out.println(message);
        }
    }
}
