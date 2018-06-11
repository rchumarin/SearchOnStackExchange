package io.piano.sender;

import io.piano.response.StackResponse;
import io.piano.util.JacksonObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

/**
 * Implementation REST Client
 */
@Service
public class RestSenderImpl implements RestSender {

    private static Logger Logger = LogManager.getLogger(RestSenderImpl.class);

    private CloseableHttpClient httpclient = HttpClients.createDefault();

    @Override
    public StackResponse sendRequest(String absoluteUri) {
        StackResponse resp = null;
        if (Objects.nonNull(absoluteUri)) {
            HttpGet httpget = new HttpGet(absoluteUri);
            try (CloseableHttpResponse response = httpclient.execute(httpget)) {
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new IOException(EntityUtils.toString(response.getEntity()));
                }
                resp = JacksonObjectMapper.parseJson(EntityUtils.toString(response.getEntity()), StackResponse.class);
            } catch (Exception ex) {
                Logger.error("[SEND REST REQUEST] Error", ex);
            }
        }
        return resp;
    }
}
