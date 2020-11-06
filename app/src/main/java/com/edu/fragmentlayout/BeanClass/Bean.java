package com.edu.fragmentlayout.BeanClass;

import java.util.List;

public class Bean {
    /**
     * code : 200
     * message : 成功!
     * result : [{"path":"https://news.163.com/20/1027/04/FPTTJ2JU0001899O.html","image":"http://cms-bucket.ws.126.net/2020/1027/3d9a93e2p00qitsku001nc0009c0070c.png?imageView&thumbnail=140y88&quality=85","title":"被推下水溺亡女子的女儿发声：妈妈和她不是闺蜜","passtime":"2020-10-27 10:00:46"},{"path":"http://dy.163.com/article/FPTGC08V05128ELF.html","image":"http://cms-bucket.ws.126.net/2020/1027/b5e14653j00qiu6o5001hc000s600e3c.jpg?imageView&thumbnail=140y88&quality=85","title":"抗美援朝：韩国承包了所有笑点 日本竟成最大赢家！","passtime":"2020-10-27 10:00:46"},{"path":"https://dy.163.com/article/FPTFVN4O0512B07B.html","image":"http://cms-bucket.ws.126.net/2020/1027/e0848af7j00qiu34m001ic000s600e3c.jpg?imageView&thumbnail=140y88&quality=85","title":"＂让国人赚钱＂承诺实现！2万亿市值的蚂蚁摘2项冠军","passtime":"2020-10-27 10:00:46"},{"path":"https://news.163.com/20/1026/23/FPTC7LJ50001899O.html","image":"http://cms-bucket.ws.126.net/2020/1026/58757d2cj00qitfbc000ec0009c0070c.jpg?imageView&thumbnail=140y88&quality=85","title":"世贸组织裁定美对中加征关税非法 特朗普政府上诉","passtime":"2020-10-27 10:00:46"},{"path":"https://auto.163.com/20/1027/07/FPU6LBKH0008856R.html","image":"http://cms-bucket.ws.126.net/2020/1027/a3fbcb11j00qiu3mg0028c00044002gc.jpg?imageView&thumbnail=140y88&quality=85","title":"你们要的来了 大众纯电动SUV续航达550km","passtime":"2020-10-27 10:00:46"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * path : https://news.163.com/20/1027/04/FPTTJ2JU0001899O.html
         * image : http://cms-bucket.ws.126.net/2020/1027/3d9a93e2p00qitsku001nc0009c0070c.png?imageView&thumbnail=140y88&quality=85
         * title : 被推下水溺亡女子的女儿发声：妈妈和她不是闺蜜
         * passtime : 2020-10-27 10:00:46
         */

        private String path;
        private String image;
        private String title;
        private String passtime;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }
    }
    //        private String id;
//        private String title;
//        private String pic;
//        private String collect_num;
//        private String food_str;
//        private int num;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getPic() {
//            return pic;
//        }
//
//        public void setPic(String pic) {
//            this.pic = pic;
//        }
//
//        public String getCollect_num() {
//            return collect_num;
//        }
//
//        public void setCollect_num(String collect_num) {
//            this.collect_num = collect_num;
//        }
//
//        public String getFood_str() {
//            return food_str;
//        }
//
//        public void setFood_str(String food_str) {
//            this.food_str = food_str;
//        }
//
//        public int getNum() {
//            return num;
//        }
//
//        public void setNum(int num) {
//            this.num = num;
//        }
    }

