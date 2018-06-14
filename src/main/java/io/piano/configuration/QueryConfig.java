package io.piano.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Search query configuration
 */
@Configuration
@ConfigurationProperties("queryconfig")
public class QueryConfig {

    private String host;
    private Boolean useSsl;
    private String api;
    private String order;
    private String sort;
    private String site;

    public String getHost() {
        return host;
    }

    public Boolean getUseSsl() {
        return useSsl;
    }

    public void setUseSsl(Boolean useSsl) {
        this.useSsl = useSsl;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getRequestUri() {
        String protocol = getUseSsl() ? "https" : "http";
        return String.format("%s://%s/%s/search?order=%s&sort=%s&site=%s&intitle=", protocol, host, api, order, sort, site);
    }
}
