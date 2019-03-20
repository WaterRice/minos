/**  

* 创建时间：2019年3月20日 下午12:36:17  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：HackSystem.java  

* 类说明：  

*/

package org.wingsOfHope.minos.judge.java.executor;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.channels.Channel;
import java.util.Properties;

public class HackSystem {

	private HackSystem() {
	}

	public final static InputStream in = System.in;

	public final static PrintStream out = new HackPrintStream();

	public final static PrintStream err = out;

	public static String getBufferString() {
		return out.toString();
	}

	public static void closeBuffer() {
		out.close();
	}

	private static volatile SecurityManager securityManager = null;

	public static void setIn(InputStream in) {
		throw new SecurityException("no access to System.setIn()!");
	}

	public static void setOut(PrintStream out) {
		throw new SecurityException("no access to System.setOut()!");
	}

	public static void setErr(PrintStream err) {
		throw new SecurityException("no access to System.setErr()!");
	}

	public static Console console() {
		throw new SecurityException("no access to System.console()!");
	}

	public static Channel inheritedChannel() throws IOException {
		throw new SecurityException("no access to System.inheritedChannel()!");
	}

	public static void setSecurityManager(final SecurityManager s) {
		throw new SecurityException("no access to System.setSecurityManager()!");
	}

	public static SecurityManager getSecurityManager() {
		throw new SecurityException("no access to System.getSecurityManager()!");
	}

	public static long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	public static long nanoTime() {
		return System.nanoTime();
	}

	public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
		System.arraycopy(src, srcPos, dest, destPos, length);
	}

	public static int identityHashCode(Object x) {
		return System.identityHashCode(x);
	}

	public static Properties getProperties() {
		throw new SecurityException("no access to System.getProperties()!");
	}

	public static String lineSeparator() {
		return System.lineSeparator();
	}

	public static void setProperties(Properties props) {
		throw new SecurityException("no access to System.setProperties()!");
	}

	public static String getProperty(String key) {
		throw new SecurityException("no access to System.getProperty()!");
	}

	public static String getProperty(String key, String def) {
		throw new SecurityException("no access to System.getProperty()!");
	}

	public static String setProperty(String key, String value) {
		throw new SecurityException("no access to System.setProperty()!");
	}

	public static String clearProperty(String key) {
		throw new SecurityException("no access to System.clearProperty()!");
	}

	public static String getenv(String name) {
		throw new SecurityException("no access to System.getenv()!");
	}

	public static java.util.Map<String, String> getenv() {
		throw new SecurityException("no access to System.getenv()!");
	}

	public static void exit(int status) {
		throw new SecurityException("no access to System.exit()!");
	}

	public static void gc() {
		throw new SecurityException("no access to System.gc()!");
	}

	public static void runFinalization() {
		throw new SecurityException("no access to System.runFinalization()!");
	}

	@Deprecated
	public static void runFinalizersOnExit(boolean value) {
		throw new SecurityException("no access to System.runFinalizersOnExit()!");
	}

	public static void load(String filename) {
		throw new SecurityException("no access to System.load()!");
	}

	public static void loadLibrary(String libname) {
		throw new SecurityException("no access to System.loadLibrary()!");
	}

	public static String mapLibraryName(String libname) {
		throw new SecurityException("no access to System.mapLibraryName()!");
	}
}
