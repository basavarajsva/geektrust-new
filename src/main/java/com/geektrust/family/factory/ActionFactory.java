package com.geektrust.family.factory;


import com.geektrust.family.model.Gender;
import com.geektrust.family.service.add.AddChild;
import com.geektrust.family.service.add.AddService;
import com.geektrust.family.service.add.AddSpouse;
import com.geektrust.family.service.get.*;

import java.util.HashMap;
import java.util.Map;

import static com.geektrust.family.constant.Constant.*;

public class ActionFactory {
    private ActionFactory() {
    }

    static Map<String, AddService> addOperationMap = new HashMap<>();
    static Map<String, GetService> getOperationMap = new HashMap<>();

    static {
        addOperationMap.put(ADD_CHILD, new AddChild());
        addOperationMap.put(ADD_SPOUSE, new AddSpouse());
        getOperationMap.put(PATERNAL_UNCLE, new GetPaternalRelation(Gender.MALE));
        getOperationMap.put(MATERNAL_UNCLE, new GetMaternalRelation(Gender.MALE));
        getOperationMap.put(PATERNAL_AUNT, new GetPaternalRelation(Gender.FEMALE));
        getOperationMap.put(MATERNAL_AUNT, new GetMaternalRelation(Gender.FEMALE));
        getOperationMap.put(DAUGHTER, new GetChildren(Gender.FEMALE));
        getOperationMap.put(SON, new GetChildren(Gender.MALE));
        getOperationMap.put(SIBLING, new GetSibling());
        getOperationMap.put(BROTHER_IN_LAW, new GetInLaw(Gender.MALE));
        getOperationMap.put(SISTER_IN_LAW, new GetInLaw(Gender.FEMALE));
    }

    public static AddService getAddOperation(String action) {
        return addOperationMap.get(action);
    }

    public static GetService getGetOperation(String action) {
        return getOperationMap.get(action);

    }
}