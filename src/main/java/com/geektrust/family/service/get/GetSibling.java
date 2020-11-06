package com.geektrust.family.service.get;

import com.geektrust.family.helper.PrintResult;
import com.geektrust.family.model.ChildNode;
import com.geektrust.family.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.geektrust.family.constant.Constant.PERSON_NOT_FOUND;

public class GetSibling implements GetService {
    @Override
    public void getRelation(String member, Map<String, Node> family) {
        List<String> siblings = new ArrayList<>();
        List<ChildNode> childNodes = new ArrayList<>();
        Node person = family.get(member);
        if (person != null) {
            Node mother = family.get(person.getMother());
            if (mother != null) {
                childNodes = mother.getChildren();
            }
            for (ChildNode c : childNodes) {
                siblings.add(c.getName());
            }
        } else {
            System.out.println(PERSON_NOT_FOUND);
            return;
        }
        siblings.remove(member);
        PrintResult.printResult(siblings);
    }
}
