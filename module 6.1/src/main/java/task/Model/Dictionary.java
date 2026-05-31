//The Dictionary class (Model) should be responsible for managing the dictionary data.
//It should include at least the following methods:
//
//A method to add a word and its meaning to the dictionary.
//A method to search for a word in the dictionary and retrieve its meaning.
package task.Model;

import java.util.Hashtable;

public class Dictionary {
    static java.util.Dictionary<String, String> dict = new Hashtable<>();
    public Dictionary() {}
    public void add(String string, String value){
        dict.put(string, value);
    }
    public String get(String string){
        return dict.get(string);
    }
    public void remove(String string){
        if (dict.get(string) != null){
            dict.remove(string);
        }
    }
}
