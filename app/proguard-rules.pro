#==================友盟统计 开始======================
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}
-keep public class com.duoma.dmcg.R$*{
public static final int *;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#==================友盟统计 结束======================

