package QuakeChampions.util.httpclient;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttClientFactory {

    private HttClientFactory(){
        super();
    }

    public static CloseableHttpClient getClient() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        // If there properties for proxy, use proxy in http client.
//        if (!StringUtils.isEmpty(Config.getInstance().getHttpClientProxyHost()) && !StringUtils.isEmpty(Config.getInstance().getHttpClientProxyPort())) {
//            HttpHost targetHost = new HttpHost(Config.getInstance().getHttpClientProxyHost(), Integer.valueOf(Config.getInstance().getHttpClientProxyPort()), "http");
//            builder.setProxy(targetHost);
//        }
        return builder.build();
    }
}
