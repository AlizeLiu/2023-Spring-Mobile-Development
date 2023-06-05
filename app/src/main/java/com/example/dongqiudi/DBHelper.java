package com.example.dongqiudi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.IDN;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dqd.db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    private static final String TABLE_NEWS = "db_news";
    private static final String COLUMN_NEWS_ID = "news_id";
    private static final String COLUMN_NEWS_TITLE = "news_title";
    private static final String COLUMN_CONTEXT = "news_context";

    private static final String TABLE_POINTS = "db_points";
    private static final String COLUMN_POINTS_ID = "points_id";
    private static final String COLUMN_POINTS_TEAM = "points_team";
    private static final String COLUMN_POINTS_SAI = "points_sai";
    private static final String COLUMN_POINTS_WIN = "points_win";
    private static final String COLUMN_POINTS_LOSS = "points_loss";
    private static final String COLUMN_POINTS_PING = "points_ping";
    private static final String COLUMN_POINTS_GOAL = "points_goal";
    private static final String COLUMN_POINTS = "points_pt";

    private static final String CREATE_TABLE_NEWS = " CREATE TABLE " + TABLE_NEWS + "("+
            COLUMN_NEWS_ID + " TEXT PRIMARY KEY," + COLUMN_NEWS_TITLE + " TEXT," + COLUMN_CONTEXT
            + " TEXT " + ")";

    private static final String CREATE_TABLE_SCORES = "CREATE TABLE " + TABLE_POINTS + "(" +
            COLUMN_POINTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_POINTS_TEAM + " TEXT," +
            COLUMN_POINTS_SAI + " INTEGER," + COLUMN_POINTS_WIN + " INTEGER,"+ COLUMN_POINTS_PING +
            " INTEGER," + COLUMN_POINTS_LOSS + " INTEGER," + COLUMN_POINTS_GOAL + " INTEGER," +
            COLUMN_POINTS + " INTEGER" +
            ")";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                COLUMN_PASSWORD + " TEXT" +
                ")";
        db.execSQL(createTableQuery);//创建用户表
        db.execSQL(CREATE_TABLE_NEWS); // 创建新闻表
        ContentValues values = new ContentValues();

        values.put(COLUMN_NEWS_ID,"1");
        values.put(COLUMN_NEWS_TITLE,"曾是热身赛之王的国足，这次是怎么错过阿根廷的？");
        values.put(COLUMN_CONTEXT,"阿根廷来华与澳大利亚的比赛临近，关于球票、梅西等话题不断冲上热搜。\n");
        db.insert(TABLE_NEWS, null, values);
        values.clear();
        values.put(COLUMN_NEWS_ID,"2");
        values.put(COLUMN_NEWS_TITLE,"维拉2-1布莱顿，力压热刺锁定赛季第七进军欧协联资格赛");
        values.put(COLUMN_CONTEXT,"北京时间5月29日，英超收官战，阿斯顿维拉主场迎战布莱顿。上半场比赛," +
                "雅各布-拉姆齐送出两记助攻，道格拉斯-路易斯、沃特金斯先后破门，昂达夫扳回一城；下半场，" +
                "拉姆齐空门不进。最终维拉主场2-1力克布莱顿，锁定赛季第七名。\n");
        db.insert(TABLE_NEWS, null, values);
        values.clear();

        values.put(COLUMN_NEWS_ID,"3");
        values.put(COLUMN_NEWS_TITLE,"记者：麦卡利斯特将与利物浦签约至2028年，转会费7000万欧起");
        values.put(COLUMN_CONTEXT,"据阿根廷Tyc记者Germán García Grova报道，麦卡利斯特已与自己的父亲及经纪人一同敲定" +
                "了转会利物浦的细节条款，他将在下赛季成为红军球员。\n" );
        db.insert(TABLE_NEWS, null, values);
        values.clear();
        values.put(COLUMN_NEWS_ID,"4");
        values.put(COLUMN_NEWS_TITLE,"陶强龙专访：海外拉练让自己收获自信，争取早日入选国家队");
        values.put(COLUMN_CONTEXT,"在与南通支云的比赛中，陶强龙完成个人职业生涯首个帽子戏法，并送出1次助攻，" +
                "帮助球队大胜对手，最终他当选懂球帝中超第9轮MVP。\n" );
        db.insert(TABLE_NEWS, null, values);
        values.clear();
        values.put(COLUMN_NEWS_ID,"5");
        values.put(COLUMN_NEWS_TITLE,"官方：范德萨不再担任阿贾克斯CEO");
        values.put(COLUMN_CONTEXT,"阿贾克斯CEO埃德温-范德萨决定离开阿贾克斯。从2023年6月1日起，范德萨将把职责移交至管理层的同事。" +
                "监事会要求范德萨正式留任至8月1日，以确保国内外相关项目资料的顺利移交。\n" );
        db.insert(TABLE_NEWS, null, values);
        values.clear();
        values.put(COLUMN_NEWS_ID,"6");
        values.put(COLUMN_NEWS_TITLE,"连扳三城！深圳3-2梅州，饶伟辉两助攻，阿奇姆彭两传一射");
        values.put(COLUMN_CONTEXT,"北京时间5月28日19:35，中超第10轮，深圳坐镇大运中心迎战梅州，马宁主哨，黄翼出任视频助理裁判。" +
                "上半场比赛，饶伟辉发挥出色，先后助攻杨超声、潘喜明取得进球；下半场，阿奇姆彭两传一射，张源破门，刘越打入制胜球。最终深圳3-2逆转梅州。\n" );
        db.insert(TABLE_NEWS, null, values);
        values.clear();
        values.put(COLUMN_NEWS_ID,"7");
        values.put(COLUMN_NEWS_TITLE,"TA记者：皇马近几个月已经多次询问了劳塔罗的情况");
        values.put(COLUMN_CONTEXT,"根据The Athletic的皇马跟队记者马里奥-科尔特加纳的报道，皇马近几个月已经多次询问了国米前锋劳塔罗的情况。\n" );
        db.insert(TABLE_NEWS, null, values);
        values.clear();
        values.put(COLUMN_NEWS_ID,"8");
        values.put(COLUMN_NEWS_TITLE,"陈洋：队员们没有缩在半场防守，但中场控制力确实不如海港");
        values.put(COLUMN_CONTEXT,"长春亚泰主教练陈洋在球队0-3负于海港的赛后表示，球队的中场控制力确实不如海港队。\n" );
        db.insert(TABLE_NEWS, null, values);
        values.clear();

        db.execSQL(CREATE_TABLE_SCORES); // 创建积分表

        values.put(COLUMN_POINTS_TEAM, "上海海港 ");
        values.put(COLUMN_POINTS_SAI, 9);
        values.put(COLUMN_POINTS_WIN, 7);
        values.put(COLUMN_POINTS_PING, 2);
        values.put(COLUMN_POINTS_LOSS, 0);
        values.put(COLUMN_POINTS_GOAL, 23);
        values.put(COLUMN_POINTS, 23);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "成都蓉城 ");
        values.put(COLUMN_POINTS_SAI, 10);
        values.put(COLUMN_POINTS_WIN, 5);
        values.put(COLUMN_POINTS_PING, 5);
        values.put(COLUMN_POINTS_LOSS, 0);
        values.put(COLUMN_POINTS_GOAL, 12);
        values.put(COLUMN_POINTS, 20);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "上海申花 ");
        values.put(COLUMN_POINTS_SAI, 10);
        values.put(COLUMN_POINTS_WIN, 5);
        values.put(COLUMN_POINTS_PING, 4);
        values.put(COLUMN_POINTS_LOSS, 1);
        values.put(COLUMN_POINTS_GOAL, 7);
        values.put(COLUMN_POINTS, 19);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "天津津门虎 ");
        values.put(COLUMN_POINTS_SAI, 10);
        values.put(COLUMN_POINTS_WIN, 4);
        values.put(COLUMN_POINTS_PING, 6);
        values.put(COLUMN_POINTS_LOSS, 0);
        values.put(COLUMN_POINTS_GOAL, 8);
        values.put(COLUMN_POINTS, 18);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "长春亚泰 ");
        values.put(COLUMN_POINTS_SAI, 9);
        values.put(COLUMN_POINTS_WIN, 5);
        values.put(COLUMN_POINTS_PING, 2);
        values.put(COLUMN_POINTS_LOSS, 2);
        values.put(COLUMN_POINTS_GOAL, 12);
        values.put(COLUMN_POINTS, 17);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "武汉三镇 ");
        values.put(COLUMN_POINTS_SAI, 10);
        values.put(COLUMN_POINTS_WIN, 3);
        values.put(COLUMN_POINTS_PING, 5);
        values.put(COLUMN_POINTS_LOSS, 2);
        values.put(COLUMN_POINTS_GOAL, 11);
        values.put(COLUMN_POINTS, 14);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "北京国安 ");
        values.put(COLUMN_POINTS_SAI, 10);
        values.put(COLUMN_POINTS_WIN, 3);
        values.put(COLUMN_POINTS_PING, 5);
        values.put(COLUMN_POINTS_LOSS, 2);
        values.put(COLUMN_POINTS_GOAL, 12);
        values.put(COLUMN_POINTS, 14);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "山东泰山 ");
        values.put(COLUMN_POINTS_SAI, 9);
        values.put(COLUMN_POINTS_WIN, 2);
        values.put(COLUMN_POINTS_PING, 6);
        values.put(COLUMN_POINTS_LOSS, 1);
        values.put(COLUMN_POINTS_GOAL, 6);
        values.put(COLUMN_POINTS, 12);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "广州恒大 ");
        values.put(COLUMN_POINTS_SAI, 10);
        values.put(COLUMN_POINTS_WIN, 1);
        values.put(COLUMN_POINTS_PING, 8);
        values.put(COLUMN_POINTS_LOSS, 1);
        values.put(COLUMN_POINTS_GOAL, 5);
        values.put(COLUMN_POINTS, 11);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "重庆力帆 ");
        values.put(COLUMN_POINTS_SAI, 9);
        values.put(COLUMN_POINTS_WIN, 1);
        values.put(COLUMN_POINTS_PING, 6);
        values.put(COLUMN_POINTS_LOSS, 2);
        values.put(COLUMN_POINTS_GOAL, 6);
        values.put(COLUMN_POINTS, 9);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "沈阳东进 ");
        values.put(COLUMN_POINTS_SAI, 9);
        values.put(COLUMN_POINTS_WIN, 1);
        values.put(COLUMN_POINTS_PING, 5);
        values.put(COLUMN_POINTS_LOSS, 3);
        values.put(COLUMN_POINTS_GOAL, 6);
        values.put(COLUMN_POINTS, 8);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "深圳南城 ");
        values.put(COLUMN_POINTS_SAI, 10);
        values.put(COLUMN_POINTS_WIN, 1);
        values.put(COLUMN_POINTS_PING, 4);
        values.put(COLUMN_POINTS_LOSS, 5);
        values.put(COLUMN_POINTS_GOAL, 7);
        values.put(COLUMN_POINTS, 7);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "山东鲁能");
        values.put(COLUMN_POINTS_SAI, 9);
        values.put(COLUMN_POINTS_WIN, 1);
        values.put(COLUMN_POINTS_PING, 3);
        values.put(COLUMN_POINTS_LOSS, 5);
        values.put(COLUMN_POINTS_GOAL, 7);
        values.put(COLUMN_POINTS, 6);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "大连一方");
        values.put(COLUMN_POINTS_SAI, 9);
        values.put(COLUMN_POINTS_WIN, 1);
        values.put(COLUMN_POINTS_PING, 3);
        values.put(COLUMN_POINTS_LOSS, 5);
        values.put(COLUMN_POINTS_GOAL, 6);
        values.put(COLUMN_POINTS, 6);
        db.insert(TABLE_POINTS, null, values);

        values.clear();
        values.put(COLUMN_POINTS_TEAM, "青岛黄海");
        values.put(COLUMN_POINTS_SAI, 9);
        values.put(COLUMN_POINTS_WIN, 1);
        values.put(COLUMN_POINTS_PING, 2);
        values.put(COLUMN_POINTS_LOSS, 6);
        values.put(COLUMN_POINTS_GOAL, 4);
        values.put(COLUMN_POINTS, 5);
        db.insert(TABLE_POINTS, null, values);



    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 实现数据库升级逻辑，如需要更新表结构等



    }

    // 添加用户信息到数据库
    public long addUser(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        return db.insert(TABLE_USERS, null, values);
    }

    // 根据用户名查询用户信息
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " +
                COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.rawQuery(query, selectionArgs);
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }

    //新闻数据库
    public long news_insert (String id, String title , String context){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NEWS_ID,id);
        values.put(COLUMN_NEWS_TITLE,title);
        values.put(COLUMN_CONTEXT,context);
        values.clear();
        return  db.insert(TABLE_NEWS, null, values);

    }


