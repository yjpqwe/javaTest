import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang.StringEscapeUtils;

import java.net.URLDecoder;

public class Unescape {

        public static void main(String[] args)throws Exception{
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine engine = sem.getEngineByExtension("js");
            //原始url
            String url = "%3Cspan%3E342%3C/span%3E";
            String keyWord = URLDecoder.decode(url, "utf-8");
            //解码后url
            String unUrl;
//            try {
                System.out.println(keyWord);
//            System.out.println(StringEscapeUtils.unescapeHtml(url));
//                unUrl = (String)engine.eval("unescape('"+url+"')");
//
//                System.out.println(unUrl);  //输出结果为:http://www.baidu .com%
//            } catch (ScriptException e) {
//                e.printStackTrace();
//            }
        }
    }
