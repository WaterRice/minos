/**  

* 创建时间：2019年3月20日 下午12:16:21  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：HotSwapClassLoader.java  

* 类说明：  

*/

package org.wingsOfHope.minos.judge.java.executor;

public class HotSwapClassLoader extends ClassLoader {

	public HotSwapClassLoader() {
		super(HotSwapClassLoader.class.getClassLoader());
	}

	public Class<?> loadByte(byte[] classBytes) {
		return defineClass(null, classBytes, 0, classBytes.length);
	}
}
