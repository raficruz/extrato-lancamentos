package tk.raficruz.datamanager.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

@Converter
public class StringArrayToStringConverter implements AttributeConverter<List<String>,String>{

	@Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return attribute == null ? null : StringUtils.join(attribute,",");
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return new ArrayList<>();
        }

        Stream<String> stream = Arrays.stream(dbData.split(","));
        return stream.collect(Collectors.toList());
    }
}
