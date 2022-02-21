/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 17, 2022
 */
package controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author sunga
 *
 */
@Converter(autoApply = true)
public class LocalDateAttritubeConverter implements AttributeConverter<LocalDate, Date> {
	
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
	// TODO Auto-generated method stub
	return (attribute == null ? null : Date.valueOf(attribute));
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date dbData){
	// TODO Auto-generated method stub
	return (dbData == null ? null : dbData.toLocalDate());
	}

}
