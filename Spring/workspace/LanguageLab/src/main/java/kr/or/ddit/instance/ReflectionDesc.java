package kr.or.ddit.instance;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import kr.or.ddit.reflection.obj.DabakBungeoppangzip;

/**
 * ClassA instanceA = new ClassA();
 * ClassA instanceB = new ClassA();
 * 
 * 1. ClassLoader 가 ClassA.class 파일을 클래스 패스에서 검색하고, 
 * 해당 클래스 정보를 메모리에 저장함
 * 2. 1번 단계에서 저장된 클래스 정보를 기반으로 인스턴스를 생성하고, 메모리에 저장함
 * 3. 2번 단계에서 생성하고 저장된 인스턴스의 참조주소를 instanceA 라는 변수에 저장함
 * 
 * 리플렉션이란?
 * 	: 일반적인 객체 생성 과정을 거치지 않고 획득한 인스턴스를 대상으로,
 *	  해당 인스턴스의 타입(클래스), 상태 정보(프로퍼티), 행동 정보(메소드)를 찾아가는 작업
 *	  java.reflect 패키지의 API 가 지원됨
 */
public class ReflectionDesc {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException {
		Object instance = DabakBungeoppangzip.buyBungeoppang();
		Class instanceType = instance.getClass();
		System.out.printf("%s\n", instanceType.getName());
		System.out.println("=========================상태 정보 리플렉션=========================");
		Field[] fields = instanceType.getDeclaredFields();
		for(Field fld : fields) {
			String modfiers = Modifier.toString(fld.getModifiers());
			Class fldType = fld.getType();
			String fldName = fld.getName();
			System.out.printf("%s %s %s;\n", modfiers, fldType.getSimpleName(), fldName);
		}
		
		System.out.println("=========================행동 정보 리플렉션=========================");
		Method[] methods = instanceType.getDeclaredMethods();
		for(Method mtd : methods) {
			String modfiers = Modifier.toString(mtd.getModifiers());
			Class returnType = mtd.getReturnType();
			String mtdName = mtd.getName();
			Class[] paramTypes = mtd.getParameterTypes();
			System.out.printf("%s %s %s(%s);\n", modfiers, returnType.getSimpleName(), mtdName, Arrays.toString(paramTypes));
		}
		
		System.out.println("=========================프로퍼티 정보 리플렉션=========================");
		for(Field fld : fields) {
			String fldName = fld.getName();
			try {
				PropertyDescriptor pd = new PropertyDescriptor(fldName, instanceType);
				Method getter = pd.getReadMethod();
				Method setter = pd.getWriteMethod();
				Object value = getter.invoke(instance);
				System.out.printf("%s = %s;\n", fldName, value);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("=========================슈붕 만들기=========================");
		Object newBungeoppang = instanceType.newInstance();
		for(Field fld : fields) {
			String fldName = fld.getName();
			try {
				PropertyDescriptor pd = new PropertyDescriptor(fldName, instanceType);
				Method getter = pd.getReadMethod();
				Method setter = pd.getWriteMethod();
				Object value = getter.invoke(instance); // invoke 실행시키는 메서드
				setter.invoke(newBungeoppang, value); //b.setFishType(a.getFishType);
				System.out.printf("%s = %s;\n", fldName, value);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(newBungeoppang);
		PropertyDescriptor pd1 = new PropertyDescriptor("fishType", instanceType);
		pd1.getWriteMethod().invoke(newBungeoppang, "붕어");
		PropertyDescriptor pd2 = new PropertyDescriptor("ppangso", instanceType);
		pd2.getWriteMethod().invoke(newBungeoppang, "슈크림");
		System.out.println(newBungeoppang);
	}
}
