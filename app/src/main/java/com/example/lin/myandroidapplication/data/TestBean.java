package com.example.lin.myandroidapplication.data;

import java.util.List;

/**
 * Created by lin on 2016/12/13.
 */
public class TestBean {


    /**
     * code : 00050
     * msg : 操作成功
     * data : [{"id":1,"name":"xx","imgPath":null},{"id":4,"name":"aa","imgPath":"/upload/articleCategory/2016-11-29/4db9211d-94cb-4222-8017-583316fc2b04.jpg"},{"id":5,"name":"bb","imgPath":"/upload/articleCategory/2016-11-29/0158bab0-45cc-4658-b71d-dc8a08b58b5e.jpeg"}]
     */

    private String code;
    private String msg;
    /**
     * id : 1
     * name : xx
     * imgPath : null
     */

    private List<DataEntity> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private int id;
        private String name;
        private Object imgPath;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getImgPath() {
            return imgPath;
        }

        public void setImgPath(Object imgPath) {
            this.imgPath = imgPath;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", imgPath=" + imgPath +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
