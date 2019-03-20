/**  

* 创建时间：2019年3月20日 上午10:17:59  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：ClassModifer.java  

* 类说明：  

*/

package org.wingsOfHope.minos.judge.java.executor;

import org.wingsOfHope.minos.utils.ByteUtils;

public class ClassModifier {

	/*
	 * 常量池的起始偏移
	 */
	private static final int CONSTANT_POOL_COUNT_INDEX = 8;

	/*
	 * CONSTANT_UTF8_INFO常量的tag
	 */
	private static final int CONSTANT_UTF8_INFO = 1;

	private static final int[] CONSTANT_ITEM_LENGTH = { -1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5 };

	private static final int u1 = 1;

	private static final int u2 = 2;

	private byte[] classByte;

	public ClassModifier(byte[] classByte) {
		this.classByte = classByte;
	}

	public int getConstantPoolCount() {
		return ByteUtils.byte2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
	}

	public byte[] modifyUTF8Constant(String oldStr, String newStr) {
		int cpc = getConstantPoolCount();
		int offset = CONSTANT_POOL_COUNT_INDEX + u2;
		for (int i = 1; i < cpc; i++) {
			int tag = ByteUtils.byte2Int(classByte, offset, u1);
			if (tag == CONSTANT_UTF8_INFO) {
				int len = ByteUtils.byte2Int(classByte, offset + u1, u2);
				offset += u1 + u2;
				String str = ByteUtils.byte2String(classByte, offset, len);
				if (str.equals(oldStr)) {
					byte[] strReplaceBytes = ByteUtils.string2Byte(newStr);
					byte[] intReplaceBytes = ByteUtils.int2Byte(strReplaceBytes.length, u2);
					classByte = ByteUtils.byteReplace(classByte, offset - u2, u2, intReplaceBytes);
					classByte = ByteUtils.byteReplace(classByte, offset, len, strReplaceBytes);
					return classByte;
				} else {
					offset += len;
				}
			} else {
				offset += CONSTANT_ITEM_LENGTH[tag];
			}
		}
		return classByte;
	}

}
