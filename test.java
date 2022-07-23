import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class test {
    static List<RssTeamBean> allRss = new ArrayList<>();
    static List<String> sameText = new ArrayList<>();
    static List<Integer> integers = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        test readXML = new test();
        int num = 0;
//        System.out.println("请输入opml的完整路径");
//        String s = sc.next();
        RssTeamBean rssTemBeanList = readXML.ReadRss("C:\\Users\\59292\\Desktop\\考研相关.opml");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\59292\\Desktop\\op.csv"));
//            printTop(out,rssTemBeanList,0);
            printTop(rssTemBeanList, 0, "",null);
//            allRss.sort(Comparator.comparing(RssTeamBean::getNum));
            allRss.sort(Comparator.comparing(RssTeamBean::getContent).reversed());
            Map<String, List<RssTeamBean>> collect
                    = allRss.stream().collect(Collectors.groupingBy(RssTeamBean::getFatherMubuText));
            Set<String> strings = collect.keySet();
            for (String string:strings){
                if (string!=""){
                    System.out.println(string);
                    out.write("Σ "+string+"\t");
                    if (collect.get(string)!=null&&collect.get(string).get(0)!=null){
                        out.write(collect.get(string).get(0).getContent()+"\t");
                    }
                    out.write("<ol>");
                    for (RssTeamBean rssTeamBean : collect.get(string)){
                        out.write("<li>"+rssTeamBean.getMubuText()+"</li>");
                    }
                    out.write("</ol>");
                    out.newLine();
                }
            }
            String string = collect.toString();
//            for (RssTeamBean rssTeamBean:allRss){
//                System.out.print(rssTeamBean.getMubuText()+"->");
//            }
//            String string = null;
//            for (int i=allRss.size()-1;i>0;i--){
//                if (i>=1){
//                    if (string!=null){
//                        if (allRss.get(i).getContent().equals(allRss.get(i-1).getContent())){
//                                string += "<li>"+allRss.get(i).getMubuText()+"</li>";
//                                System.out.println(string);
//                            }else{
//                                out.write(string+"</ol>");
//                                out.flush();
//                                out.newLine();
//                        }
////                        out.write(string+"</ol>");
////                        out.flush();
////                        out.newLine();
//                        string = null;
//                    }
//                    if (!allRss.get(i).getContent().equals(allRss.get(i-1).getContent())){
//                        out.write("Σ "+allRss.get(i-1).getMubuText()+"\t"+allRss.get(i-1).getContent()+"\t"+allRss.get(i).getMubuText()+"\t");
//                        out.flush();
//                        out.newLine();
//                    }
//                    if (allRss.get(i).getContent().equals(allRss.get(i-1).getContent())){
//                        if (string==null){
//                            string = "Σ "+allRss.get(i-1).getMubuText()+"\t"+allRss.get(i).getContent()+"\t"+"<ol><li>"+allRss.get(i).getMubuText()+"</li>";
//                            System.out.println(string);
//                        }else{
//                            string = "<li>"+allRss.get(i).getMubuText()+"</li>";
//                            System.out.println(string);
//                        }
//                    }
//                }
//            }
//            Integer max = Collections.max(integers);
//            for (;;){
//                writeTop(num,rssTemBeanList,new ArrayList<>(),max);
//            }
            out.close();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
        }
