package inputReadFile;

import java.io.*;
import java.util.StringTokenizer;

public class FileProcessor {

    public static void main(String[] args) throws IOException {
        FileInputStream myInputStream = null;
        FileOutputStream myOutputStream = null;
        try {
            File newFile = new File("D:\\JAVA codes\\InputFileReadDemo\\src\\inputReadFile\\Persons.txt");
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            myOutputStream = new FileOutputStream(newFile);
            myInputStream = new FileInputStream(newFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the number of people to register: ");
            int numPeople = Integer.parseInt(reader.readLine());
//            Person p = new Person();
            Person[] p = new Person[numPeople];
            for (int i=0; i < numPeople; i++) {
                p[i] = new Person();
                System.out.println("Enter person " + (i+1) + "'s first name");
                p[i].setFirstName(reader.readLine());
                System.out.println("Enter person " + (i+1) + "'s last name");
                p[i].setLastName(reader.readLine());
                System.out.println("Enter person " + (i+1) + "'s age");
                p[i].setAge(Integer.parseInt(reader.readLine()));
                System.out.println("Enter person " + (i+1) + "'s gender");
                String gender = reader.readLine();
                if (gender.equalsIgnoreCase("male")) {
                    p[i].setGender(EGender.MALE);
                } else if (gender.equalsIgnoreCase("female")) {
                    p[i].setGender(EGender.FEMALE);
                } else {
                    p[i].setGender(EGender.OTHER);
                }
                String person = p[i].getFirstName() + "," + p[i].getLastName() + "," + p[i].getAge() + "," + p[i].getGender() + "\r\n";
                for (char c : person.toCharArray()) {
                    myOutputStream.write(c);
                }
            }
            int c;
            StringBuilder sb = new StringBuilder();
            Person[] printPerson = new Person[numPeople];
            while ((c = myInputStream.read()) != -1) {
                sb.append((char) c);
            }
            String lines = sb.toString();
            StringTokenizer tokens = new StringTokenizer(lines, "\r\n");
            int i = 0;
            while(tokens.hasMoreTokens()) {
                printPerson[i] = new Person();
                String token = tokens.nextToken();
                StringTokenizer personValues = new StringTokenizer(token, ",");
                printPerson[i].setFirstName(personValues.nextToken());
                printPerson[i].setLastName(personValues.nextToken());
                printPerson[i].setAge(Integer.parseInt(personValues.nextToken()));
                String genderTok = personValues.nextToken();
                if (genderTok.equalsIgnoreCase("MALE")) {
                    printPerson[i].setGender(EGender.MALE);
                } else if (genderTok.equalsIgnoreCase("FEMALE")) {
                    printPerson[i].setGender(EGender.FEMALE);
                } else {
                    printPerson[i].setGender(EGender.OTHER);
                }
                i++;
            }
            System.out.println("\r\n");
            System.out.println("The registered users found in the file are: ");
            for (int j = 0; j< numPeople; j++) {
                System.out.println(printPerson[j].getFirstName() + " " + printPerson[j].getLastName() + " aged " + printPerson[j].getAge() + " years old and the gender is " + printPerson[j].getGender());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (myInputStream != null) {
                myInputStream.close();
            }
        }
    }
}
