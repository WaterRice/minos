/**  

* 创建时间：2019年3月20日 下午1:42:30  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：JavaClassExecutor.java  

* 类说明：  

*/

package org.wingsOfHope.minos.judge.java.executor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;

import org.wingsOfHope.minos.judge.java.compiler.StringSourceCodeCompiler;

public class JavaClassExecutor {

	public static String execute(byte[] classByte, String args) throws IOException {
		
//		//重定向系统输入
		InputStream inputStream = new ByteArrayInputStream(args.getBytes());
		
		HackSystem.setIn(inputStream);
		
		ClassModifier cm = new ClassModifier(classByte);
		
		byte[] modifyBytes = cm.modifyUTF8Constant("java/lang/System", "org/wingsOfHope/minos/judge/java/executor/HackSystem");
		
		HotSwapClassLoader classLoader = new HotSwapClassLoader();
		
		Class<?> clazz = classLoader.loadByte(modifyBytes);
		
		try {
			Method main = clazz.getMethod("main", new Class[] {String[].class});
			main.invoke(null, new String[] {null});
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.getCause().printStackTrace(HackSystem.err);
		}
		
		String res = HackSystem.getBufferString();
		HackSystem.closeBuffer();
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<>();
		String code = "import java.util.ArrayList;\r\n" + 
				"import java.util.List;\r\n" + 
				"import java.util.Scanner;\r\n" + 
				"\r\n" + 
				"public class Solution {\r\n" + 
				"	public static void main(String[] args) {\r\n" + 
				"		List<Integer> list = new ArrayList<>();\r\n" + 
				"		Scanner scanner = new Scanner(System.in);\r\n" + 
				"		//String msg = scanner.next();\r\n" + 
				"		//System.out.println(msg);\r\n" + 
				"		//Integer a = scanner.nextInt();\r\n" + 
				"		//System.out.println(a);\r\n" + 
				"		int n = scanner.nextInt();\r\n" + 
				"		System.out.println(n);\r\n" + 
				"		for(int i = 0; i < n; i++) {\r\n" + 
				"			System.out.println(scanner.nextInt());\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"}";
		byte[] result = StringSourceCodeCompiler.compile(code, collector);
		System.out.println(execute(result,"5\n7 8 9 10 7"));
	}
}
