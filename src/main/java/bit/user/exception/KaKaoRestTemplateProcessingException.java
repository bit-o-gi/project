package bit.user.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

public class KaKaoRestTemplateProcessingException extends JsonProcessingException {
    public KaKaoRestTemplateProcessingException(String msg) {
        super(msg);
    }
}
