package com.tylersimmonsdev.dbutil;


import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Arrays;

public class QueryBuilder {
    public QueryBuilder() {

    }

    public static String selectQuery(String column, String table) {
        return String.format("SELECT %s FROM %s;", column, table);
    }

    public static String selectQuery(String[] columns, String table) {
        String columnString = Arrays.toString(columns);
        columnString = columnString.substring(1, columnString.length()-1);
        return String.format("SELECT %s FROM %s;", columnString, table);
    }

    public static String selectOne(String column, String table, KeyValue constraint) {
        return "";
    }

    public static String selectOne(String[] columns, String table, KeyValue constraint) {
        return ";";
    }


}
