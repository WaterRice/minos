/**  

* 创建时间：2019年3月20日 下午12:38:13  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：HackPrintStream.java  

* 类说明：  

*/

package org.wingsOfHope.minos.judge.java.executor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;

public class HackPrintStream extends PrintStream {

	private ThreadLocal<ByteArrayOutputStream> out;

	private ThreadLocal<Boolean> trouble;

	public HackPrintStream() {
		super(new ByteArrayOutputStream());
		out = new ThreadLocal<>();
		trouble = new ThreadLocal<>();
	}

	@Override
	public String toString() {
		return out.get().toString();
	}

	private void ensureOpen() throws IOException {
		if (out.get() == null) {
			out.set(new ByteArrayOutputStream());
		}
	}

	public void flush() {
		try {
			ensureOpen();
			out.get().flush();
		} catch (IOException e) {
			trouble.set(true);
		}
	}

	public void close() {
		try {
			out.get().close();
		} catch (IOException e) {
			trouble.set(true);
		}
		out.remove();
	}

	public boolean checkError() {
		if (out.get() != null)
			flush();
		return trouble.get() != null ? trouble.get() : false;
	}

	protected void setError() {
		trouble.set(true);
	}

	@Override
	protected void clearError() {
		trouble.remove();
	}

	@Override
	public void write(int b) {
		try {
			ensureOpen();
			out.get().write(b);
			if (b == '\n') {
				out.get().flush();
			}
		} catch (InterruptedIOException e) {
			Thread.currentThread().interrupt();
		} catch (IOException e) {
			trouble.set(true);
		}
	}

	@Override
	public void write(byte[] buf, int off, int len) {
		try {
			ensureOpen();
			out.get().write(buf, off, len);
		} catch (InterruptedIOException x) {
			Thread.currentThread().interrupt();
		} catch (IOException x) {
			trouble.set(true);
		}
	}

	private void write(char buf[]) {
		try {
			ensureOpen();
			out.get().write(new String(buf).getBytes());
		} catch (InterruptedIOException x) {
			Thread.currentThread().interrupt();
		} catch (IOException x) {
			trouble.set(true);
		}
	}

	private void write(String s) {
		try {
			ensureOpen();
			out.get().write(s.getBytes());
		} catch (InterruptedIOException x) {
			Thread.currentThread().interrupt();
		} catch (IOException x) {
			trouble.set(true);
		}
	}

	private void newLine() {
		try {
			ensureOpen();
			out.get().write(System.lineSeparator().getBytes());
		} catch (InterruptedIOException x) {
			Thread.currentThread().interrupt();
		} catch (IOException x) {
			trouble.set(true);
		}
	}

	@Override
	public void print(boolean b) {
		write(b ? "true" : "false");
	}

	@Override
	public void print(char c) {
		write(String.valueOf(c));
	}

	@Override
	public void print(int i) {
		write(String.valueOf(i));
	}

	@Override
	public void print(long l) {
		write(String.valueOf(l));
	}

	@Override
	public void print(float f) {
		write(String.valueOf(f));
	}

	@Override
	public void print(double d) {
		write(String.valueOf(d));
	}

	@Override
	public void print(char[] s) {
		write(s);
	}

	@Override
	public void print(String s) {
		if (s == null) {
			s = "null";
		}
		write(s);
	}

	@Override
	public void print(Object obj) {
		write(String.valueOf(obj));
	}

	@Override
	public void println() {
		newLine();
	}

	@Override
	public void println(boolean x) {
		print(x);
		newLine();
	}

	@Override
	public void println(char x) {
		print(x);
		newLine();
	}

	@Override
	public void println(int x) {
		print(x);
		newLine();
	}

	@Override
	public void println(long x) {
		print(x);
		newLine();
	}

	@Override
	public void println(float x) {
		print(x);
		newLine();
	}

	@Override
	public void println(double x) {
		print(x);
		newLine();
	}

	@Override
	public void println(char[] x) {
		print(x);
		newLine();
	}

	@Override
	public void println(String x) {
		print(x);
		newLine();
	}

	@Override
	public void println(Object x) {
		String s = String.valueOf(x);
		print(s);
		newLine();
	}

}
