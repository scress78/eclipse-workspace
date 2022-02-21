/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 17, 2022
 */
package controller;


import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
/**
 * @author sunga
 *
 */
@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time> {
	
	@Override
	public Time convertToDatabaseColumn(LocalTime attribute) {
	// TODO Auto-generated method stub
	return (attribute == null ? null :
	Time.valueOf(attribute));
	}
	
	@Override
	public LocalTime convertToEntityAttribute(Time dbData){
	// TODO Auto-generated method stub
	return (dbData == null ? null :
	dbData.toLocalTime());
	}
}
