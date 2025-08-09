package springbootassi2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigValues {

    @Value("${app.config.integer-value}")
    private Integer integerValue;

    @Value("${app.config.decimal-value}")
    private Double decimalValue;

    @Value("${app.config.boolean-value}")
    private Boolean booleanValue;

    public void display() {
        System.out.println("Integer value: " + integerValue);
        System.out.println("Decimal value: " + decimalValue);
        System.out.println("Boolean value: " + booleanValue);
    }
}
