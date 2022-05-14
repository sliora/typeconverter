package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @Test
    void stringToInteger() {
        StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();
        Integer convert = stringToIntegerConverter.convert("10");
        Assertions.assertThat(convert).isEqualTo(10);
    }

    @Test
    void integerToString() {
        IntegerToStringConverter integerToStringConverter = new IntegerToStringConverter();
        String convert = integerToStringConverter.convert(10);
        Assertions.assertThat(convert).isEqualTo("10");
    }

    @Test
    void stringToIpPort() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(ipPort);
        Assertions.assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    @Test
    void ipPortTosString() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

}
