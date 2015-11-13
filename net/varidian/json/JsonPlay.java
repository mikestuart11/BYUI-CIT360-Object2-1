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

            // nasty paths

            // trying to stringify null, just puts in null and no error
            try {
                String jsonString = JSONUtilities.stringify(null);
                System.out.println("null serializable: " + jsonString);
            }
            catch (Exception e){
                e.printStackTrace();
                return;
            }

            // trying escape characters - doesn't effect anything, escape character doesn't disappear
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


            CourseBean fourthCourse = new CourseBean("OS3", "Ben", 9);
            File file2 = new File("Course2.json");

            // writes write object twice - writes the json string twice making the JSON file syntax wrong
            try {
                FileOutputStream fileOutSteam2 = new FileOutputStream(file2);
                JSONOutputStream jsonOut2 = new JSONOutputStream(fileOutSteam2);
                jsonOut2.writeObject(fourthCourse);
                jsonOut2.writeObject(fourthCourse);
                jsonOut2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


            // input steams and call read object twice - json.JSONException: Invalid JSON String
            File file3 = new File("Course.json");

            try {
                FileInputStream fileInStream1 = new FileInputStream(file3);
                JSONInputStream courseIn = new JSONInputStream(fileInStream1);
                courseIn.readObject();
                courseIn.readObject();
                courseIn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }



            CourseBean seventhCourse = new CourseBean("CS1", "Carson", 5);
            File file4 = new File("CourseWriteTest.json");

            // try to write to a file that I don't have write permissions too - java.io.FileNotFoundException: CourseWriteTest.json (Access is denied)
            try {
                FileOutputStream fileOutSteam2 = new FileOutputStream(file4);
                JSONOutputStream jsonOut2 = new JSONOutputStream(fileOutSteam2);
                jsonOut2.writeObject(seventhCourse);
                jsonOut2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }



            File file5 = new File("CourseReadTest.json");

            // try to read a JSON file that I don't have read permissions too - java.io.FileNotFoundException: CourseReadTest.json (Access is denied)
            try {
                FileInputStream fileInStream1 = new FileInputStream(file5);
                JSONInputStream courseIn = new JSONInputStream(fileInStream1);
                courseIn.readObject();
                courseIn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


            // read object on an empty file, image, word doc, etc
            File file6 = new File("visio.PNG");

            // try to read a JSON file that I don't have read permissions too - JSONException: Invalid JSON String
            try {
                FileInputStream fileInStream1 = new FileInputStream(file6);
                JSONInputStream courseIn = new JSONInputStream(fileInStream1);
                courseIn.readObject();
                courseIn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


            File file7 = new File("Journal.docx");

            // try to read a JSON file that I don't have read permissions too - JSONException: Invalid JSON String
            try {
                FileInputStream fileInStream1 = new FileInputStream(file7);
                JSONInputStream courseIn = new JSONInputStream(fileInStream1);
                courseIn.readObject();
                courseIn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


            // pass jsonoutputstream constructor a null and call write object - java.lang.NullPointerException
            CourseBean tenthCourse = new CourseBean("Web1", "Silver", 1);
            File file8 = new File("CourseWeb.json");


            try {
                FileOutputStream fileOutSteam1 = new FileOutputStream(file8);
                JSONOutputStream jsonOut = new JSONOutputStream(null);
                jsonOut.writeObject(tenthCourse);
                jsonOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // pass jsoninputstream constructor a null call read object - java.lang.NullPointerException
            File file9 = new File("Course.json");

            try {
                FileInputStream fileInStream1 = new FileInputStream(file9);
                JSONInputStream courseIn = new JSONInputStream(null);
                courseIn.readObject();
                courseIn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

}
