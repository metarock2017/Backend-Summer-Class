import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by wang on 2017/8/24.
 */
public class CommentCreator {
    private static Random rand = new Random(33);
    private static  List<String> strList = Arrays.asList("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));

    public static List<Comment> getCommentList(int size) {
        List<Comment> commentList = new ArrayList<>();
        int pid = 1;
        commentList.add(new Comment(pid, 0, "第一条信息", rand.nextInt(100)));
        for (int i = 0; i < size - 1; i++) {
            int cid = rand.nextInt( i + 1);
            if (rand.nextInt(4) == 1 )
                cid = 0;
            Comment temp = new Comment(pid, cid, getRandString(), rand.nextInt(100));
            commentList.add(temp);
        }

        return commentList;
    }

    private static String getRandString() {

        int n = rand.nextInt(10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strList.get(rand.nextInt(strList.size())));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<Comment> commentList = getCommentList(100);
        System.out.println(commentList);
//        for (Comment comment : commentList)
//            System.out.println(comment.getuId());
    }
}
