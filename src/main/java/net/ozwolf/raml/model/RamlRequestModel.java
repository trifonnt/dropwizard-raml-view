package net.ozwolf.raml.model;

import org.apache.commons.codec.binary.Hex;
import org.raml.model.MimeType;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class RamlRequestModel {
    private final MimeType mimeType;
    private final List<RamlHeaderModel> headers;

    public RamlRequestModel(MimeType mimeType, List<RamlHeaderModel> headers) {
        this.mimeType = mimeType;
        this.headers = headers;
    }

    public String getId() {
        return Hex.encodeHexString(getContentType().getBytes());
    }

    public String getContentType() {
        return mimeType.getType();
    }

    public List<RamlHeaderModel> getHeaders() {
        return headers;
    }

    public boolean isJson() {
        return getContentType().equals(MediaType.APPLICATION_JSON);
    }

    public String getExample() {
        return mimeType.getExample();
    }

    public String getSchema() {
        return mimeType.getSchema();
    }

    @Override
    public String toString() {
        return String.format("Request = [%s]", getContentType());
    }
}
