package ir.erfangharib.personal_finance_manager;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest request, ErrorAttributeOptions options) {
        Map<String, Object> attributes = super.getErrorAttributes(request, options);
        long timestamp = System.currentTimeMillis();

        attributes.put("timestamp", timestamp);
        attributes.remove("trace");
        attributes.remove("error");
        attributes.remove("path");

        return attributes;
    }

}
