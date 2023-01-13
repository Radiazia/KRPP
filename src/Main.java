import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    static String max(String par)
    {
        String[]words=par.split(" ");
        String resstring="";
        for(String word: words)
        {
            if(word.length()>resstring.length())
                resstring=word;
        }
        return(resstring);
    }

    public static void main(String[] args) throws IOException
    {
        String decryptedMessage = "", maxword;
        char ch; int key = 1;

        String file1 = Files.readString(Path.of("C:\\Users\\trfdc\\IdeaProjects\\KR PP\\out\\production\\KR PP\\input1.txt"));
        String file2 = Files.readString(Path.of("C:\\Users\\trfdc\\IdeaProjects\\KR PP\\out\\production\\KR PP\\input2.txt"));

        for(int j=1; j<26; j++)
        {
            for(int i = 0; i < file1.length(); ++i)
            {
                ch = file1.charAt(i);
                if(ch >= 'a' && ch <= 'z')
                {
                    ch = (char)(ch - key);
                    if(ch < 'a')
                    {
                        ch = (char)(ch + 'z' - 'a' + 1);
                    }
                    decryptedMessage += ch;
                }
                else if(ch >= 'A' && ch <= 'Z')
                {
                    ch = (char)(ch - key);
                    if(ch < 'A')
                    {
                        ch = (char)(ch + 'Z' - 'A' + 1);
                    }
                    decryptedMessage += ch;
                }
                else
                {
                    decryptedMessage += ch;
                }
            }

            maxword = max(file2);
            int match = decryptedMessage.indexOf(maxword);

            if (match>0)
            {
                Files.writeString(Path.of("C:\\Users\\trfdc\\IdeaProjects\\KR PP\\out\\production\\KR PP\\output.txt"), decryptedMessage);
                break;
            }
            else
            {
                key++;
                decryptedMessage = "";
            };
        }
    }
}




