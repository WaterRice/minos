#include "MyJudger.h"
#include "myexec.h"

JNIEXPORT void JNICALL Java_MyJudger_myexec(JNIEnv *, jobject,
                                            jlong qid, jint lcode, jlong rid,
                                            jint time_lim, jint mem_lim)
{
    printf("hello, jni\n");
    myexecl(qid, lcode, rid, time_lim, mem_lim);
}