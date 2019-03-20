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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;

import org.wingsOfHope.minos.judge.java.compiler.StringSourceCodeCompiler;

public class JavaClassExecutor {

	public static String execute(byte[] classByte) {
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
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
				"\r\n" + 
				"public class Solution {\r\n" + 
				"	public static void main(String[] args) {\r\n" + 
				"		List<Integer> list = new ArrayList<>();\r\n" + 
				"		System.out.println(\"hello, please compile me.\");\r\n" + 
				"	}\r\n" + 
				"}";
		byte[] result = StringSourceCodeCompiler.compile(code, collector);
		System.out.println(execute(result));
	}
}
