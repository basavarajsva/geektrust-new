package com.geektrust.family.service;

import com.geektrust.family.GeekTrust;
import com.geektrust.family.factory.ActionFactory;
import com.geektrust.family.model.Node;
import com.geektrust.family.service.add.AddService;
import com.geektrust.family.service.get.GetService;

import java.io.*;
import java.util.Map;

import static com.geektrust.family.constant.Constant.INPUT_FILE;

public class FileReader {

    public void readFileAndAction(Map<String, Node> familyTree, boolean isCommaSeparated, String filePath) throws IOException {
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;

        if (isCommaSeparated) {
            inputStream = GeekTrust.class.getResourceAsStream("/" + INPUT_FILE);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        } else {
            inputStream = new FileInputStream(filePath);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        String lines;
        while ((lines = bufferedReader.readLine()) != null) {
            String[] line = getActionAndMember(lines, isCommaSeparated);
            if (line.length == 4) {
                AddService addService = ActionFactory.getAddOperation(line[0]);
                addService.addMember(line[1], line[2], line[3], familyTree);
            } else if (line.length == 3) {
                GetService getService = ActionFactory.getGetOperation(line[2]);
                getService.getRelation(line[1], familyTree);
            }
        }
        inputStream.close();
        bufferedReader.close();
    }

    private String[] getActionAndMember(String sc, boolean isCommaSaperated) {
        if (isCommaSaperated) {
            return sc.split(",");
        } else {
            return sc.split(" ");
        }
    }
}
