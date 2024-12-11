package title;

import org.springframework.stereotype.Component;

@Component

public class MyJsonParser {

    @Log
    public String parse() {
        // Parse logic
        return "Parse JSON";

    }
}
