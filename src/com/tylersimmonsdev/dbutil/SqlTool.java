package com.tylersimmonsdev.dbutil;

public class SqlTool {
    protected String url;
    protected String user;
    protected String password;

    public SqlTool(SqlCredentials credentials) {
        this.url = credentials.getUrl();
        this.user = credentials.getUser();
        this.password = credentials.getPassword();
    }


}
