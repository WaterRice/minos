/**  

* 创建时间：2019年3月19日 下午7:56:45  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：StringSourceCodeCompiler.java  

* 类说明：  

*/

package org.wingsOfHope.minos.judge.java.compiler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaFileObject.Kind;

public class StringSourceCodeCompiler {

	private static ConcurrentHashMap<String, MyJavaFileObject> javaFileObjectMap = new ConcurrentHashMap<>();

	private static final Pattern pattern = Pattern.compile("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s*");

	@SuppressWarnings("resource")
	public static byte[] compile(String sourceCode, DiagnosticCollector<JavaFileObject> compileCollector)
			throws Exception {

		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		JavaFileManager javaFileManager = new MyJavaFileManager(
				javaCompiler.getStandardFileManager(compileCollector, null, null));

		Matcher matcher = pattern.matcher(sourceCode);
		String className;
		if (matcher.find()) {
			className = matcher.group(1);
		} else {
			return null;
		}

		JavaFileObject javaFileObject = new MyJavaFileObject(className, sourceCode);

		boolean result = javaCompiler
				.getTask(null, javaFileManager, compileCollector, null, null, Arrays.asList(javaFileObject)).call();

		MyJavaFileObject fileObject = javaFileObjectMap.get(className);

		if (result && fileObject != null) {
			return fileObject.getBytes();
		}
		return null;
	}

	/*
	 * 实现自己的JavaFileObject类,为了: 1.动态编译的对象不是文件而是字符串 2.动态编译后的结果不是class文件,而是对应的字节码流
	 */
	private static class MyJavaFileObject extends SimpleJavaFileObject {

		private String source;

		private ByteArrayOutputStream outputStream;

		/*
		 * 构造用来存放字符串格式的源代码JavaFileObject
		 */
		public MyJavaFileObject(String name, String source) {
			super(URI.create("String:///" + name + Kind.SOURCE.extension), Kind.SOURCE);
			this.source = source;
		}

		/*
		 * 构造用来存放编译后的字节码的JavaFileObject
		 */
		public MyJavaFileObject(String name, Kind kind) {
			super(URI.create("String:///" + name + Kind.SOURCE.extension), kind);
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
			return source;
		}

		@Override
		public OutputStream openOutputStream() throws IOException {
			outputStream = new ByteArrayOutputStream();
			return outputStream;
		}

		public byte[] getBytes() {
			return outputStream.toByteArray();
		}

	}

	/*
	 * 实现自己的JavaFileManager类,从而对JavaFileObject进行管理
	 */
	private static class MyJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {

		/**
		 * 
		 * @param fileManager
		 *
		 */
		protected MyJavaFileManager(JavaFileManager fileManager) {
			super(fileManager);
		}

		@Override
		public JavaFileObject getJavaFileForInput(Location location, String className, Kind kind) throws IOException {

			JavaFileObject javaFileObject = javaFileObjectMap.get(className);

			if (javaFileObject == null) {
				return super.getJavaFileForInput(location, className, kind);
			}

			return javaFileObject;
		}

		@Override
		public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
				throws IOException {

			MyJavaFileObject javaFileObject = new MyJavaFileObject(className, kind);

			javaFileObjectMap.put(className, javaFileObject);

			return javaFileObject;
		}

	}

	public static void main(String[] args) throws Exception {

		DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<>();
		String code = "import java.util.ArrayList;\r\n" + "import java.util.List;\r\n" + "\r\n"
				+ "public class Solution {\r\n" + "	public static void main(String[] args) {\r\n"
				+ "		List<Integer> list = new ArrayList<>();\r\n"
				+ "		System.out.println(\"hello, please compile me.\");\r\n" + "	}\r\n" + "}";
		byte[] result = compile(code, collector);
		System.out.println(new String(result));
	}
}
