package com.example.lin.myandroidapplication.data.net;

import java.util.List;

/**
 * Created by lin on 2016/12/17.
 */
public class CameraCategoryBean extends BaseBean<CameraCategoryBean.CameraCategory>{

    private List<CameraCategory> data;

    public List<CameraCategory> getData() {
        return data;
    }

    public void setData(List<CameraCategory> data) {
        this.data = data;
    }

    public static class CameraCategory {
        private int id;
        private String name;

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

        @Override
        public String toString() {
            return "CameraCategory{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CameraCategoryBean{" +
                "data=" + data +
                '}';
    }
}
