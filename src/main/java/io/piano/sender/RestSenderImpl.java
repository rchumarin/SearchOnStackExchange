package io.piano.sender;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.piano.dto.StackDto;
import io.piano.model.StackExchange;
import io.piano.model.StackResult;
import io.piano.response.StackResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation REST Client
 */
@Service
public class RestSenderImpl implements RestSender {

    private static Logger Logger = LogManager.getLogger(RestSenderImpl.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    private CloseableHttpClient httpclient = HttpClients.createDefault();

    @Override
    public String sendRequest(String absoluteUri) {
        String jsonData = null;
        if (Objects.nonNull(absoluteUri)) {
            HttpGet httpget = new HttpGet(absoluteUri);
            try (CloseableHttpResponse response = httpclient.execute(httpget)) {
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new IOException(EntityUtils.toString(response.getEntity()));
                }
                List<StackDto> list = getStackDto(response);
                StackResponse resp = new StackResponse(list);
                jsonData = objectMapper.writeValueAsString(resp);
            } catch (Exception ex) {
                Logger.error("[SEND REST REQUEST] Error", ex);
            }
        }
        return jsonData;
    }

    private List<StackDto> getStackDto(CloseableHttpResponse response) throws IOException {
        StackResult result = objectMapper.readValue(EntityUtils.toString(response.getEntity()), StackResult.class);

        List<StackDto> list = new ArrayList<>(5);
        for (StackExchange stack : result.getItems()) {
            StackDto stackDto = new StackDto();
            stackDto.setAnswerCount(stack.getAnswer_count());
            stackDto.setDate(stack.getCreation_date());
            stackDto.setAuthor(stack.getOwner().getDisplay_name());
            stackDto.setTitle(stack.getTitle());
            stackDto.setLink(stack.getLink());

            list.add(stackDto);
        }
        return list;
    }
}