/*
    private void InitNews(){
        news_insert("1","曾是热身赛之王的国足，这次是怎么错过阿根廷的？","阿根廷来华与澳大利亚的比赛临近，" +
                "关于球票、梅西等话题不断冲上热搜。");
        news_insert("2","维拉2-1布莱顿，力压热刺锁定赛季第七进军欧协联资格赛","北京时间5月29日，英超收官战，阿斯顿维拉主场迎战布莱顿。上半场比赛，" +
                "雅各布-拉姆齐送出两记助攻，道格拉斯-路易斯、沃特金斯先后破门，昂达夫扳回一城；下半场，拉姆齐空门不进。最终维拉主场2-1力克布莱顿，锁定赛季第七名。");
        news_insert("3","马竞2-1皇社，格列兹曼传射，客队输球仍提前一轮获欧冠名额","全场结束，马竞2-1战胜皇家社会，同时皇家社会在输球" +
                "的情况下仍提前一轮获得欧冠名额。");
        news_insert("4","记者：麦卡利斯特将与利物浦签约至2028年，转会费7000万欧起","据阿根廷Tyc记者Germán García Grova报道，" +
                "麦卡利斯特已与自己的父亲及经纪人一同敲定了转会利物浦的细节条款，他将在下赛季成为红军球员。");

    }

 */

    public long updateNews(String newsId, String newTitle, String newContext) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(getNewsTitleColumnName(), newTitle);
        values.put(getNewsContextColumnName(), newContext);

        return db.update(TABLE_NEWS, values, COLUMN_NEWS_ID + " = ?", new String[]{newsId});
    }




    public void deleteNews(String newsId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NEWS, COLUMN_NEWS_ID + " = ?", new String[] { String.valueOf(newsId) });
        db.close();
    }


    public Cursor getAllNews() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(TABLE_NEWS, null, null, null, null, null, null);
    }


    /*
    赛事数据库处理
    插入
    更新
     */
    public long point_insert (String team , int sai , int win , int ping , int loss , int goal ,int pt){//插入比分数据
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_POINTS_TEAM , team);
        values.put(COLUMN_POINTS_SAI,sai);
        values.put(COLUMN_POINTS_WIN,win);
        values.put(COLUMN_POINTS_PING,ping);
        values.put(COLUMN_POINTS_LOSS,loss);
        values.put(COLUMN_POINTS_GOAL,goal);
        values.put(COLUMN_POINTS,pt);
        return db.insert(TABLE_POINTS,null,values);


    }



        public void updateScore(int teamId, int sai, int win, int ping, int loss, int goal, int pt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_POINTS_SAI, sai);
        values.put(COLUMN_POINTS_WIN, win);
        values.put(COLUMN_POINTS_PING, ping);
        values.put(COLUMN_POINTS_LOSS, loss);
        values.put(COLUMN_POINTS_GOAL, goal);
        values.put(COLUMN_POINTS, pt);
        String whereClause = COLUMN_POINTS_ID + " = ?";
        String[] whereArgs = {String.valueOf(teamId)};
        db.update(TABLE_POINTS, values, whereClause, whereArgs);
        db.close();
    }

    public String getNewsTitleColumnName() {
        return COLUMN_NEWS_TITLE;
    }

    public String getNewsContextColumnName() {
        return COLUMN_CONTEXT;
    }

    public String getColumnNewsId(){return COLUMN_NEWS_ID;}

    public  String getTableNews(){
        return TABLE_NEWS;
    }


}
