import java.io.*;

/* 用于字符统计 */
public class CountTool {

    /* 统计总字符数 */
    public int characterCount(StringBuffer str) {
        //总字符数
        int sum = 0;
        String result = str.toString();
        char[] charArrary = result.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            sum++;
        }
        return sum;
    }

    /* 统计单词数 */
    public int wordsCount(StringBuffer str) {
        //转化小写且以'.'分割的字符串
        String changedStr = this.changeStr(str);
        //分割字符串
        String[] wordStr = changedStr.split(" ");
        //计数 利用正则表达式筛选
        int sum= 0;
        for (int i = 0; i < wordStr.length; i++) {
            if (wordStr[i].matches("[a-z]{4}[a-z0-9]*")) {
                sum++;
            }
        }
        return sum;
    }

    /* 转化成有效字符串 */
    public String changeStr(StringBuffer str) {
        String result= str.toString().toLowerCase();
        //利用正则表达式筛选出不是数字和字母的符号，转化为'.'
        String regex = "[^a-z0-9]";
        result = result.replaceAll(regex," ");
        return result;
    }

    /* 统计有效行 */
    public int invaluableLines(String filePath) throws IOException {
        //UTF-8编码进行读取
        FileInputStream file = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(file,"UTF-8");
        BufferedReader br = new BufferedReader(reader);
        //记录有效行数（任何包含非空白字符的行，都需要统计）
        int sumLines = 0;
        //利用正则表达式指代空白字符
        String regex = "\\s*";
        String line;
        while ((line = br.readLine()) != null) {
            sumLines++;
            //判断是不是空白字符行
            if (line.matches(regex)) {
                sumLines--;
            }
        }
        return sumLines;
    }
}
