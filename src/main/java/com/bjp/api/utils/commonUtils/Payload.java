package com.bjp.api.utils.commonUtils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.time.LocalDateTime.now;
import static java.util.Base64.getEncoder;

@Service
@Slf4j
public class Payload {

    private static final Gson gson = new Gson();
    public static final String IMAGE_BASE64_FORMAT = "data:image/png;base64,";


    public static Function<byte[],String> byteToBase64=(byteArr)-> {
        try {
            return IMAGE_BASE64_FORMAT.concat(getEncoder().encodeToString(byteArr));
        } catch (Exception ex) {
            ex.getStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    };


    private static Map<String, Object> dataStatus(@NonNull Object message, @NonNull int code) {
        try {
            return Map.of("message", message, "status", code, "timestamp", now().toString());
        } catch (Exception ex) {
            ex.getStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static String response(Object data, String message, int code) {
        try {
            Map<String, Object> result = new HashMap<>();
            result.put("Payload", data);
            result.put("DataStatus", dataStatus(message, code));
            return gson.toJson(result);
        } catch (Exception ex) {
            ex.getStackTrace();
            log.error(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
