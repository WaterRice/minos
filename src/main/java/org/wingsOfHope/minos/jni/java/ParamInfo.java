public class ParamInfo {
    long questionID;
    int languageCode;
    long runID;
    int timeLim;
    int memLim;
    String srcCode;

    public ParamInfo() {

    };

    public ParamInfo(long questionID, int languageCode, long runID, int timeLim, int memLim, String srcCode) {
        this.questionID = questionID;
        this.languageCode = languageCode;
        this.runID = runID;
        this.timeLim = timeLim;
        this.memLim = memLim;
        this.srcCode = srcCode;
    }

}