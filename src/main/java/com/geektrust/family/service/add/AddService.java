package com.geektrust.family.service.add;

import com.geektrust.family.model.Node;

import java.util.Map;

public interface AddService {
    void addMember(String member1, String member2, String gender, Map<String, Node> family);
}
