/*
 * Project 1
 * User.java
 * 
 * User class that stores 4 private variables, username, clearPassword,
 * encryptedPassword, key. Takes in the first three mentioned variables, encrypts
 * clearPassword using the Vigenère cipher, storing the result in encryptedPassword.
 * 
 * @author Adam Prusiecki
 * @version 1.0
 * @since 2023/07/02
 */

public class User
{
    //Class Variables
    private String username;
    private String clearPassword;
    private String encryptedPassword;
    private String key;

    /*
     * Default constructor, sets all class variables to 'default' a value 
     * relative to their types.
     */
    public User()
    {
        this.username = "";
        this.clearPassword = "";
        this.encryptedPassword = "";
        this.key = "";
    }

    /*
     * Parameterized constructor, takes in and sets class variables for 
     * userName, clearPassword, and key. Calls encrypt method to encrypt clearPassword
     * with Vigenère cipher and set relative class variable.
     */
    public User(String userName, String clearPassword, String key)
    {
        this.username = userName;
        this.clearPassword = clearPassword;
        this.key = key;
        this.encrypt();
    }

    /*
     * Getters and Setters, boilerplate.
     */

    public String getUserName()
    {
        return this.username;
    }

    public void setUserName(String userName)
    {
        this.username = userName;
    }

    public String getClearPassword()
    {
        return this.clearPassword;
    }

    /*
     * Calls encrypt method when clearPassword is set.
     */
    public void setClearPassword(String clearPassword)
    {
        this.clearPassword = clearPassword;
        this.encrypt();
    }

    public String getEncryptedPassword()
    {
        return this.encryptedPassword;
    }

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    /*
     * Encrypt method that uses Vigenère cipher to set class variable 
     * encryptedPassword. Uses '!' as an arbitrary starting point and 'z'
     * as an arbitrary ending point. 
     * 
     * Populates a "matrix" as a 2D array, where the corresponding element relative
     * to the [key character][password character] is the correct encrypted value. 
     */
    private void encrypt()
    {
        char start = '!'; // Arbitrary character start
        char end = 'z'; // Arbitrary character end
        int range = end - start + 1; // Arbitrary range

        char[][] cipherTable = new char[range][range]; // 2D array that gets populated using the Vigenère cipher "matrix" format
        char nextChar;

        /* 
         * Populates cipherTable from Arbitrary character start to Arbitrary character end
        */
        for(int i = 0; i < range; i++)
        {
            for(int j = 0; j < range; j++)
            {
                nextChar = (char)(j + i + start);
                if(nextChar > end) // If ascii value is greater than end character, loop back to starting character
                {
                    nextChar = (char)(start + (nextChar - end - 1));
                }
                cipherTable[i][j] = nextChar; // Assign next character in row
            }
        }

        int keyIndex = 0; // Index to know when to loop key back to beginning
        String encryptedPass = "";

        /* Iterates through this.clearPassword and encrypts each character relative to the cipherTable */
        for(int i = 0; i < this.getClearPassword().length(); i++)
        {
            encryptedPass += cipherTable[this.getKey().charAt(keyIndex) - start][this.getClearPassword().charAt(i) - start]; // cipherTable[key char][password char]
            keyIndex++;
            if(keyIndex == this.key.length())
            {
                keyIndex = 0; // Loop keyIndex back to start
            }
        }
        this.encryptedPassword = encryptedPass; // Assign class variable instance with encrypted password
    }

    /*
     * Formats all class variables into nicely formatted list
     * 
     * //
     * UserName: <>
     * Encrypted Password: <>
     * Password: <>
     * Key: <>
     * 
     * //
     */
    public String toString()
    {
        return "Username: " + this.getUserName()
        + "\nEncrypted Password: " + this.getEncryptedPassword()
        + "\nPassword: " + this.getClearPassword()
        + "\nKey: " + this.getKey()
        + "\n";
    }
}