package br.com.wryel.util;

import java.lang.reflect.Field;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;

public class JPAUtils {
	
	public static Object getPrimaryKey(Object object) {
		
		Field[] fields = object.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				try {
					Object primatyKey = field.get(object);
					return primatyKey;
				} catch (Exception e) {
					return null;
				}
			}
		}
		
		return null;
	}
}
