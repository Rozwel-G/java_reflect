package com.reol.code.testing.codeTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class FunctionAndParam {
	private static final String CIRCLE = "Circle";
	private static final String RECTANGLE = "Rectangle";
	private static final String PERIMETER = "Perimeter";
	private static final String AREA = "Area";
	public static void main(String args[]) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DrawFunc circlePerimeter = DrawFunc.builder().shape(CIRCLE).methodName(PERIMETER).radius(5).length(3).width(2).build();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Context.xml");
		
		Object inputParmes = context.getBean(circlePerimeter.getShape());
		Class<?> circleClass = inputParmes.getClass();
		switch (circlePerimeter.getShape()) {
		case CIRCLE:
			Method setMethod = circleClass.getMethod(new StringBuilder("set").append("Radius").toString(), Integer.class);
			setMethod.invoke(inputParmes, circlePerimeter.getRadius());
			break;
		case RECTANGLE:
			Method setLengthMethod = circleClass.getMethod(new StringBuilder("set").append("Length").toString(), Integer.class);
			setLengthMethod.invoke(inputParmes, circlePerimeter.getLength());
			Method setWidthMethod = circleClass.getMethod(new StringBuilder("set").append("Width").toString(), Integer.class);
			setWidthMethod.invoke(inputParmes, circlePerimeter.getWidth());
		default:
			break;
		}
		
		Object shape = context.getBean(new StringBuilder("Calculate").append(circlePerimeter.getShape()).toString());
		Class<?> shapeClasss = shape.getClass();
		Method[] methods = shapeClasss.getMethods();
		
		Map<String, Method> shapeMethod = Arrays.stream(methods).collect(Collectors.toMap(Method::getName, method->method,(k1,k2)->k1));
		Method method = shapeMethod.get(new StringBuilder(toLowerCase(circlePerimeter.getShape())).append(circlePerimeter.getMethodName()).toString());
		System.out.println(method.invoke(shape, inputParmes));
		
	}
	private static String toLowerCase(String shape) {
		return shape.substring(0,1).toLowerCase()+shape.substring(1);
	}

}
