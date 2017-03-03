package com.example.lin.myandroidapplication.data.net;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lin on 2016/11/26.
 */
public class CameraBean extends BaseBean<CameraBean.Camera> {

    private List<Camera> data;

    public List<Camera> getData() {
        return data;
    }

    public void setData(List<Camera> data) {
        this.data = data;
    }

    public static class Camera implements Serializable{
        private int id;
        private String name;
        private String sign;
        private String channel;
        private String status;
        private String img;
        private Object phone;
        private Object longitude;
        private Object latitude;

        public Camera(String sign, String channel, String name) {
            this.sign = sign;
            this.channel = channel;
            this.name = name;
        }

        private AreaEntity area;


        private GridEntity grid;
        private Object ysUser;

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

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public AreaEntity getArea() {
            return area;
        }

        public void setArea(AreaEntity area) {
            this.area = area;
        }

        public GridEntity getGrid() {
            return grid;
        }

        public void setGrid(GridEntity grid) {
            this.grid = grid;
        }

        public Object getYsUser() {
            return ysUser;
        }

        public void setYsUser(Object ysUser) {
            this.ysUser = ysUser;
        }

        public static class AreaEntity implements Serializable{
            private int id;
            private String name;
            private String vrPath;
            private double longitude;

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

            public String getVrPath() {
                return vrPath;
            }

            public void setVrPath(String vrPath) {
                this.vrPath = vrPath;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }
        }

        public static class GridEntity implements Serializable{
            private int id;
            private String name;
            private String duty;
            private Object age;
            private String photo;
            private String phone;

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

            public String getDuty() {
                return duty;
            }

            public void setDuty(String duty) {
                this.duty = duty;
            }

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }
}
