import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wang on 2017/8/24.
 */
public class Comment {
    private static int counter = 1;
    private final int id = counter++;
    private int pid;
    private int cid;
    private String msg;
    private Date data;
    private int uId;
    private int toUId;
    private List<Comment> back = new ArrayList<>();

    public Comment() {}

    public Comment(int pid, int cid, String msg, int uId) {
        this.pid = pid;
        this.cid = cid;
        this.msg = msg;
        this.uId = uId;
    }

    public int getId() {
        return id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getToUId() {
        return toUId;
    }

    public void setToUId(int toUId) {
        this.toUId = toUId;
    }

    public List<Comment> getBack() {
        return back;
    }

    public void setBack(List<Comment> back) {
        this.back = back;
    }

    public String toString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append("\t");
        sb.append("msgId:" + id);
        if (cid != 0) {
            sb.append("  reply  ");
            sb.append(cid);
        }
        sb.append("  says: ");
        sb.append(msg + "\n");
        return sb.toString();
    }
}
