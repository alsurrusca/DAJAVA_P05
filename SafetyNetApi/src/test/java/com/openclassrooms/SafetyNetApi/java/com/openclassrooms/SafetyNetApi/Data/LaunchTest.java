package com.openclassrooms.SafetyNetApi.Data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.data.LaunchJson;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class LaunchTest {

    @Test
    public void launchTest() throws IOException {
        LaunchJson launchJson = new LaunchJson();
        ObjectMapper objectMapper = new ObjectMapper();

        Data data = objectMapper.readValue(new File("src/main/resources/data.json"), Data.class);

        launchJson.launchJson();
        assertNotNull(data.toString());
    }


}
