package com.myproject;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class App {
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        // Stanard connection string
        // String uri = "mongodb+srv://jpmc-java-test.fl6ba.mongodb.net/?authSource=%24external&authMechanism=MONGODB-AWS";

        // Private endpoint connection string
        String uri = "mongodb+srv://jpmc-java-test-pl-0.fl6ba.mongodb.net/?authSource=%24external&authMechanism=MONGODB-AWS";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("jpmc-test");
            MongoCollection<Document> collection = database.getCollection("coll");

            Document doc = collection.find(eq("foo", "bar")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}