//        printTop(rssTemBeanList,0);
    }


    static public List<RssTeamBean> collectRss(List<RssTeamBean> rssTeamBeanList,String father){
        List<RssTeamBean> rssList = new ArrayList<>();
        Map<String, List<RssTeamBean>> collect
                = rssTeamBeanList.stream().collect(Collectors.groupingBy(RssTeamBean::getFatherMubuText));
        collect.toString();
        return rssTeamBeanList;
    }

    static public void printTop(RssTeamBean rssTeamBean,int i,String content,String mubuContent) {
            i++;
            integers.add(i);
            rssTeamBean.setId(integers.size());
            if (sameText.contains(rssTeamBean.getMubuText())){
                rssTeamBean.setMubuText(rssTeamBean.getMubuText()+"(防重复标识符"+rssTeamBean.getId()+")");
            }
            sameText.add(rssTeamBean.getMubuText());
            String str = "";
//            if (mubuContent!=""){
                mubuContent+="~/"+rssTeamBean.getMubuText();
                str = StringUtils.substringBeforeLast(mubuContent,"~/");
                if (mubuContent.contains("~/")){
                    str = StringUtils.substringAfterLast(str, "~/");
                }

                rssTeamBean.setFatherMubuText(str);
//            }
            String subcontent = null;
            if (content!=""){
                if (rssTeamBean.getText()!=""){
                    content+=" - "+rssTeamBean.getText();
                }else{
                    content+=" - "+"图";
                }
                subcontent = StringUtils.substringBeforeLast(content," - ");
                rssTeamBean.setContent("《"+subcontent+"》");
            }else{
                content+=rssTeamBean.getText();
                if (rssTeamBean.getText().equals(content)){
                    rssTeamBean.setContent("《》");
                }
            }


            rssTeamBean.setNum(i);
            allRss.add(rssTeamBean);

            for (RssTeamBean rss : rssTeamBean.getRssBeanList()){
                printTop(rss,i,content,mubuContent);
            }
    }

    static public void writeTop(int num,RssTeamBean rssTeamBean,List<RssTeamBean> team,int max) throws IOException {

        for (RssTeamBean rss : rssTeamBean.getRssBeanList()){
            if (max==0){
                return;
            }
            if (rss.getNum()==num){
                max--;
                team.add(rss);
                System.out.println(rss.getNum());
                System.out.println(rss.getMubuText());
            }else if (rss.getNum()<=num){
                List<RssTeamBean> rssBeanList = rss.getRssBeanList();
//                if (){
//                }
            }
        }
    }


    /**
     * 读取当前组博客订阅信息
     *
     * @param iter        当前节点的子节点迭代器
     */
    private List<RssTeamBean> ReadBlogsInfo(Iterator<?> iter,List<RssTeamBean> rssBeanList) {
        List<RssTeamBean> rss = new ArrayList<>();
        // 遍历所有outline节点，每个节点都是一条订阅信息
        while (iter.hasNext()) {
            RssTeamBean rssBean = new RssTeamBean();

            Element outlineElt = (Element) iter.next();
            String outlineText = outlineElt.attributeValue("text"); // 拿到当前节点的text属性值
            String outlineImage = outlineElt.attributeValue("_mubu_images");

            rssBean.setText(outlineText);
            rssBean.setImage(outlineImage);

            // 将每条订阅信息，存放到订阅列表中
            rssBeanList.add(rssBean);
            Iterator<?> iterRss = outlineElt.elementIterator("outline");
            ReadBlogsInfo(iterRss,rss);
            rssBean.setRssBeanList(rssBeanList);
        }
        return rssBeanList;
    }


    private RssTeamBean ReadRss(String filePath) {
        RssTeamBean topRssTeamBean = new RssTeamBean();
        File file = new File(filePath);

        if (!file.exists()) {
            // System.out.println("找不到【" + filePath + "】文件");
            // return;
            throw new RuntimeException("找不到【" + filePath + "】文件");
        }

        try {

            // 读取并解析XML文档
            // SAXReader就是一个管道，用一个流的方式，把xml文件读出来
            SAXReader reader = new SAXReader();
            FileInputStream fis = new FileInputStream(file);

            // 下面的是通过解析xml字符串的
            Document doc = reader.read(fis);

            // 获取根节点
            Element rootElt = doc.getRootElement(); // 获取根节点
            // System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称

            // 获取head/title节点
            Element titleElt = (Element) rootElt.selectSingleNode("head/title");// 获取head节点下的子节点title

            // 获取分组名称
            String title = titleElt.getTextTrim();

            topRssTeamBean.setText(title);

            // 获取body节点
            Element bodyElt = (Element) rootElt.selectSingleNode("body");

            // 获取body节点下的outline节点
            Iterator<?> iter = bodyElt.elementIterator("outline");

            List<RssTeamBean> iter1 = Iter(iter);
            topRssTeamBean.setRssBeanList(iter1);
            return iter1.get(0);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return topRssTeamBean;
    }
//    private List<RssTeamBean> rssTeamBeanList = new ArrayList<>();
    private List<RssTeamBean> Iter(Iterator<?> iter) throws UnsupportedEncodingException {
        List<RssTeamBean> rssBeanList = new ArrayList<RssTeamBean>();
        while (iter.hasNext()) {

            // 读取outline节点下的所有outline信息，每条信息都是一条订阅记录
            Element TeamElt = (Element) iter.next();

            // 实例化 RSS分组实体
            RssTeamBean rssTeamBean = new RssTeamBean();

            // 重新获取分组名称
            String text = TeamElt.attributeValue("text");
            String mubuText = null;
            mubuText = TeamElt.attributeValue("_mubu_text");
            if (mubuText!=null){
                String mubuTestReplace = mubuText.replace("+", "%2B");//替换
                mubuText = URLDecoder.decode(mubuTestReplace, "UTF-8");
            }
            String images = null;
            images = TeamElt.attributeValue("_mubu_images");
            if (images!=null){
                images = URLDecoder.decode(images, "utf-8");
                List<String> strings = Arrays.asList(images.split(","));
                for (String str : strings){
                    if (str.contains("uri")){
                        List<String> split = Arrays.asList(str.split("\""));
                        for (String string:split){
                            if (string.contains("image")){
                                images = "\"https://mubu.com/"+string;
                                mubuText = mubuText+"<br><img src="+images+"\" />";
                                images = null;
                            }
                        }
                    }
                }
            }

            // 记录分组名称和显示名称
            rssTeamBean.setText(text);
            rssTeamBean.setImage(images);
            rssTeamBean.setMubuText(mubuText);

            // 添加分组到rss分组订阅列表
            rssBeanList.add(rssTeamBean);
            // 获取body节点下的outline节点
            Iterator<?> iterRss = TeamElt.elementIterator("outline");
            List<RssTeamBean> iter1 = Iter(iterRss);
            rssTeamBean.setRssBeanList(iter1);

        }
        return rssBeanList;
    }
//    public static String unEscape(String url){
//        ScriptEngineManager sem = new ScriptEngineManager();
//        ScriptEngine engine = sem.getEngineByExtension("js");
//        String unUrl = null;
//        try {
//            unUrl = (String)engine.eval("unescape('"+url+"')");
////            System.out.println(unUrl);  //输出结果为:http://www.baidu .com%
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }
//        return unUrl;
//    }
}
