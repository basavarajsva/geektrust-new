package com.geektrust.family;

import com.geektrust.family.service.Family;
import com.geektrust.family.service.FileReader;
import com.geektrust.family.service.add.AddMember;

import java.io.IOException;

import static com.geektrust.family.constant.Constant.INPUT_FILE;

public class GeekTrust {

    public static void main(String[] args) throws IOException {
        Family family = new Family();
        family.populateRelation();
        FileReader fileReader = new FileReader();
        AddMember.setIsLoggingEnabled(false);
        fileReader.readFileAndAction(family.getFamilyTree(), true, INPUT_FILE);
        AddMember.setIsLoggingEnabled(true);
        fileReader.readFileAndAction(family.getFamilyTree(), false, args[0]);

    }
}
