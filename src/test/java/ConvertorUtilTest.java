import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConvertorUtilTest {
    int[][] celsiusFahrenheitMapping = new int[][] {{10, 50}, {40, 104}, {0, 32}};

    static int[][] data(){
        return new int[][] {{10, 50}, {40, 104}, {0, 32}};
    }
    @TestFactory
    Stream<DynamicTest>
    ensureThatCelsiumConvertsToFahrenheit(){
        ConvertorUtil convertor = new ConvertorUtil();
        return Arrays.stream(celsiusFahrenheitMapping)
                .map(entry -> {
                    int celsius = entry[0];
                    int fahrenheit = entry[1];
                    return dynamicTest(celsius + " Celsius are " + fahrenheit + " Fahrenheit",
                            () -> {
                        assertEquals(fahrenheit, convertor.convertCelsiusToFahrenheit(celsius));
                            });
                });
    }
    @TestFactory
    Stream<DynamicTest>
    ensureThatFahrenheitToCelsiumConverts(){
        ConvertorUtil convertor = new ConvertorUtil();
        return Arrays.stream(celsiusFahrenheitMapping)
                .map(entry -> {
                    int celsius = entry[0];
                    int fahrenheit = entry[1];
                    return dynamicTest(celsius + " Celsius are " + fahrenheit,
                            () -> {
                        assertEquals(celsius, convertor.convertFahrenheitToCelsius(fahrenheit));
                            });
                });
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void ensureThatCelsiumConvertsToFahrenheit2(int[] data){
        ConvertorUtil convertorUtil = new ConvertorUtil();
        int celsius = data[0];
        int fahrenheit = data[1];
        assertEquals(celsius, convertorUtil.convertFahrenheitToCelsius(fahrenheit));
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void ensureThatFahrenheitToCelsiumConverts2(int[] data){
        ConvertorUtil convertorUtil = new ConvertorUtil();
        int celsius = data[0];
        int fahrenheit = data[1];
        assertEquals(fahrenheit, convertorUtil.convertCelsiusToFahrenheit(celsius));
    }
    
}
