public class MyJudger {

    static {
        System.loadLibrary("judger");
    }

    public native void myexec(String code, long questionId, int languageCode, long runId, int timeLim, int memLim);

    public static void main(String[] args) {
        MyJudger judger = new MyJudger();
        judger.myexec("", 1000, 3, 2, 1, 128);
        System.out.println(System.getProperty("java.library.path"));
    }
}
/// mnt/e/myProgram/c/demo/judger/jni/java