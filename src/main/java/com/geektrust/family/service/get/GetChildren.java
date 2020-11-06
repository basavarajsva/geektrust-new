package com.geektrust.family.service.get;

import com.geektrust.family.helper.PrintResult;
import com.geektrust.family.model.ChildNode;
import com.geektrust.family.model.Gender;
import com.geektrust.family.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geektrust.family.constant.Constant.PERSON_NOT_FOUND;

public class GetChildren implements GetService {
    private Gender childGender;

    public GetChildren(Gender gender) {
        childGender = gender;
    }

    @Override
    public void getRelation(String member, Map<String, Node> family) {
        List<String> daughter = new ArrayList<>();
        Node person = family.get(member);
        if (person != null) {
            if (!person.getChildren().isEmpty()) {
                List<ChildNode> childNodes = person.getChildren();
                for (ChildNode c : childNodes) {
                    if (c.getGender() == childGender) {
                        daughter.add(c.getName());
                    }
                }
            }
        } else {
            System.out.println(PERSON_NOT_FOUND);
            return;
        }
        PrintResult.printResult(daughter);
    }
}
