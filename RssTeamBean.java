import java.util.List;

public class RssTeamBean {
        /**
         * 分组标题
         */
        private String title;

        /**
         * 分组名称
         */
        private String text;

        private String fatherContent;

    public String getFatherContent() {
        return fatherContent;
    }

    public void setFatherContent(String fatherContent) {
        this.fatherContent = fatherContent;
    }

    public void setMubuText(String mubuText) {
        this.mubuText = mubuText;
    }

    public String getMubuText() {
        return mubuText;
    }

    private String mubuText;
        private String image;

        private List<RssTeamBean> rssBeanList ;

        private String content;

        private int num;

        private RssTeamBean fatherRss;

        private String fatherMubuText;

        private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFatherMubuText() {
        return fatherMubuText;
    }

    public void setFatherMubuText(String fatherMubuText) {
        this.fatherMubuText = fatherMubuText;
    }

    public RssTeamBean getFatherRss() {
        return fatherRss;
    }

    public void setFatherRss(RssTeamBean fatherRss) {
        this.fatherRss = fatherRss;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public List<RssTeamBean> getRssBeanList() {
            return rssBeanList;
        }
        public void setRssBeanList(List<RssTeamBean> rssBeanList) {
            this.rssBeanList = rssBeanList;
        }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
