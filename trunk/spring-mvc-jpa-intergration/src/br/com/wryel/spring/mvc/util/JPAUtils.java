package br.com.wryel.spring.mvc.util;

import java.lang.reflect.Field;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;

public class JPAUtils {
	
	public static Object getKey(Object bean) {
		
		Field[] fields = bean.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class)) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				try {
					Object primatyKey = field.get(bean);
					return primatyKey;
				} catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
		}
		
		return null;
	}
}
