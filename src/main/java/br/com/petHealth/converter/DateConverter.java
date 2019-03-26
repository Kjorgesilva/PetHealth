package br.com.petHealth.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@RequestScoped
@FacesConverter(value="dataConverter", managed=true)
public class DateConverter implements Converter<LocalDateTime>{

	@Override
	public LocalDateTime getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		
		if (value == null || value.isEmpty()) {
            return null;
        }
		
		LocalDateTime ld = null;
		
		try {
			
			DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.US);
			ld = LocalDateTime.parse(value, DATEFORMATTER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return ld;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, LocalDateTime value) {
		
		if (value == null) {
            return null;
        }
		
		System.out.println(value);
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.US);

        String formatDateTime = value.format(formatter);
        
        String replace = formatDateTime.toString().replace("T", " ");

        
		return replace;
		
		
	}

}
