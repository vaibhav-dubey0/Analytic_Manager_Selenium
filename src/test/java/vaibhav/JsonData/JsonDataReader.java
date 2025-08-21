package vaibhav.JsonData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {
 public List<HashMap<String, Object>> readData(String filePath) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                new File(filePath),
                new TypeReference<List<HashMap<String, Object>>>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(new HashMap<>());
        }
    }
}

