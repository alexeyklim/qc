package QuakeChampions.util.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CustomHttpClient {

    private CloseableHttpClient httpClient;

    public CustomHttpClient() {
        super();
        httpClient = HttClientFactory.getClient();
    }

    public HttpResponse httpGetWithAuth(String url, String userName,
                                        String userPassword) {
        Header authHeader = BasicScheme.authenticate(
                new UsernamePasswordCredentials(userName, userPassword),
                "UTF-8", false);
        return httpGet(url, authHeader);
    }

    public HttpResponse httpGet(String url, Header... headers) {
        HttpGet httpGet = new HttpGet(url);
        if (headers != null) {
            for (Header header : headers) {
                httpGet.addHeader(header);
            }
        }
        return executeMethod(httpGet);
    }

    public HttpResponse httpGet(String url, Map<String, String> headers) {
        HttpGet httpGet = new HttpGet(url);
        if (headers != null) {
            for (Entry<String, String> header : headers.entrySet()) {
                httpGet.addHeader(header.getKey(), header.getValue());
            }
        }
        return executeMethod(httpGet);
    }

    public HttpResponse httpPost(String url, String body, Header... headers) {
        HttpPost httpPost = new HttpPost(url);
        if (headers != null) {
            for (Header header : headers) {
                httpPost.addHeader(header);
            }
        }
        StringEntity entity = null;
        try {
            entity = new StringEntity(body);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error during form HTTP POST body " + e.getLocalizedMessage());
        }
        httpPost.setEntity(entity);
        return executeMethod(httpPost);
    }

    public HttpResponse httpPost(String url, String body,
                                 Map<String, String> headers) {
        List<Header> headerList = new ArrayList<Header>();
        for (Entry<String, String> keyValuePair : headers.entrySet()) {
            Header header = new BasicHeader(keyValuePair.getKey(),
                    keyValuePair.getValue());
            headerList.add(header);
        }
        Header[] headerArray = headerList
                .toArray(new Header[headerList.size()]);
        return httpPost(url, body, headerArray);
    }

    public HttpResponse httpPost(String url, Map<String, String> body,
                                 Header... headers) {
        HttpPost httpPost = new HttpPost(url);
        if (headers != null) {
            for (Header header : headers) {
                httpPost.addHeader(header);
            }
        }
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        for (Entry<String, String> parametr : body.entrySet()) {
            urlParameters.add(new BasicNameValuePair(parametr.getKey(),
                    parametr.getValue()));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error during form HTTP POST body " + e.getLocalizedMessage());
        }
        return executeMethod(httpPost);
    }

    public HttpResponse httpPost(String url, Map<String, String> body,
                                 Map<String, String> headers) {
        List<Header> headerList = new ArrayList<Header>();
        for (Entry<String, String> keyValuePair : headers.entrySet()) {
            Header header = new BasicHeader(keyValuePair.getKey(),
                    keyValuePair.getValue());
            headerList.add(header);
        }
        Header[] headerArray = headerList
                .toArray(new Header[headerList.size()]);
        return httpPost(url, body, headerArray);
    }

    public HttpResponse httpPut(String url, String body, Header... headers) {
        HttpPut httpPut = new HttpPut(url);
        if (headers != null) {
            for (Header header : headers) {
                httpPut.addHeader(header);
            }
        }
        StringEntity entity = null;
        try {
            entity = new StringEntity(body);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error during form HTTP PUT body " +e.getLocalizedMessage());
        }
        httpPut.setEntity(entity);
        return executeMethod(httpPut);
    }

    public HttpResponse httpPut(String url, String body,
                                Map<String, String> headers) {
        List<Header> headerList = new ArrayList<Header>();
        for (Entry<String, String> keyValuePair : headers.entrySet()) {
            Header header = new BasicHeader(keyValuePair.getKey(),
                    keyValuePair.getValue());
            headerList.add(header);
        }
        Header[] headerArray = headerList
                .toArray(new Header[headerList.size()]);
        return httpPut(url, body, headerArray);
    }

    public HttpResponse httpDelete(String url, Header... headers) {
        HttpDelete httpDelete = new HttpDelete(url);
        if (headers != null) {
            for (Header header : headers) {
                httpDelete.addHeader(header);
            }
        }
        return executeMethod(httpDelete);
    }

    public HttpResponse httpHead(String url, Header... headers) {
        HttpHead httpHead = new HttpHead(url);
        if (headers != null) {
            for (Header header : headers) {
                httpHead.addHeader(header);
            }
        }
        return executeMethod(httpHead);
    }

    public HttpResponse httpHead(String url, Map<String, String> headers) {
        HttpHead httpHead = new HttpHead(url);
        if (headers != null) {
            for (Entry<String, String> header : headers.entrySet()) {
                httpHead.addHeader(header.getKey(), header.getValue());
            }
        }
        return executeMethod(httpHead);
    }

    private HttpResponse executeMethod(HttpRequestBase request) {
        HttpResponse httpResponse = null;
        try {
            httpClient.close();
        } catch (IOException e) {
            System.out.println("Error during closing http client " +e.getLocalizedMessage());
        }
        httpClient = HttClientFactory.getClient();
        try {
            httpResponse = httpClient.execute(request);
        } catch (IOException e) {
            System.out.println("Error during executing HTTP " + request.getMethod() + e.getLocalizedMessage());
        }
        return httpResponse;
    }

}
