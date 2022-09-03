
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 获取随机子列表
 * @Author: leven
 */
public class daytTask {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_GREEN = "\u001B[92m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String ANSI_PURPLE = "\u001B[35m";

    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_WHITE = "\u001B[37m";
    static String[] str1 ={"[1.数学题/最少5道","[2.数学题/最少5道","[10.anki高数","[11.anki概率论",
            "[12.anki线性代数","[14.数学课程/最少把一个点听明白", "[15.数学课程/最少把一个点听明白",
            "[19.录入anki高数错题","[20.复习anki高数错题/组二", "[23.收集箱里的散学习任务/组二",
            "[26.录入anki概率错题/组二",
            "[27.录入anki线性代数错题/组二","[28.复习anki数据结构错题/组二","[29.复习anki线性代数错题/组二",
            "[30.复习anki概率错题/组二",
            "[33.数学题/最少5道","[34.数学题/最少5道","[35.数学课程/最少把一个点听明白",
            "[36.数学课程/最少把一个点听明白","[39.数学课程/最少把一个点听明白","[40.数学课程/最少把一个点听明白",
            "[41.数学课程/最少把一个点听明白","[42.数学课程/最少把一个点听明白"};
    static String[] str2 = {"[3.英语真题/单篇",
            "[4.英语真题/单篇","[5.英语真题复盘/单篇",
            "[8.英语单词",
            "[18.英语真题复盘/单篇","[22.复习anki真题复盘过来的英语笔记",
            "[37.英语真题复盘/单篇","[38.英语真题/单篇"};
    static String[] str3 = {"[6.数据机构习题/一半","[7.专业课复盘一篇",
            "[13.anki数据结构","[25.录入anki数据结构错题/组二","[28.复习anki数据结构错题/组二",
            "[31.数据结构习题扫盲","[32.数据机构习题/一半",};
    static String[] str4 = {"[9.anki政治背诵/一半","[16.anki政治题","[17.anki政治背诵/一半",};
    static String[] str5 = {"[21.对anki搁置的任务进行归类对比/组二","[23.收集箱里的散学习任务/组二",};
    static String[] numList1 = {"1","2","14","15","33","34","35","36","39","40","41","42"};//3分的
    static String[] numList3 = {"24","25","26","27","19"};//1分的
    static String[] numLists = (String[]) ArrayUtils.addAll(numList1, numList3);
    public static void main(String[] args) throws InterruptedException {

//        String[] strs={"[1.数学课程/30分钟","[2.数学课程/30分钟","[3.英语真题/单篇",
//                "[4.英语真题/单篇","[5.英语真题复盘/单篇","[6.数据机构习题/一半","[7.专业课复盘一篇",
//                "[8.英语单词","[9.anki政治背诵/一半","[10.anki高数","[11.anki概率论",
//                "[12.anki线性代数","[13.anki数据结构","[14.数学课程/30分钟",
//                "[15.数学课程/30分钟","[16.anki政治题","[17.anki政治背诵/一半",
//                "[18.英语真题复盘/单篇","[19.录入anki高数错题","[20.复习anki高数错题/组二",
//                "[21.对anki搁置的任务进行归类对比/组二","[22.复习anki真题复盘过来的英语笔记","[23.收集箱里的散学习任务/组二",
//                "[24.录入anki英语真题笔记/组二","[25.录入anki数据结构错题/组二","[26.录入anki概率错题/组二",
//                "[27.录入anki线性代数错题/组二","[28.复习anki数据结构错题/组二","[29.复习anki线性代数错题/组二",
//                "[30.复习anki概率错题/组二","[31.数据结构习题扫盲","[32.数据机构习题/一半",
//                "[33.数学课程/30分钟","[34.数学课程/30分钟","[35.数学课程/30分钟",
//                "[36.数学课程/30分钟","[37.英语真题复盘/单篇","[38.英语真题/单篇"};

        List<Integer> list = new ArrayList<>();
        String[] strs = {};
        strs = getStrings(str1, str2, str3, str4, str5, strs, list);

        method(strs,list);
    }

    private static String[] getStrings(String[] str1, String[] str2, String[] str3, String[] str4, String[] str5, String[] strs, List<Integer> list) {
        for (;;){
            System.out.println("选择以下学科进入随机池：1、数学；2、英语；3、数据结构；4、政治；5、散装学习任务。输入0退出循环");
            Scanner sc=new Scanner(System.in);
            int i = sc.nextInt();
            if (list.contains(i)){
                System.out.println("已选过，请重新选择");
                continue;
            }else {
                if (i==1&&!list.contains(i)){
                    strs = (String[]) ArrayUtils.addAll(strs, str1);
                    list.add(i);
                }
                if (i==2&&!list.contains(i)){
                    strs = (String[]) ArrayUtils.addAll(strs, str2);
                    list.add(i);
                }
                if (i==3&&!list.contains(i)){
                    strs = (String[]) ArrayUtils.addAll(strs, str3);
                    list.add(i);
                }
                if (i==4&&!list.contains(i)){
                    strs = (String[]) ArrayUtils.addAll(strs, str4);
                    list.add(i);
                }
                if (i==5&&!list.contains(i)){
                    strs = (String[]) ArrayUtils.addAll(strs, str5);
                    list.add(i);
                }
            }

            if (i==0){
                break;
            }
        }
        return strs;
    }

    private static void method(String[] strs,List list) throws InterruptedException {
        List<String> allTask = Arrays.asList(strs);
        int allNum = allTask.size();
        int allCollectNum = allTask.size();

        for (String str : allTask){
            for (String string : numList1){
                if (str.contains("["+string+".")){
                    allCollectNum+=2;
                }
            }
            boolean flag = false;
            for (String string:numLists){
                if (str.contains("["+string+".")){
                    flag=true;
                }
            }
            if (flag==false){
                allCollectNum+=1;
            }
        }
//        allCollectNum+=(allCollectNum-8-5)*1+8*2;// -6 -5 6*2
        double collect = 0;

        List<Integer> selectIntegers = new ArrayList<>();

        for (;;){
            List<String> subList = getStrings(allTask);
            Scanner sc=new Scanner(System.in);
            int i = 0;
            for (;;){
                System.out.println("选一个/选0重新筛选");
                i = sc.nextInt();
                if (i==0){
                    break;
                }
//                String join = String.join(",", numList1);
                if (booleanIntegerList(subList,i)){
//                    if (i==1||i==2||i==14||i==15||i==33||i==34||i==35||i==36){//-8  8*2在这里
                    if ((","+String.join(",", numList1)+",").contains(","+i+",")){
                        collect += 3;
//                        allCollectNum += 2;
//                    }else if (i==24||i==25||i==26||i==27||i==19){//-5
                    }else if ((","+String.join(",", numList3)+",").contains(","+i+",")){
                        collect++;
                    }else {
                        collect+=2;
//                        allCollectNum += 1;
                    }
                    selectIntegers.add(i);
                    break;
                };
            }
            int finalI = i;
            allTask = allTask.stream().filter(list2->!list2.contains("["+finalI +".")).collect(Collectors.toList());


                Collections.sort(selectIntegers);
                if (selectIntegers.size()==allNum){
                    System.out.println(ANSI_PURPLE+"由于您的勤奋，已经完成了所有的任务，完结撒花！！！"+ANSI_BLACK);
                    printProgress((collect/allCollectNum*100));
                    System.out.println("是否开始新的任务？0/1");
                    int flag = sc.nextInt();
                    if (flag==1){
                        String[] s = getStrings(str1, str2, str3, str4, str5, strs, list);
                        method(s,list);
                    }else {
                        return;
                    }

                }else if ((collect/allCollectNum*100)>=75){
                    System.out.println(ANSI_YELLOW+"由于您的勤奋，已经完成了四分之三的任务"+ANSI_BLACK);
                }else if((collect/allCollectNum*100)>=50){
                    System.out.println(ANSI_BLUE+"由于您的勤奋，已经完成了一半的任务"+ANSI_BLACK);
                }else if ((collect/allCollectNum*100)>=25){
                    System.out.println(ANSI_CYAN+"由于您的勤奋，已经完成了四分之一的任务"+ANSI_BLACK);
                }
                System.out.println("已完成的任务:"+selectIntegers);
                printProgress((collect/allCollectNum*100));
//                System.out.println("还剩余"+(allNum-selectIntegers.size())+"个任务！");

        }
    }


    public static void printProgress(double num) throws InterruptedException {
        int k = 7;
        num = num>100?100:num;
        String str3,str4;
        for (int i=0;i<=num;i++){
            str3=getString(k,"\b");
            str4=String.format("%d%%| %s",i,getString(i/5,"■"));
            System.out.print(str3);
            System.out.print(str4);
            k++;
        }
        System.out.println();
    }

    public static String getString(int num,String str) {
        String str2 = "";
        for (int i = 0 ;i<num ;i++){
            str2=str2+str;
        }
        return str2;
    }

    private static List<String> getStrings(List<String> allTask) {
        List<String> subList = daytTask.newRandomList(allTask, 3);
        subList.forEach(System.out::println);
        return subList;
    }

    public static Boolean booleanIntegerList(List<String> subList,int i){
        List<Integer> integers = new ArrayList<>();
        for (String s:subList){
            String substring = s.substring(1,s.indexOf("."));
            integers.add(Integer.valueOf(substring));
        }
        if (integers.contains(i)){
            return true;
        }
        return false;
    }
    private static Random r;

    /**
     * 获取随机子列表
     * @param source 原列表
     * @param limit 子列表长度
     * @param <T> 列表原类型
     * @return 子列表
     */
    public static <T> List<T> newRandomList(List<T> source, int limit) {
        if(source == null || source.size() == 0 || source.size() <= limit){
            return source;
        }

        Set<Integer> set = createRandomSet(source.size(), limit);
        Integer[] array = set.toArray(new Integer[0]);
        return new RandomList<>(source, array);
    }

    /**
     * 创建一个随机的有序下标Set
     * @param listSize 原列表长度
     * @param limit 子列表长度
     * @return 随机的下标Set
     */
    private static Set<Integer> createRandomSet(int listSize, int limit) {
        Random rnd = r;
        if (rnd == null)
            r = rnd = new Random();

        Set<Integer> set = new HashSet<>(limit);
        for (int i = 0; i < limit; i++) {
            int value = rnd.nextInt(listSize);
            if (!add(set, value, listSize)) {
                return set;
            }
        }
        return set;
    }

    /**
     * 往Set中添加一个随机值，如果有冲突，则取随机值+1
     */
    private static boolean add(Set<Integer> set, int value, int size) {
        if (set.size() == size) {
            return false;
        }

        if (!set.contains(value)) {
            return set.add(value);
        }

        int nextValue = value + 1;
        if (nextValue == size) {
            nextValue = 0;
        }
        return add(set, nextValue, size);
    }

    private static class RandomList<T> extends AbstractList<T> {
        final List<T> list;
        final Integer[] indexs;

        RandomList(List<T> list, Integer[] indexs) {
            this.list = list;
            this.indexs = indexs;
        }

        @Override
        public T get(int index) {
            if(index < 0 || index >= indexs.length)
                throw new IndexOutOfBoundsException("The start index was out of bounds: "
                        + index + " >= " + indexs.length);
            int start = indexs[index];
            return list.get(start);
        }

        @Override
        public int size() {
            return indexs.length;
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

}

