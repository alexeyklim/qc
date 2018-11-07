package QuakeChampions.util.httpclient;

import QuakeChampions.json.JsonParserHelper;
import com.google.gson.JsonElement;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;

public class HttpResponseFacade {

    HttpResponse wrapedResponse;

    public HttpResponseFacade(HttpResponse response) {
        wrapedResponse = response;
    }

    public String getHeaderValue(String headerName) {
        Header header = wrapedResponse.getFirstHeader(headerName);
        return header.getValue();
    }

    public int getResponseStatusCode() {
        return wrapedResponse.getStatusLine().getStatusCode();
    }

    public JsonElement getJsonFromResponse() {
        try {
            InputStream is = wrapedResponse.getEntity().getContent();
            return JsonParserHelper.getInstance().getJsonFromInputStream(is);
        } catch (IOException e) {
            System.out.println("There were an error during taking JSON from response " + e.getLocalizedMessage());
            return null;
        }
    }
}
