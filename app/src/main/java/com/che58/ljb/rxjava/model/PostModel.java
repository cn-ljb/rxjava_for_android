package com.che58.ljb.rxjava.model;

/**
 * Created by ljb on 2016/4/7.
 */
public class PostModel {
    private int code;
    private String message;
    private XgoEntity entity;

    private class XgoEntity {
        private Data data;

        private class Data {
            private String xxx;

            @Override
            public String toString() {
                return "Data{" +
                        "xxx='" + xxx + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "XgoEntity{" +
                    "data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GetModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", entity=" + entity +
                '}';
    }
}
