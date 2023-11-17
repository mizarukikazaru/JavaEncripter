
public class Main

{

  public static String a_to_z = "abcdefghijklmnopqrstuvwsyz" + " ";

  public static int[] keys = {1,2,3};

 

 

  public static String encode (String origin_string)

  {

 

    String encoded_string = "";

 

    for (int i = 0, key_num = 0; i < origin_string.length (); i++, key_num++)

      {

 

if (key_num >= keys.length)

  key_num = 0;

 

int number = count_number (origin_string.charAt (i) + "");

 

if (number != -1)

  {

    encoded_string +=

      a_to_z.charAt ((number + keys[key_num]) % a_to_z.length()) + "";

  }

else

  encoded_string += origin_string.charAt (i);

 

      }

    return encoded_string;

 

  } //encode end

 

  public static String decode (String encoded_string)

  {

    int start_key_index =keys.length - encoded_string.length()%keys.length-1;

    String origin_word = "";

 

    for (int i = 0, key_index = 0; i < encoded_string.length ();

 i++, key_index++){

     

     if(key_index>=keys.length)

        key_index=0;

 

int number = count_number (encoded_string.charAt (i) + "");

 

if (number - keys[key_index] < 0)

  origin_word += a_to_z.charAt (a_to_z.length() - (keys[key_index] - number)) + "";

else

  origin_word += a_to_z.charAt (number - keys[key_index]) + "";

    }

    return origin_word;

  }

 

 

 

  public static int count_number (String char_to_check)

  {

    for (int i = 0; i < a_to_z.length (); i++){

  if ((a_to_z.charAt(i)+"").equals (char_to_check))

  return i;

      }

     System.out.println("not found :"+char_to_check);

    return -1;

  }

 

  public static void main (String[]args){

    String encoded_string = encode ("abcd abcd");

    String origin_word = decode (encoded_string);

    System.out.println (encoded_string + "\n" + origin_word);

  }

}

 
