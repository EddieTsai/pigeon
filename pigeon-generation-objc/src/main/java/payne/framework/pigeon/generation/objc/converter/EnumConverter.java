package payne.framework.pigeon.generation.objc.converter;

import java.util.HashSet;
import java.util.Set;

import payne.framework.pigeon.generation.Generator;
import payne.framework.pigeon.generation.annotation.Name;

public class EnumConverter extends ObjectiveCConverter {

	@Override
	protected boolean supports(Class<?> clazz) {
		return clazz.isEnum();
	}

	@Override
	protected boolean generable(Class<?> clazz) {
		return true;
	}

	@Override
	protected String convert(Class<?> clazz) {
		if (supports(clazz)) {
			return (clazz.isAnnotationPresent(Name.class) ? clazz.getAnnotation(Name.class).value() : clazz.getSimpleName());
		}
		return super.convert(clazz);
	}

	@Override
	protected String convert(Class<?> clazz, String name) {
		return "@(" + name + ")";
	}

	@Override
	protected Set<Class<?>> imports(Generator fg, Class<?> clazz) {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(clazz);
		return classes;
	}

}
