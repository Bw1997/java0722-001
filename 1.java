import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class MongoDbTest001 {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("192.168.188.140", 27017);
        //使用客户端连接到具体的数据库
        MongoDatabase database = mongoClient.getDatabase("db1");
        //获取指定集合
        MongoCollection<Document> collection = database.getCollection("user");

        //新增
      /*  Map<String,Object> map=new HashMap<>();
        map.put("id","9009");
        map.put("name","张三");
        map.put("address","朝阳五方桥");

        //创建文档对象
        Document document1 = new Document(map);
        //保存到指定集合
        collection.insertOne(document1);*/

      //删除
        //创建删除条件对象
        BasicDBObject basicDBObject = new BasicDBObject("age", 27);
        collection.deleteOne(basicDBObject);

        //查询集合的全部内容
        FindIterable<Document> iterable = collection.find();

        for (Document document : iterable) {
            System.out.println(document);
        }



        mongoClient.close();
    }
}
