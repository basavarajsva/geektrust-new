package com.geektrust.family.service.get;

import com.geektrust.family.model.Node;

import java.util.Map;

public interface GetService {

    void getRelation(String member, Map<String, Node> family);
}
