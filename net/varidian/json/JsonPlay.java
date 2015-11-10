package net.varidian.json;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;
import org.quickconnectfamily.json.JSONException;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;


public class JsonPlay {


    public static void main(String[] args) {

            CourseBean firstCourse = new CourseBean("Java", "King", 2);

            // happy paths

            // prints out a JSON formatted string from a Java object
            try {
                String jsonString = JSONUtilities.stringify(firstCourse);
                System.out.println("Converted Java Object to JSON String: " + jsonString);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }


            String CourseBeanJSONString = "{\"courseName\":\"Web Development\",\"teacher\":\"Craig\"" +
                    ",\"section\":\"3\"}";


            // converts a JSON formatted string into a Java object
            try {
                HashMap hmap = (HashMap)JSONUtilities.parse(CourseBeanJSONString);

                String string1 = (String)hmap.get("courseName");
                String string2 = (String)hmap.get("teacher");
                int int1 = Integer.parseInt((String)hmap.get("section"));

                CourseBean secondCourse = new CourseBean(string1, string2, int1);
                String jsonString2 = JSONUtilities.stringify(secondCourse);
                System.out.println("Converted Java Object to JSON String: " + jsonString2);
            }
            catch (JSONException e){
                e.printStackTrace();
            }


            CourseBean thirdCourse = new CourseBean("OS2", "Jack", 7);
            File file1 = new File("Course.json");

            // writes a JSON file to disk from a bean
            try {
                FileOutputStream fileOutSteam1 = new FileOutputStream(file1);
                JSONOutputStream jsonOut = new JSONOutputStream(fileOutSteam1);
                jsonOut.writeObject(thirdCourse);
                jsonOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // reads a JSON file and outputs it
            try {
                FileInputStream fileInStream1 = new FileInputStream("Course.json");
                JSONInputStream courseIn = new JSONInputStream(fileInStream1);
                HashMap courseHashMap = (HashMap)courseIn.readObject();
                courseIn.close();

                CourseBean fourthCourse = new CourseBean(courseHashMap);

                String jsonString3 = JSONUtilities.stringify(fourthCourse);
                System.out.println("Read in a JSON File Course.JSON: " + jsonString3);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // nasty paths - finish

            // trying a null
            try {
                String jsonString = JSONUtilities.stringify(null);
                System.out.println("null serializable: " + jsonString);
            }
            catch (Exception e){
                e.printStackTrace();
                return;
            }

            // trying escape characters
            String escapeCharacters = "does this work with \"escape characters\"";
            CourseBean escapeCourse = new CourseBean(escapeCharacters, "King", 2);
            try {
                String jsonString = JSONUtilities.stringify(escapeCourse);
                System.out.println(jsonString);
            }
            catch (Exception e){
                e.printStackTrace();
                return;
            }

    }




}
