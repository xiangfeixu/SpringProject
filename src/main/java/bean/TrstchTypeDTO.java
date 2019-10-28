package bean;

/**
 * 转接类型信息
 * @author xuxiangfei
 * @date 2019/10/28
 */
public class TrstchTypeDTO {

    private String TRSTCH_TYPE_ID;
    private String TRSTCH_TYPE_NM;
    private String TRSTCH_TYPE_CD;
    private String CTI_ID;

    public String getTRSTCH_TYPE_ID() {
        return TRSTCH_TYPE_ID;
    }

    public void setTRSTCH_TYPE_ID(String TRSTCH_TYPE_ID) {
        this.TRSTCH_TYPE_ID = TRSTCH_TYPE_ID;
    }

    public String getTRSTCH_TYPE_NM() {
        return TRSTCH_TYPE_NM;
    }

    public void setTRSTCH_TYPE_NM(String TRSTCH_TYPE_NM) {
        this.TRSTCH_TYPE_NM = TRSTCH_TYPE_NM;
    }

    public String getTRSTCH_TYPE_CD() {
        return TRSTCH_TYPE_CD;
    }

    public void setTRSTCH_TYPE_CD(String TRSTCH_TYPE_CD) {
        this.TRSTCH_TYPE_CD = TRSTCH_TYPE_CD;
    }

    public String getCTI_ID() {
        return CTI_ID;
    }

    public void setCTI_ID(String CTI_ID) {
        this.CTI_ID = CTI_ID;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"TRSTCH_TYPE_ID\":\"").append(TRSTCH_TYPE_ID).append("\"");
        sb.append(", \"TRSTCH_TYPE_NM\":\"").append(TRSTCH_TYPE_NM).append("\"");
        sb.append(", \"TRSTCH_TYPE_CD\":\"").append(TRSTCH_TYPE_CD).append("\"");
        sb.append(", \"CTI_ID\":\"").append(CTI_ID).append("\"");
        sb.append('}');
        return sb.toString();
    }
}
