import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hecong
 * Date: 11/13/18
 * Time: 3:54 PM
 * E-mail:cshecong@outlook.com
 */

public class MaximunForwardTokenizer {

    public static void main(String[] args) {

        String str = "当模型训练完后，最后得到的其实是神经网络的权重，比如现在输入一个 x 的 one-hot encoder: [1,0,0,…,0]，对应刚说的那个词语『吴彦祖』，则在输入层到隐含层的权重里，只有对应 1 这个位置的权重被激活，这些权重的个数，跟隐含层节点数是一致的，从而这些权重组成一个向量 vx 来表示x，而因为每个词语的 one-hot encoder 里面 1 的位置是不同的，所以，这个向量 vx 就可以用来唯一表示 x。";
        HashSet<String> dic = new HashSet<>();
        dic.add("训练");
        dic.add("模型");
        dic.add("权重");
        dic.add("神经网络");
        dic.add("现在");
        dic.add("输入");
        dic.add("模型");

    }

    //最大前向分词 return a list
    public List tokenize(String str, HashSet<String> dic) {
        ArrayList<String> result = new ArrayList<>();
        int start = 0;
        int end ;
        int index = 0;
        int max ;
        while(start < str.length()) {
            max = start;
            for(end = start+1; end <= str.length(); end++) {
                if(dic.contains(str.substring(start, end))) {
                    max = end;
                }
            }

            if(max != start) {
                if(index < start) {
                    result.add(str.substring(index, start));
                }
                result.add(str.substring(start, max));
                index = max;
                start = max;
            }
            else {
                start++;
            }
        }

        if(index < str.length()) {
            result.add(str.substring(index));
        }

        return result;
    }

}
