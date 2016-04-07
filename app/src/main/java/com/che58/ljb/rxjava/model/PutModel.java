package com.che58.ljb.rxjava.model;

import java.util.List;

/**
 * Created by ljb on 2016/4/7.
 */
public class PutModel {
    private int code;
    private String message;
    private XgoEntity entity;

    private class XgoEntity {
        private List<Data> data;

        private class Data {
            @Override
            public String toString() {
                return "Data{}";
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
        return "PutModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", entity=" + entity +
                '}';
    }
}
