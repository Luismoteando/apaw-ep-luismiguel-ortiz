package es.upm.miw.apaw_ep_themes.documents;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Claim {

    @Id
    private String id;

    private String message;

    private LocalDateTime localDateTime;

    boolean processed;

    public Claim(String message) {
        this.message = message;
        this.localDateTime = LocalDateTime.now();
        this.processed = false;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", localDateTime=" + localDateTime +
                ", processed=" + processed +
                '}';
    }
}
