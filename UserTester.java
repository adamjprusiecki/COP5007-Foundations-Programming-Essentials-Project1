/*
 * Project 1
 * UserTester.java
 * 
 * File that tests User.java, and prints results from cipher.
 * 
 * @author Adam Prusiecki
 * @version 1.0
 * @since 2023/07/02
 */

public class UserTester
{
    public static void main(String[] args)
    {
        //Arbitrary user1
        //Example of parameterized constructor and use of toString()
        //NOTE: The encrypted password matches perfectly with the example from the project guide
        User u1 = new User("Jsmith", "password", "house");
        System.out.println(u1.toString());

        //Arbitrary user2
        //Example of default constructor and use of setters and use of toString()
        User u2 = new User();
        u2.setUserName("aprusiecki");
        u2.setKey("s1F@v_");
        u2.setClearPassword("3qci?fbZ!kDTE2UdZ83C");
        System.out.println(u2.toString());
        
        //Arbitrary user3
        //Example of default constructor and use of getters and setters
        User u3 = new User();
        String u3Name = "foouser";
        String u3Password = "V3ryS3cur3P@$$w0rd";
        String u3Key = "enterkeyhere";

        /*
         * Unit Tests for User class setters and getters
         */
        System.out.println("***Testing User class setters and getters***\n");
        
        
        System.out.println("Testing username:");
        u3.setUserName(u3Name);
        System.out.print("    Passed: ");
        System.out.println(u3Name == u3.getUserName());
        System.out.println("    Expecting: " + u3Name);
        System.out.println("    Result: " + u3.getUserName());
        
        System.out.println("Testing key:");
        u3.setKey(u3Key);
        System.out.print("    Passed: ");
        System.out.println(u3Key == u3.getKey());
        System.out.println("    Expecting: " + u3Key);
        System.out.println("    Result: " + u3.getKey());

        System.out.println("Testing clear password:");
        u3.setClearPassword(u3Password);
        System.out.print("    Passed: ");
        System.out.println(u3Password == u3.getClearPassword());
        System.out.println("    Expecting: " + u3Password);
        System.out.println("    Result: " + u3.getClearPassword());

        System.out.println("Encrypted Password: ");
        System.out.println("    Result:" + u3.getEncryptedPassword());
    }
}