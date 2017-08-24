import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2017/8/24.
 */
public class CommentResponse {
    private static List<Comment> comments = null;
    public static void main(String[] args) {
        CommentResponse cr = new CommentResponse();
        comments = CommentCreator.getCommentList(200);
        List<Comment> initCommentList = cr.initCommentList(comments);
        cr.buildCommentTree(initCommentList);
        //cr.showComment(initCommentList, 0);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("comments", initCommentList);
        System.out.println(jsonObject.toString());
    }

    private void showComment(List<Comment> commentList, int n) {
        for (Comment comment : commentList) {
            System.out.println(comment.toString(n));
            if (comment.getBack().size() > 0)
                showComment(comment.getBack(), n + 1);
        }
    }

    //初始化一级回复列表
    private List<Comment> initCommentList(List<Comment> commentList) {
        List<Comment> initComment = new ArrayList<>();
        for (Comment comment : commentList) {
            if (comment.getCid() == 0)
                initComment.add(comment);
        }

        return initComment;
    }

    //递归生成回复树
    private void buildCommentTree(List<Comment> commentList) {
        for (Comment comment : commentList) {
            int cid = comment.getId();
            for (Comment c : comments) {
                if (c.getCid() == cid)
                    comment.getBack().add(c);
            }
            if (comment.getBack().size() > 0)
                buildCommentTree(comment.getBack());
        }
    }
}
